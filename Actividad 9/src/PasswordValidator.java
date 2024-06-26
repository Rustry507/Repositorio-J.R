import java.util.Scanner;
import java.util.regex.*;

public class PasswordValidator implements Runnable {
    private final String password;

    public PasswordValidator(String password) {
        this.password = password;
    }

    @Override
    public void run() {
        System.out.print(STR."\{password} ");
        if (isValidPassword(password)) {
            System.out.print("es válida. ");
        } else {
            System.out.print("no es válida. ");
        }
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.find()) {
            return false;
        }

        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int digitCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        return upperCaseCount >= 1 && lowerCaseCount >= 3 && digitCount >= 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de contraseñas a validar:");

        int numberOfPasswords;
        while (true) {
            try {
                numberOfPasswords = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        for (int i = 0; i < numberOfPasswords; i++) {
            System.out.println(STR."Ingrese la contraseña \{i + 1}:");
            String password = scanner.nextLine();
            Thread thread = new Thread(new PasswordValidator(password));
            thread.start();

      
            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine();
        }

        scanner.close();
    }
}

