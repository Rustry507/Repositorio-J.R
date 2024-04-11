import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorProductos gestor = new GestorProductos();
        Producto zapato1 = new Producto("zapato 1", 20);
        Producto zapato2 = new Producto("zapato 2", 20);

        gestor.agregarProducto(zapato1.getNombre(), zapato1.getCantidad());
        gestor.agregarProducto(zapato2.getNombre(), zapato2.getCantidad());

        System.out.println("Inventario inicial:");
        gestor.mostrarInventario();

        String respuesta = "s";
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el nombre del producto a vender:");
            String nombreProductoAVender = scanner.nextLine();
            System.out.println("Ingrese la cantidad a vender:");
            int cantidadAVender = scanner.nextInt();
            scanner.nextLine();
            gestor.venderProducto(nombreProductoAVender, cantidadAVender);

            System.out.println("Inventario después de la venta:");
            gestor.mostrarInventario();

            System.out.println("Desea seguir comprando? (s/n)");
            respuesta = scanner.nextLine();
        }

        System.out.println("Inventario final:");
        gestor.mostrarInventario();

        scanner.close();
    }
}

