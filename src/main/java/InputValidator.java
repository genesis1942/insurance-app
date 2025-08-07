import java.util.Scanner;

/**
 * InputValidator class for reading and validating user input.
 * It provides methods to read non-empty strings and integers from the console.
 */

public class InputValidator {

    public String readNonEmptyString(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Toto pole nesmie byť prázdne.");
            }
        } while (input.isEmpty());
        return input;
    }

    public int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Zadaj platné číslo.");
            }
        }
    }
}
