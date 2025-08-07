import java.util.List;
import java.util.Scanner;

/** * MenuHandler class for managing the user interface of the insurance application.
 * It provides methods to display the menu, add insured persons, list all insured persons,
 * and search for a specific insured person by name.
 */

public class MenuHandler {
    private final InsuranceApp app = new InsuranceApp();
    private final InputValidator validator = new InputValidator();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = validator.readInt(scanner, "Vyber možnosť: ");
            switch (choice) {
                case 1 -> addPerson();
                case 2 -> listAll();
                case 3 -> searchPerson();
                case 0 -> {
                    System.out.println("Koniec programu.");
                    exit = true;
                }
                default -> System.out.println("Neplatná voľba. Skús to znova.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nEvidencia poistených:");
        System.out.println("1 - Pridať poisteného");
        System.out.println("2 - Zobraziť všetkých poistených");
        System.out.println("3 - Vyhľadať poisteného");
        System.out.println("0 - Ukončiť");
    }

    private void addPerson() {
        String firstName = validator.readNonEmptyString(scanner, "Zadaj meno: ");
        String lastName = validator.readNonEmptyString(scanner, "Zadaj priezvisko: ");
        int age = validator.readInt(scanner, "Zadaj vek: ");
        String phone = validator.readNonEmptyString(scanner, "Zadaj telefónne číslo: ");

        InsuredPerson person = new InsuredPerson(firstName, lastName, age, phone);
        app.addInsuredPerson(person);
        System.out.println("Poistený pridaný.");
    }

    private void listAll() {
        List<InsuredPerson> list = app.getAll();
        if (list.isEmpty()) {
            System.out.println("Zoznam je prázdny.");
        } else {
            System.out.println("Zoznam poistených:");
            for (InsuredPerson p : list) {
                System.out.println(p);
            }
        }
    }

    private void searchPerson() {
        String firstName = validator.readNonEmptyString(scanner, "Zadaj meno: ");
        String lastName = validator.readNonEmptyString(scanner, "Zadaj priezvisko: ");

        List<InsuredPerson> result = app.findByName(firstName, lastName);
        if (result.isEmpty()) {
            System.out.println("Poistená osoba nebola nájdená.");
        } else {
            System.out.println("Nájdené osoby:");
            for (InsuredPerson p : result) {
                System.out.println(p);
            }
        }
    }
}
