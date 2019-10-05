/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author gabrieldehner
 */
public class EncabezadosExcel {
    private int codigo;
    private int descripcion;
    private int scanner;
    private int precioConIva;

    public EncabezadosExcel() {
    }

    public EncabezadosExcel(int codigo, int descripcion, int scanner, int precioConIva) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.scanner = scanner;
        this.precioConIva = precioConIva;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public int getScanner() {
        return scanner;
    }

    public void setScanner(int scanner) {
        this.scanner = scanner;
    }

    public int getPrecioConIva() {
        return precioConIva;
    }

    public void setPrecioConIva(int precioConIva) {
        this.precioConIva = precioConIva;
    }
    public boolean todosValoresSeteados(){
        boolean retorno = false;
        if(this.getCodigo() != -1 && this.getDescripcion()!= -1 && this.getScanner()!= -1 && this.getPrecioConIva()!= -1){
            retorno = true;
        } 
        return retorno;
    }
    
}
