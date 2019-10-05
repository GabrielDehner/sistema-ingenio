/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladoraPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Visual.MenuPrincipal;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author gabrieldehner
 */
public class ControladoraLogica {

    private static ControladoraPersistencia contPersistencia = new ControladoraPersistencia();
    private List<Producto> productos = new LinkedList(contPersistencia.getProducto());

    /*public void altaProducto(String idProducto, String nombreProducto, int cantidadMinimaMayorista, double precioMayorista, double precioMinorista) throws ExceptionBusqueda, PreexistingEntityException {
     Producto unProducto = new Producto(idProducto, nombreProducto, cantidadMinimaMayorista,
     precioMayorista, precioMinorista);
     if(this.buscarProducto(idProducto)==null){
     productos.add(unProducto);
     contPersistencia.altaProducto(unProducto);
     }else{
     throw new ExceptionBusqueda("Ya existe el Producto con el id ingresado");
     }
     }
     public void borrarProducto(String id) throws ExceptionBusqueda{
     Producto unProducto=this.buscarProducto(id);
     unProducto.setBorradoLogico(true);
     contPersistencia.bajaProducto(unProducto);
     }
     public void modificarProducto(String idProducto, String nombreProducto, int cantidadMinimaMayorista,
     double precioMayorista, double precioMinorista) throws ExceptionBusqueda, NonexistentEntityException{
     Producto unProducto = this.buscarProducto(idProducto);
     unProducto.setIdProducto(idProducto);
     unProducto.setNombreProducto(nombreProducto);
     unProducto.setCantidadMinimaMayorista(cantidadMinimaMayorista);
     unProducto.setPrecioMayorista(precioMayorista);
     unProducto.setPrecioMinorista(precioMinorista);
        
     contPersistencia.modificarProducto(unProducto);
     }
     public Producto buscarProducto(String idProducto) throws ExceptionBusqueda {
     Producto unProducto = null;
     boolean noSalirDelBucle = true;
     this.productos = contPersistencia.getProducto();
     Iterator<Producto> iteradorProducto = productos.iterator();
     while (iteradorProducto.hasNext() && noSalirDelBucle) {
     unProducto = iteradorProducto.next();
     if (unProducto.isIdProducto(idProducto)) {
     noSalirDelBucle = false;
     } else {
     unProducto = null;
     }
     }
     if (unProducto == null) {
     //Usar excepciones
     }
     return unProducto;
     }
     public List<Producto> dameTodosLosProductos() {
     return productos;
     }
    
     public List<Producto> dameTodosLosProductosActivos() {
     List<Producto> arts=new LinkedList();
     for(Producto aux : productos){
     if(!aux.getBorradoLogico()){
     arts.add(aux);
     }
     }
        
     return arts;
     }
     */
    public void actualizarProductos(String path, Double porcentajeRecarga) throws PreexistingEntityException, NonexistentEntityException {
        AdministradorDtosExcel admExcel = new AdministradorDtosExcel();
        this.productos = contPersistencia.getProducto();
        HashMap<String, Producto> productos = admExcel.readExcelFile(path, porcentajeRecarga);
        /*Iterator it = productos.iterator();
         while (it.hasNext()) {
         Producto unProducto = (Producto) it.next();
         if (unProducto.getPrecioProveedor() != 0) {
         Producto unProductoAuxiliar = this.buscarProducto(unProducto.getCodigo());
         if (unProductoAuxiliar == null) {
         contPersistencia.altaProducto(unProducto);
         //System.out.println(unProducto.getCodigo() + " " + unProducto.getDescripcion() + " " + unProducto.getScanner() + " " + unProducto.getPrecioProveedor());
         } else {
         if (unProducto.getPrecioProveedor() != unProductoAuxiliar.getPrecioProveedor()) {
         contPersistencia.modificarProducto(unProducto);
         }
         }
         System.out.println(unProducto.getCodigo() + " " + unProducto.getDescripcion() + " " + unProducto.getScanner() + " " + unProducto.getPrecioProveedor());

         }
         }*/
        Iterator it = this.productos.iterator();
        while (it.hasNext() && !productos.isEmpty()) {
            Producto unProducto = (Producto) it.next();
            Producto unProductoAuxiliar = productos.get(unProducto.getCodigo());
            if (unProductoAuxiliar != null) {
                productos.remove(unProductoAuxiliar.getCodigo());
                if (!Double.toString(unProducto.getPrecioProveedor()).equals(Double.toString(unProductoAuxiliar.getPrecioProveedor()))
                        || !Double.toString(unProducto.getPorcentaje()).equals(Double.toString(unProductoAuxiliar.getPorcentaje()))) {
                    System.out.print("DIFERENCIAS: " + unProducto.getPrecioProveedor() + "  " + unProductoAuxiliar.getPrecioProveedor());
                    contPersistencia.modificarProducto(unProductoAuxiliar);
                    System.out.println("Modificar: " + unProductoAuxiliar.getCodigo() + " " + unProductoAuxiliar.getDescripcion() + " " + unProductoAuxiliar.getScanner() + " " + unProductoAuxiliar.getPrecioProveedor());
                }

            } //porque no esta en los que seran modificados.. ni tocar

            /*if (unProducto.getPrecioProveedor() != 0) {
             Producto unProductoAuxiliar = this.buscarProducto(unProducto.getCodigo());
             if (unProductoAuxiliar == null) {
             contPersistencia.altaProducto(unProducto);
             //System.out.println(unProducto.getCodigo() + " " + unProducto.getDescripcion() + " " + unProducto.getScanner() + " " + unProducto.getPrecioProveedor());
             } else {
             if (unProducto.getPrecioProveedor() != unProductoAuxiliar.getPrecioProveedor()) {
             contPersistencia.modificarProducto(unProducto);
             }
             }
             System.out.println(unProducto.getCodigo() + " " + unProducto.getDescripcion() + " " + unProducto.getScanner() + " " + unProducto.getPrecioProveedor());

             }*/
        }
        /*while (!productos.isEmpty()) {
         Producto unProductoAuxiliar = productos.get(unProducto.getCodigo());
         }*/
        Iterator itMap = productos.keySet().iterator();
        while (itMap.hasNext() && !productos.isEmpty()) {
            String key = (String) itMap.next();
            Producto unProductoAuxiliar = productos.get(key);
            if (unProductoAuxiliar.getPrecioProveedor() != 0.0) {
                contPersistencia.altaProducto(unProductoAuxiliar);
                System.out.println("Alta: " + unProductoAuxiliar.getCodigo() + " " + unProductoAuxiliar.getDescripcion() + " " + unProductoAuxiliar.getScanner() + " " + unProductoAuxiliar.getPrecioProveedor());
            }
        }

        /*
         desp procesar los que quedan pq no existen o no corresponden
         */
    }

