package co.edu.uniquindio.poo.carrito;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CarritoIterator<T> implements Iterator<T> {

    private int indice = 0;
    private final List<T> lista;

    public CarritoIterator(List<T> lista) {
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return indice < lista.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay elementos");
        }
        return lista.get(indice++);
    }

    public boolean tieneParaAtras() {
        return indice > 0;
    }

    public T deParaAtras() {
        if (!tieneParaAtras()) {
            throw new NoSuchElementException("No hay elementos");
        }
        return lista.get(--indice);
    }

    public boolean hasNextSalto() {
        return indice < lista.size();
    }

    public T saltarNext() {
        if (!hasNextSalto()) {
            throw new NoSuchElementException("No hay elementos");
        }
        T t = lista.get(indice);
        indice += 2;
        return t;
    }
}