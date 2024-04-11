import java.util.HashMap;

class GestorProductos {
    private final HashMap<String, Producto> productos;

    public GestorProductos() {
        productos = new HashMap<>();
    }

    public void agregarProducto(String nombre, int cantidad) {
        productos.put(nombre, new Producto(nombre, cantidad));
    }

    public void venderProducto(String nombre, int cantidad) {
        Producto producto = productos.get(nombre);
        if (producto != null) {
            producto.vender(cantidad);
        } else {
            System.out.println(STR."Producto no encontrado: \{nombre}");
        }
    }

    public void restablecerProducto(String nombre) {
        Producto producto = productos.get(nombre);
        if (producto != null) {
            producto.restablecer();
        } else {
            System.out.println(STR."Producto no encontrado: \{nombre}");
        }
    }

    public void mostrarInventario() {
        for (Producto producto : productos.values()) {
            System.out.println(producto);
        }
    }

    public static void main(String[] args) {
        GestorProductos gestor = new GestorProductos();
        gestor.agregarProducto("Producto 1", 10);
        gestor.agregarProducto("Producto 2", 5);
        gestor.mostrarInventario();

        gestor.venderProducto("Producto 1", 3);
        gestor.venderProducto("Producto 2", 2);
        gestor.mostrarInventario();

        gestor.restablecerProducto("Producto 1");
        gestor.mostrarInventario();
    }
}


