import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordValidator {
    private static final Logger logger = Logger.getLogger(PasswordValidator.class.getName());

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.find()) {
            return false;
        }

        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        if (!upperCaseMatcher.find()) {
            return false;
        }

        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        if (!lowerCaseMatcher.find()) {
            return false;
        }

        Pattern numberPattern = Pattern.compile("[0-9]");
        Matcher numberMatcher = numberPattern.matcher(password);
        return numberMatcher.find();

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
                logger.log(Level.WARNING, "Por favor, ingrese un número válido.", e.getMessage());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("registro.txt", true))) {
            for (int i = 0; i < numberOfPasswords; i++) {
                System.out.println(STR."Ingrese la contraseña \{i + 1}:");
                String password = scanner.nextLine();

                Thread thread = new Thread(() -> {
                    boolean isValid = isValidPassword(password);
                    System.out.print(STR."\{password} ");
                    if (isValid) {
                        System.out.println("es válida.");
                    } else {
                        System.out.println("no es válida.");
                    }


                    try {
                        synchronized (writer) {
                            writer.write(STR."\{password}\{isValid ? " es válida" : " no es válida"}\n");
                        }
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "Error al escribir en el archivo de registro", e.getMessage());
                    }
                });

                thread.start();

                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error al abrir el archivo de registro", e.getMessage());
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Error al esperar los hilos", e.getMessage());
        }

        scanner.close();
    }
}
