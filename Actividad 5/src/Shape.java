import java.util.Scanner;


public class Shape {

    public double getArea() {
        return 0;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square extends Shape {
    double side;

    Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    double getPerimeter() {
        return 4 * side;
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public Object getPerimeter() {
        return null;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    double getPerimeter() {
        return 2 * (length + width);
    }
}

class Pentagon extends Shape {
    double side;

    Pentagon(double side) {
        this.side = side;
    }

    public double getArea() {
        return 0.5 * side * side * Math.tan(Math.PI / 5) * 5;
    }

    public String getPerimeter() {
        return null;
    }
}

class GeometricCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de Área y Perímetro");
        System.out.println("Por favor, elija una figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono (Área solamente)");
        System.out.print("Ingrese el número de la figura: ");
        int figureNumber = scanner.nextInt();

        System.out.println("Por favor, elija una operación:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        System.out.print("Ingrese el número de la operación: ");
        int operationNumber = scanner.nextInt();

        double radius, side, base, height;
        switch (figureNumber) {
            case 1:
                System.out.print("Ingrese el radio del círculo: ");
                radius = scanner.nextDouble();
                Circle circle = new Circle(radius);
                if (operationNumber == 1) {
                    System.out.println(STR."El área del círculo es: \{circle.getArea()}");
                } else if (operationNumber == 2) {
                    System.out.println(STR."El perímetro del círculo es: \{circle.getPerimeter()}");
                } else {
                    System.out.println("Operación inválida.");
                }
                break;
            case 2:
                System.out.print("Ingrese el lado del cuadrado: ");
                side = scanner.nextDouble();
                Square square = new Square(side);
                if (operationNumber == 1) {
                    System.out.println(STR."El área del cuadrado es: \{square.getArea()}");
                } else if (operationNumber == 2) {
                    System.out.println(STR."El perímetro del cuadrado es: \{square.getPerimeter()}");
                } else {
                    System.out.println("Operación inválida.");
                }
                break;
            case 3:
                System.out.print("Ingrese la base del triángulo: ");
                base = scanner.nextDouble();
                System.out.print("Ingrese la altura del triángulo: ");
                height = scanner.nextDouble();
                Triangle triangle = new Triangle(base, height);
                if (operationNumber == 1) {
                    System.out.println(STR."El área del triángulo es: \{triangle.getArea()}");
                } else if (operationNumber == 2) {
                    System.out.println(STR."El perímetro del triángulo es: \{triangle.getPerimeter()}");
                } else {
                    System.out.println("Operación inválida.");
                }
                break;
            case 4:
                System.out.print("Ingrese la longitud del rectángulo: ");
                double length = scanner.nextDouble();
                System.out.print("Ingrese el ancho del rectángulo: ");
                double width = scanner.nextDouble();
                Rectangle rectangle = new Rectangle((int) length, (int) width);
                if (operationNumber == 1) {
                    System.out.println(STR."El área del rectángulo es: \{rectangle.getArea()}");
                } else if (operationNumber == 2) {
                    System.out.println(STR."El perímetro del rectángulo es: \{rectangle.getPerimeter()}");
                } else {
                    System.out.println("Operación inválida.");
                }
                break;
            case 5:
                System.out.print("Ingrese el lado del pentágono: ");
                side = scanner.nextDouble();
                Pentagon pentagon = new Pentagon(side);
                if (operationNumber == 1) {
                    System.out.println(STR."El área del pentágono es: \{pentagon.getArea()}");
                } else {
                    System.out.println(STR."El perímetro del pentágono es: \{pentagon.getPerimeter()}");
                }
                break;
            default:
                System.out.println("Figura inválida.");


                System.out.println("\n¿Desea realizar otro cálculo?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:

                        break;
                    case 2:
                        System.out.println("Gracias por usar la calculadora. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Saliendo del programa...");
                }


        }

    }

}
