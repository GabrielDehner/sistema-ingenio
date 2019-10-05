/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author gabrieldehner
 */
@Entity
public class Producto implements Serializable {

    @Id
    private String codigo;
    @Basic
    private String scanner;
    @Basic
    private String descripcion;
    @Basic
    private Double precioProveedor;
    @Basic
    private Double porcentaje;
    @Basic
    private Double precio;
    @Basic
    private int cantidadUnidades;
    @Basic
    private Double precioAnterior;

    public Producto() {
    }

    public Producto(String codigo, String scanner, String descripcion, Double precioProveedor, Double porcentaje, Double precio, int cantidadUnidades) {
        this.codigo = codigo;
        this.scanner = scanner;
        this.descripcion = descripcion;
        this.precioProveedor = precioProveedor;
        this.porcentaje = porcentaje;
        this.precio = precio;
        this.cantidadUnidades = cantidadUnidades;
    }

    public Producto(Double porcentaje, Double precio, int cantidadUnidades) {
        this.codigo = "-1";
        this.porcentaje = porcentaje;
        this.precio = precio;
        this.cantidadUnidades = cantidadUnidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(Double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public Double getPrecioAnterior() {
        return precioAnterior;
    }

    public void setPrecioAnterior(Double precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    public boolean isCodigoProducto(String codigo) {
        boolean retorno = false;
        if (codigo.equals(this.codigo)) {
            retorno = true;
        }
        return retorno;
    }

    public boolean isCodigoProductoScanner(String codigo) {
        boolean retorno = false;
        if (codigo.equals(this.scanner)) {
            retorno = true;
        }
        return retorno;
    }

    public boolean isCodigoProductoNombre(String nombre) {
        boolean retorno = false;
        if (this.descripcion.contains(nombre)) {
            retorno = true;
        }
        return retorno;
    }

}
