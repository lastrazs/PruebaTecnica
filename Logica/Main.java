public class Main {
    public static void main(String[] args) {
        // Array de productos
        Producto[] productos = {
            new Producto(1, "Laptop", 800, "tecnologia", 5),
            new Producto(2, "Mouse",25, "tecnologia", 0),
            new Producto(3, "Silla",150, "muebles", 3),
            new Producto(4, "Monitor",300, "tecnologia", 7)
        };

        // Ejemplo de uso de las funciones
        System.out.println("Valor total de productos disponibles: " + Logica.calcularValorTotalProductosDisponibles(productos));

        Producto productoMasCaro = Logica.encontrarProductoMasCaro(productos, "tecnologia");
        if (productoMasCaro != null) {
            System.out.println("Producto más caro en 'tecnologia': " + productoMasCaro);
        } else {
            System.out.println("No hay productos en la categoría 'tecnologia'.");
        }

        try {
            Producto[] productosOrdenados = Logica.ordenarProductosPorPrecio(productos);
            System.out.println("Productos ordenados por precio:");
            for (Producto producto : productosOrdenados) {
                System.out.println(producto);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}