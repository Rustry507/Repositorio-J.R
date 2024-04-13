import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    private String name;
    private String email;
    private String password;

    public UserRegistration() {
        this.name = "";
        this.email = "";
        this.password = "";
    }

    public void collectUserInput() {
        Scanner scanner = new Scanner(System.in);
        this.name = getValidInput(scanner, "Ingrese su nombre:", NAME_PATTERN);
        this.email = getValidInput(scanner, "Ingrese su correo electrónico:", EMAIL_PATTERN);
        this.password = getValidInput(scanner, "Ingrese su contraseña:", PASSWORD_PATTERN);
        scanner.close();
    }

    public boolean isValid() {
        return isValidInput(name, NAME_PATTERN) && isValidInput(email, EMAIL_PATTERN) && isValidInput(password, PASSWORD_PATTERN);
    }

    private String getValidInput(Scanner scanner, String prompt, Pattern pattern) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return input;
            } else {
                System.out.println("Entrada no válida. Por favor, inténtelo de nuevo.");
            }
        }
    }

    private boolean isValidInput(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.collectUserInput();

        if (userRegistration.isValid()) {
            System.out.println("Registro exitoso.");
        } else {
            System.out.println("Registro fallido. Por favor, verifique la información ingresada.");
        }
    }
}
