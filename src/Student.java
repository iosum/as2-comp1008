import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private String city;
    private String streetAddress;
    private String postalCode;
    private String program;
    private int studentNumber;
    private LocalDate enrollmentDate;
    private LocalDate birthDate;

    public Student(String firstName, String lastName, String city, String streetAddress, String postalCode, String program, int studentNumber, LocalDate enrollmentDate, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.program = program;
        this.studentNumber = studentNumber;
        this.enrollmentDate = enrollmentDate;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s, student number: %d", firstName, lastName, studentNumber);
    }
}