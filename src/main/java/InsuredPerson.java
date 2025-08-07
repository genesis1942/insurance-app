public class InsuredPerson {
    private String firstName;
    private String lastName;
    private int age;
    private String phone;

    public InsuredPerson(String firstName, String lastName, int age, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return String.format("Meno: %s %s | Vek: %d | Telefón: %s", firstName, lastName, age, phone);
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}
