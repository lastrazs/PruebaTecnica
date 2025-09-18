import java.util.Arrays;

public class Logica {
    // A) Función que filtre productos disponibles (stock > 0) y calcule el valor total
    public static double calcularValorTotalProductosDisponibles(Producto[] productos) {
        double valorTotal = 0;
        for (Producto producto : productos) {
            if (producto.stock > 0) {
                valorTotal += producto.precio;
            }
        }
        return valorTotal;
    }

    // B) Función que encuentre el producto más caro de cada categoría
    public static Producto encontrarProductoMasCaro(Producto[] productos, String categoria) {
        Producto productoMasCaro = null;
        double precioMaximo = 0;
        for (Producto producto : productos) {
            if (producto.categoria.equalsIgnoreCase(categoria)) {
                if (producto.precio > precioMaximo) {
                    precioMaximo = producto.precio;
                    productoMasCaro = producto;
                }
            }
        }
        return productoMasCaro;
    }

    // C) Función que ordene productos por precio (menor a mayor) y valide que todos los precios sean positivos
    public static Producto[] ordenarProductosPorPrecio(Producto[] productos) {
        // Validar que todos los precios sean positivos
        for (Producto producto : productos) {
            if (producto.precio < 0) {
                throw new IllegalArgumentException("El precio del producto con ID " + producto.id + " es negativo.");
            }
        }

        // Ordenar los productos por precio
        Arrays.sort(productos);
        return productos;
    }
}