import java.util.Arrays;
import java.util.Scanner;

public class InformacionVisitante {

    public static void main() {
        main(null);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Ingrese el nombre del visitante:");
        String nombrevisit = scanner.nextLine();

        System.out.println("Ingrese la edad del visitante:");
        int edad = scanner.nextInt();

        byte numeroApartamento;
        do {
            System.out.println("Ingrese el número de apartamento visitado (rango de 1 a 50):");
            while (!scanner.hasNextByte()) {
                System.out.println("Error: Debe ingresar un número válido entre 1 y 50.");
                scanner.next();
            }
            numeroApartamento = scanner.nextByte();
            if (numeroApartamento < 1 || numeroApartamento > 50) {
                System.out.println("Error: Debe ingresar un número válido entre 1 y 50.");
            }
        } while (numeroApartamento < 1 || numeroApartamento > 50);

        scanner.nextLine();

        System.out.println("Ingrese la fecha de la visita (formato YYYY-MM-DD):");
        String fechavisita = scanner.nextLine();

        System.out.println("Ingrese la hora de la visita (formato HH:MM):");
        String horaVisita = scanner.nextLine();

        System.out.println("Ingrese el propósito de la visita:");
        String propositovisita = scanner.nextLine();


        System.out.println("\nInformación del visitante:");
        for (String s : Arrays.asList(STR."Nombre: \{nombrevisit}", STR."Edad: \{edad}", STR."Número de apartamento visitado: \{numeroApartamento}", STR."Fecha de la visita: \{fechavisita}", STR."Hora de la visita: \{horaVisita}", STR."Propósito de la visita: \{propositovisita}")) {
            System.out.println(s);
        }

        scanner.close();
    }
}
