import java.util.Scanner;

class CalculadoraFiguras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de Área, Perímetro y Potencia");

        double[] results = new double[2]; // Cambio en la declaración del array results

        do {
            System.out.println("Ingrese el número de la figura: ");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono (Área solamente)");
            System.out.println("6. Potencia de un número");
            System.out.println("7. Salir");
            System.out.print("Ingrese el número de la figura: ");
            int figureNumber = scanner.nextInt();

            if (figureNumber == 7) {
                break;
            }

            switch (figureNumber) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    calcularFigura(figureNumber, scanner, results);
                    break;
                case 6:
                    calcularPotencia(scanner, results);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (true);

        System.out.println("Resultados almacenados:");
        System.out.println(STR."Área/Potencia: \{results[0]}");
        System.out.println(STR."Perímetro: \{results[1]}");

        System.out.println("Gracias por usar la calculadora. ¡Hasta luego!");

        scanner.close();
    }

    public static void calcularFigura(int figureNumber, Scanner scanner, double[] results) {
        Shape figura = crearFigura(figureNumber, scanner);

        System.out.println("Por favor, elija una operación:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        System.out.print("Ingrese el número de la operación: ");
        int operationNumber = scanner.nextInt();

        if (operationNumber == 1) {
            results[0] = figura.getArea();
        } else if (operationNumber == 2) {
            results[1] = figura.getPerimeter();
        } else {
            System.out.println("Operación inválida.");
            return;
        }

        String figureName = getFigureName(figureNumber);
        String operationName = (operationNumber == 1) ? "Área" : "Perímetro";

        System.out.println(STR."\{figureName} \{operationName}: \{results[operationNumber - 1]}");
    }

    public static void calcularPotencia(Scanner scanner, double[] results) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese el exponente: ");
        int exponente = scanner.nextInt();

        double resultado = potencia(base, exponente);
        System.out.println(STR."Resultado de la potencia: \{resultado}");

        results[0] = resultado;
        results[1] = 0;
    }

    public static double potencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente > 0) {
            return base * potencia(base, exponente - 1);
        } else {
            return 1 / (base * potencia(base, -exponente - 1));
        }
    }

    public static Shape crearFigura(int figureNumber, Scanner scanner) {
        Shape figura;

        switch (figureNumber) {
            case 1:
                System.out.print("Ingrese el radio del círculo: ");
                double radius = scanner.nextDouble();
                figura = new Circle(radius);
                break;
            case 2:
                System.out.print("Ingrese el lado del cuadrado: ");
                double side = scanner.nextDouble();
                figura = new Square(side);
                break;
            case 3:
                System.out.print("Ingrese la base del triángulo: ");
                double base = scanner.nextDouble();
                System.out.print("Ingrese la altura del triángulo: ");
                double height = scanner.nextDouble();
                figura = new Triangle(base, height);
                break;
            case 4:
                System.out.print("Ingrese la longitud del rectángulo: ");
                double length = scanner.nextDouble();
                System.out.print("Ingrese el ancho del rectángulo: ");
                double width = scanner.nextDouble();
                figura = new Rectangle(length, width);
                break;
            case 5:
                System.out.print("Ingrese el lado del pentágono: ");
                double pentagonSide = scanner.nextDouble();
                figura = new Pentagon(pentagonSide);
                break;
            default:
                System.out.println("Figura inválida");
                figura = null;
                break;
        }

        return figura;
    }

    public static String getFigureName(int figureNumber) {
        return switch (figureNumber) {
            case 1 -> "Círculo";
            case 2 -> "Cuadrado";
            case 3 -> "Triángulo";
            case 4 -> "Rectángulo";
            case 5 -> "Pentágono";
            default -> "Figura";
        };
    }
}

interface Shape {
    double getArea();
    double getPerimeter();
}

class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square implements Shape {
    double side;

    Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
}

class Triangle implements Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }

    public double getPerimeter() {
        return 3 * base;
    }
}

class Rectangle implements Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }
}

class Pentagon implements Shape {
    double side;

    Pentagon(double side) {
        this.side = side;
    }

    public double getArea() {
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }

    public double getPerimeter() {
        return 5 * side;
    }
}
