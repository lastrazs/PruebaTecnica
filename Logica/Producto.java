public class Producto implements Comparable<Producto> {
    int id;
    String nombre;
    double precio;
    String categoria;
    int stock;

    public Producto(int id, String nombre ,double precio, String categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: \"" + nombre + "\", Precio: " + precio + ", Categoría: \"" + categoria + "\", Stock: " + stock;
    }
}