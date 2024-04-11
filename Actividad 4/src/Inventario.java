import java.util.ArrayList;

public class Inventario {
    private final ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void verificarBajoInventario() {
        for (Producto producto : productos) {
            if (producto.getCantidad() <= 100) {
                System.out.println(STR."Producto: \{producto.getNombre()} tiene bajo inventario. Cantidad actual: \{producto.getCantidad()}");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventario:\n");
        for (int i = 0; i < productos.size(); i++) {
            sb.append((i + 1)).append(". ").append(productos.get(i)).append("\n");
        }
        return sb.toString();
    }

    public Producto obtenerProductoPorNumero(int numeroProducto) {
        if (numeroProducto >= 1 && numeroProducto <= productos.size()) {
            return productos.get(numeroProducto - 1);
        } else {
            return null;
        }
    }

    public void actualizarCantidadProducto(Producto producto, int cantidad) {
        producto.setCantidad(producto.getCantidad() + cantidad);
        verificarBajoInventario(); // Call the method here
    }
}