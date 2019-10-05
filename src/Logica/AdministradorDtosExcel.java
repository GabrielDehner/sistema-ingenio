/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/*import java.io.File;
 import java.io.FileInputStream;
 import java.util.Iterator;
 
 import org.apache.poi.ss.usermodel.Cell;
 import org.apache.poi.ss.usermodel.Row;
 import org.apache.poi.xssf.usermodel.XSSFSheet;
 import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author gabrieldehner
 */
public class AdministradorDtosExcel {

    public HashMap<String, Producto> readExcelFile(String path, Double porcentajeRecarga) {// hacer una super lista de productos e impactarlos en bd
        //si son nuevos, entonces impactar, si ya estan entonces solo actualizar el precio con iva....
        EncabezadosExcel encExcel = new EncabezadosExcel(-1, -1, -1, -1);
        Map<String, Producto> productos = new HashMap<String, Producto>();
        Producto unProducto; 
        try {
            //String nombreArchivo = "listaprecios.xlsx";
            //String nombreArchivo = "listaprecios.xlsx";
            //String rutaArchivo = "/home/gabrieldehner/Descargas/" + nombreArchivo;
            String rutaArchivo = path;
            //String rutaArchivoExcel = "/ruta/ExcelEjemplo.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(rutaArchivo));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator iterator = firstSheet.iterator();
            DataFormatter formatter = new DataFormatter();
            //int indexComienzo=0;

            while (iterator.hasNext()) {
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                int detectarColumnas = 0;
                unProducto = new Producto(0.0, 0.0, 0);
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    if(encExcel.getCodigo()==detectarColumnas){
                        unProducto.setCodigo(contenidoCelda);
                        //System.out.print(contenidoCelda + " | ");
                    }
                    if(encExcel.getDescripcion()==detectarColumnas){
                        unProducto.setDescripcion(contenidoCelda);
                        //System.out.print(contenidoCelda + " | ");
                    }
                    if(encExcel.getScanner()==detectarColumnas){
                        unProducto.setScanner(contenidoCelda);
                        //System.out.print(contenidoCelda + " | ");
                    }
                    if(encExcel.getPrecioConIva()==detectarColumnas){
                        unProducto.setPrecioProveedor(Double.parseDouble((contenidoCelda.replace(".","")).replace(",", ".")));
                        //System.out.print(contenidoCelda + " | ");
                    }
                    if (!encExcel.todosValoresSeteados()) {
                        if (contenidoCelda.equals("Código")) {
                            encExcel.setCodigo(detectarColumnas);
                        }
                        if (contenidoCelda.equals("Descripcion")) {
                            encExcel.setDescripcion(detectarColumnas);
                        }
                        if (contenidoCelda.equals("Scanner")) {
                            encExcel.setScanner(detectarColumnas);
                        }
                        if (contenidoCelda.equals("Precio c/ IVA")) {
                            encExcel.setPrecioConIva(detectarColumnas);
                        }
                    }
                    
                    

                    detectarColumnas++;
                    //System.out.print(contenidoCelda + " | ");
                    //System.out.println("celda: " + contenidoCelda);
                }
                if(!unProducto.getCodigo().equals("-1")){
                    unProducto.setPorcentaje(porcentajeRecarga);
                    //esto reeverrrr
                    
                    unProducto.setPrecioAnterior(unProducto.getPrecio());
                    if(unProducto.getPrecioProveedor()!=null){
                        unProducto.setPrecio((Double)(unProducto.getPrecioProveedor()*unProducto.getPorcentaje()));
                    }else{
                        unProducto.setPrecioProveedor(0.0);
                    }
                    
                    productos.put(unProducto.getCodigo(), unProducto);
                }
                System.out.println();

            }
            System.out.println(encExcel.getCodigo() + " " + encExcel.getDescripcion() + " " + encExcel.getScanner() + " " + encExcel.getPrecioConIva());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (HashMap<String, Producto>) productos;

    }
}
