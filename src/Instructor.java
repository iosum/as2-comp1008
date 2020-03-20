import java.time.LocalDate;
import java.time.Period;

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

    public int getAgeInYears() {
        int age = LocalDate.now().getYear() - birthday.getYear();

        if (LocalDate.now().getMonth().compareTo(birthday.getMonth()) < 0) {
            age = age - 1;
        }
        else if (LocalDate.now().getMonth().compareTo(birthday.getMonth()) == 0) {
            if (LocalDate.now().getDayOfMonth() < birthday.getDayOfMonth()) {
                age = age - 1;
            }
        }
        return age;
    }

    public int noOfYearsAtCollege() {
        LocalDate today = LocalDate.now();
        long diff = Period.between(hireDate, today).getYears();

        return (int) diff;
    }

    public String getInstructorAddress() {
        return streetAddress + ", " + city + ", " + postalCode;
    }

    public void changeAddress(String streetAddress, String city, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
    }
}
