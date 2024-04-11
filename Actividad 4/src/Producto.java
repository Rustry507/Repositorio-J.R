public class Producto {

    final String nombre;
    final String marca;
    int cantidad;

    public Producto(String nombre, String marca, int cantidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return STR."Producto [nombre=\{nombre}, marca=\{marca}, cantidad=\{cantidad}]";
    }
}