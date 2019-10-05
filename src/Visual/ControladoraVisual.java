/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;
import Logica.ControladoraLogica;
import Logica.Producto;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.LinkedList;

/**
 *
 * @author gabrieldehner
 */
public class ControladoraVisual {
    private ControladoraLogica controladoraLogica = new ControladoraLogica();
    
    public ControladoraVisual() {
    }
    public void actualizarProductos(String path, Double porcentajeRecarga) throws PreexistingEntityException, NonexistentEntityException{
        this.controladoraLogica.actualizarProductos(path, porcentajeRecarga);
    }
    
    public LinkedList<Producto> buscarProductoNombre(String idProducto) {
        return this.controladoraLogica.buscarProductoNombre(idProducto);
    }
    
    public Producto buscarProductoIdScanner(String idProducto) {
        return this.controladoraLogica.buscarProductoIdScanner(idProducto);
    }
    
    public Producto buscarProducto(String idProducto) {
        return this.controladoraLogica.buscarProducto(idProducto);
    }
}
