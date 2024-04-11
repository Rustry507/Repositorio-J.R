public class Producto {
    private final String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void vender(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("No hay suficiente cantidad en inventario.");
        }
    }

    public void restablecer() {
        this.cantidad = 10;
    }

    @Override
    public String toString() {
        return STR."\{nombre}: \{cantidad}";
    }
}