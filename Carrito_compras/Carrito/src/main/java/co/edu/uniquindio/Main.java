package co.edu.uniquindio;

public class Main {

    public static void main(String[] args) {
        Carrito<Producto> carrito = new Carrito<>("C2");
        carrito.agregar(new Fruta("Manzana", 234));
        carrito.agregar(new Fruta("Pera", 456));
        carrito.agregar(new Moto("Pulsar", 4456000));
        carrito.agregar(new Fruta("Uva", 800));

        System.out.println("Más caro: " + carrito.obtenerProductoMayor());
        System.out.println("Total: $" + carrito.calcularPrecioTotal());

        System.out.println("\nRecorrido normal:");
        for (Producto p : carrito) {
            System.out.println(p);
        }

        System.out.println("\nRecorrido saltando de a 2:");
        CarritoIterator<Producto> salto = carrito.iterator();
        while (salto.hasNextSalto()) {
            System.out.println(salto.saltarNext());
        }

        System.out.println("\nRecorrido hacia atrás:");
        CarritoIterator<Producto> atras = carrito.iterator();
        while (atras.hasNext()) atras.next();   // posicionarse al final
        while (atras.tieneParaAtras()) {
            System.out.println(atras.deParaAtras());
        }
    }
}