import java.time.LocalDate;

public class Instructor {
    private String firstName;
    private String lastName;
    private int instructorNumber;
    private String streetAddress;
    private String city;
    private String postalCode;
    private LocalDate hireDate;
    private LocalDate birthday;

    public Instructor(String firstName, String lastName, int instructorNumber, String streetAddress, String city, String postalCode, LocalDate hireDate, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructorNumber = instructorNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.hireDate = hireDate;
        this.birthday = birthday;
    }

    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
