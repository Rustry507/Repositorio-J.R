import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Producto zapatoNike1 = new Producto("Nike Air Max", "Nike", 200);
        Producto zapatoNike2 = new Producto("Nike Running Shoes", "Nike", 80);
        Producto zapatoAdidas = new Producto("Adidas Originals", "Adidas", 50);
        inventario.agregarProducto(zapatoNike1);
        inventario.agregarProducto(zapatoNike2);
        inventario.agregarProducto(zapatoAdidas);

        inventario.verificarBajoInventario();

        System.out.println("Bienvenido a la Zapateria XD. Aquí están los productos disponibles:");
        System.out.println("------------------------------------------------------------");
        System.out.println(inventario);
        System.out.println("\nPor favor, seleccione el número del producto que desea comprar (o '0' para salir):");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 0) {
                System.out.println("¡Gracias por su visita!");
                break;
            }

            Producto productoSeleccionado = inventario.obtenerProductoPorNumero(opcion);
            if (productoSeleccionado != null) {
                System.out.println(STR."Ha seleccionado: \{productoSeleccionado}");
                System.out.println("Ingrese la cantidad que desea comprar:");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser mayor que cero.");
                } else if (cantidad > productoSeleccionado.getCantidad()) {
                    System.out.println("Lo siento, no hay suficiente cantidad disponible.");
                } else {
                    System.out.println("Compra realizada:");
                    System.out.println(STR."Producto: \{productoSeleccionado.getNombre()}");
                    System.out.println(STR."Cantidad: \{cantidad}");
                    inventario.actualizarCantidadProducto(productoSeleccionado, -cantidad);
                }
            } else {
                System.out.println("Opción inválida. Por favor, seleccione un número válido de producto.");
            }
            System.out.println("¿Desea seguir comprando? (si/no)");
            String continuarComprando = scanner.nextLine();
            if (!continuarComprando.equalsIgnoreCase("si")) {
                break;
            }
            inventario.verificarBajoInventario();
            System.out.println("Aquí está el inventario actualizado:");
            System.out.println(inventario);
        }
    }
}