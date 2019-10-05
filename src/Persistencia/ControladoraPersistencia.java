/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Producto;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabrieldehner
 */
public class ControladoraPersistencia {
    private ProductoJpaController unProducto;

    public ControladoraPersistencia() {
        unProducto = new ProductoJpaController();
    }

    public void altaProducto(Producto unProducto) throws PreexistingEntityException {
        try {
            this.unProducto.create(unProducto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Producto> getProducto() {
        return this.unProducto.findProductoEntities();
    }

    public void bajaProducto(Producto unProducto) {
        try {
            this.unProducto.edit(unProducto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarProducto(Producto unProducto) throws NonexistentEntityException {
        try {
            this.unProducto.edit(unProducto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
