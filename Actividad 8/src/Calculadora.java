import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de Operaciones Matemáticas");

        do {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Operación aritmética");
            System.out.println("2. Área y perímetro");
            System.out.println("3. Potencia");
            System.out.println("4. Salir");
            System.out.print("Ingrese el número de la operación: ");
            int opcion = scanner.nextInt();

            if (opcion == 4) {
                break;
            }

            Operacion operacion;

            switch (opcion) {
                case 1:
                    operacion = new OperacionAritmetica();
                    break;
                case 2:
                    operacion = new AreaPerimetro();
                    break;
                case 3:
                    operacion = new Potencia();
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            operacion.realizarOperacion(scanner);

        } while (true);

        System.out.println("Gracias por usar la calculadora. ¡Hasta luego!");

        scanner.close();
    }
}

interface Operacion {
    void realizarOperacion(Scanner scanner);
}

class OperacionAritmetica implements Operacion {

    @Override
    public void realizarOperacion(Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        double numero1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.println("Seleccione una operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println(STR."Resultado: \{numero1 + numero2}");
                break;
            case 2:
                System.out.println(STR."Resultado: \{numero1 - numero2}");
                break;
            case 3:
                System.out.println(STR."Resultado: \{numero1 * numero2}");
                break;
            case 4:
                if (numero2 != 0) {
                    System.out.println(STR."Resultado: \{numero1 / numero2}");
                } else {
                    System.out.println("No se puede dividir por cero.");
                }
                break;
            default:
                System.out.println("Operación inválida.");
        }
    }
}

class AreaPerimetro implements Operacion {

    @Override
    public void realizarOperacion(Scanner scanner) {
        System.out.println("Seleccione una figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        int opcion = scanner.nextInt();

        Figura figura;

        switch (opcion) {
            case 1:
                figura = new Circulo();
                break;
            case 2:
                figura = new Cuadrado();
                break;
            case 3:
                figura = new Triangulo();
                break;
            case 4:
                figura = new Rectangulo();
                break;
            case 5:
                figura = new Pentagono();
                break;
            default:
                System.out.println("Figura inválida.");
                return;
        }

        figura.calcularArea(scanner);
        figura.calcularPerimetro(scanner);
    }
}

class Potencia implements Operacion {

    @Override
    public void realizarOperacion(Scanner scanner) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese el exponente: ");
        int exponente = scanner.nextInt();

        double resultado = Math.pow(base, exponente);
        System.out.println(STR."Resultado de la potencia: \{resultado}");
    }
}

interface Figura {
    void calcularArea(Scanner scanner);
    void calcularPerimetro(Scanner scanner);
}

class Circulo implements Figura {

    @Override
    public void calcularArea(Scanner scanner) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();
        System.out.println(STR."Área del círculo: \{Math.PI * Math.pow(radio, 2)}");
    }

    @Override
    public void calcularPerimetro(Scanner scanner) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();
        System.out.println(STR."Perímetro del círculo: \{2 * Math.PI * radio}");
    }
}

class Cuadrado implements Figura {

    @Override
    public void calcularArea(Scanner scanner) {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();
        System.out.println(STR."Área del cuadrado: \{Math.pow(lado, 2)}");
    }

    @Override
    public void calcularPerimetro(Scanner scanner) {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();
        System.out.println(STR."Perímetro del cuadrado: \{4 * lado}");
    }
}

class Triangulo implements Figura {

    @Override
    public void calcularArea(Scanner scanner) {
        System.out.print("Ingrese la base del triángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = scanner.nextDouble();
        System.out.println(STR."Área del triángulo: \{0.5 * base * altura}");
    }

    @Override
    public void calcularPerimetro(Scanner scanner) {
        System.out.print("Ingrese el lado del triángulo: ");
        double lado = scanner.nextDouble();
        System.out.println(STR."Perímetro del triángulo: \{3 * lado}");
    }
}

class Rectangulo implements Figura {

    @Override
    public void calcularArea(Scanner scanner) {
        System.out.print("Ingrese la base del rectángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = scanner.nextDouble();
        System.out.println(STR."Área del rectángulo: \{base * altura}");
    }

    @Override
    public void calcularPerimetro(Scanner scanner) {
        System.out.print("Ingrese la base del rectángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = scanner.nextDouble();
        System.out.println(STR."Perímetro del rectángulo: \{2 * (base + altura)}");
    }
}

class Pentagono implements Figura {

    @Override
    public void calcularArea(Scanner scanner) {
        System.out.print("Ingrese el lado del pentágono: ");
        double lado = scanner.nextDouble();

        double apotema = lado / (2 * Math.tan(Math.PI / 5));

        double area = (5 * lado * apotema) / 2;

        System.out.println(STR."Área del pentágono: \{area}");
    }

    @Override
    public void calcularPerimetro(Scanner scanner) {
        System.out.print("Ingrese el lado del pentágono: ");
        double lado = scanner.nextDouble();

        double perimetro = 5 * lado;

        System.out.println(STR."Perímetro del pentágono: \{perimetro}");
    }
}