    public Producto buscarProducto(String idProducto) {
        Producto unProducto = null;
        boolean noSalirDelBucle = true;
        this.productos = contPersistencia.getProducto();
        Iterator<Producto> iteradorProducto = productos.iterator();
        while (iteradorProducto.hasNext() && noSalirDelBucle) {
            unProducto = iteradorProducto.next();
            if (unProducto.isCodigoProducto(idProducto)) {
                noSalirDelBucle = false;
            } else {
                unProducto = null;
            }
        }
        /*if (unProducto == null) {
         //Usar excepciones
         }*/
        return unProducto;
    }

    public Producto buscarProductoIdScanner(String idProducto) {
        Producto unProducto = null;
        boolean noSalirDelBucle = true;
        this.productos = contPersistencia.getProducto();
        Iterator<Producto> iteradorProducto = productos.iterator();
        while (iteradorProducto.hasNext() && noSalirDelBucle) {
            unProducto = iteradorProducto.next();
            if (unProducto.isCodigoProductoScanner(idProducto)) {
                noSalirDelBucle = false;
            } else {
                unProducto = null;
            }
        }
        /*if (unProducto == null) {
         //Usar excepciones
         }*/
        return unProducto;
    }

    public LinkedList<Producto> buscarProductoNombre(String idProducto) {
        Producto unProducto = null;
        LinkedList<Producto> productosBusqueda= new LinkedList();
        this.productos = contPersistencia.getProducto();
        Iterator<Producto> iteradorProducto = productos.iterator();
        while (iteradorProducto.hasNext()) {
            unProducto = iteradorProducto.next();
            if (unProducto.isCodigoProductoNombre(idProducto)) {
                productosBusqueda.add(unProducto);
            } 
        }
        if (unProducto == null) {
            //Usar excepciones
        }
        return productosBusqueda;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Funciona compila");
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.show();
        System.out.println("Fin");
    }

}
