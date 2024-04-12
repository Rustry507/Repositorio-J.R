import java.util.Scanner;

public class Shape {

}

class Circle extends Shape {
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

class Square extends Shape {
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

class Triangle extends Shape {
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

    public double getPerimeter() {
        return 2 * (length + width);
    }
}

class Pentagon extends Shape {
    double side;

    Pentagon(double side) {
        this.side = side;
    }

    public double getArea() {
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }

}

class GeometricCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de Área y Perímetro");

        double[] results = new double[2];

        do {
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

            double result;

            String figureName;
            switch (figureNumber) {
                case 1:
                    figureName = "Círculo";
                    System.out.print("Ingrese el radio del círculo: ");
                    double radius = scanner.nextDouble();
                    Circle circle = new Circle(radius);
                    result = (operationNumber == 1) ? circle.getArea() : circle.getPerimeter();
                    break;
                case 2:
                    figureName = "Cuadrado";
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double side = scanner.nextDouble();
                    Square square = new Square(side);
                    result = (operationNumber == 1) ? square.getArea() : square.getPerimeter();
                    break;
                case 3:
                    figureName = "Triángulo";
                    System.out.print("Ingrese la base del triángulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura del triángulo: ");
                    double height = scanner.nextDouble();
                    Triangle triangle = new Triangle(base, height);
                    result = (operationNumber == 1) ? triangle.getArea() : triangle.getPerimeter();
                    break;
                case 4:
                    figureName = "Rectángulo";
                    System.out.print("Ingrese la longitud del rectángulo: ");
                    double length = scanner.nextDouble();
                    System.out.print("Ingrese el ancho del rectángulo: ");
                    double width = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    result = (operationNumber == 1) ? rectangle.getArea() : rectangle.getPerimeter();
                    break;
                case 5:
                    figureName = "Pentágono";
                    System.out.print("Ingrese el lado del pentágono: ");
                    double pentagonSide = scanner.nextDouble();
                    Pentagon pentagon = new Pentagon(pentagonSide);
                    result = pentagon.getArea();
                    break;
                default:
                    System.out.println("Figura inválida.");
                    continue;
            }

            results[operationNumber - 1] = result;

            System.out.println(STR."El área del \{figureName} es: \{result}");

            System.out.println("\n¿Desea realizar otro cálculo?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int option = scanner.nextInt();

            if (option != 1)
                break;

        } while (true);

        System.out.println("Resultados almacenados:");
        System.out.println(STR."Área: \{results[0]}");
        System.out.println(STR."Perímetro: \{results[1]}");

        System.out.println("Gracias por usar la calculadora. ¡Hasta luego!");
    }
}
