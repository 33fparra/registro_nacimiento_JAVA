/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author yayi
 */
public class RegistroProducto implements Serializable {

    private static ArrayList<Producto> listaProductos;

    public RegistroProducto() {
        listaProductos = new ArrayList<Producto>();
    }

    public void agregarProducto(Producto nuevoProducto) {
        listaProductos.add(nuevoProducto);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public static void eliminarProducto(Producto productoEliminar) {
        listaProductos.remove(productoEliminar);
    }

    public static Producto buscarProducto(int codigo) {
        Producto prod = null;
        for (Producto temp : listaProductos) {
            if (temp.getCodigo() == codigo) {
                prod = temp;
                break;
            }
        }
        return prod;
    }
}
