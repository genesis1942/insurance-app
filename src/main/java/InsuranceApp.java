import java.util.ArrayList;
import java.util.List;

public class InsuranceApp {
    private final List<InsuredPerson> insuredList = new ArrayList<>();

    // Adds a new insured person to the list
    public void addInsuredPerson(InsuredPerson person) {
        insuredList.add(person);
    }

    // Returns all insured people (no printing here!)
    public List<InsuredPerson> getAll() {
        return new ArrayList<>(insuredList);  // Defensive copy
    }

    // Finds people by first and last name
    public List<InsuredPerson> findByName(String firstName, String lastName) {
        List<InsuredPerson> result = new ArrayList<>();
        for (InsuredPerson p : insuredList) {
            if (p.getFirstName().equalsIgnoreCase(firstName) &&
                    p.getLastName().equalsIgnoreCase(lastName)) {
                result.add(p);
            }
        }
        return result;
    }
}
