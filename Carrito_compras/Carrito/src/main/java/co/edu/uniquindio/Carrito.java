package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Carrito<T extends Producto> implements Iterable<T> {

    private final String nombre;
    private final List<T> listaProductos;

    public Carrito(String nombre) {
        this.nombre = nombre;
        this.listaProductos = new ArrayList<>();
    }

    public Collection<T> getListaProductos() {
        return Collections.unmodifiableCollection(listaProductos);
    }

    public void agregar(T t) {
        if (t == null) {
            throw new IllegalArgumentException("El producto no puede ser null");
        }
        listaProductos.add(t);
    }

    public T obtenerProductoMayor() {
        if (listaProductos.isEmpty()) {
            throw new RuntimeException("No hay productos en el carro aún");
        }
        T mayor = listaProductos.get(0);
        for (T t : listaProductos) {
            if (t.getPrecio() > mayor.getPrecio()) {
                mayor = t;
            }
        }
        return mayor;
    }

    public double calcularPrecioTotal() {
        double total = 0;
        for (T p : listaProductos) {
            total += p.getPrecio();
        }
        return total;
    }

    @Override
    public CarritoIterator<T> iterator() {
        return new CarritoIterator<>(listaProductos);
    }
}