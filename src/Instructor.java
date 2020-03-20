import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Instructor {
    private String firstName;
    private String lastName;
    private int instructorNumber;
    private String streetAddress;
    private String city;
    private String postalCode;
    private LocalDate hireDate;
    private LocalDate birthday;
    public ArrayList<String> courses;

    public Instructor(String firstName, String lastName, int instructorNumber, String streetAddress, String city, String postalCode, LocalDate hireDate, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructorNumber = instructorNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.hireDate = hireDate;
        this.birthday = birthday;
        courses = new ArrayList<>();
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

    public String listOfSubjectsCertifiedToTeach() {
        String classList = "[";
        int counter = 0;

        for (String course : courses) {
            counter++;
            classList = classList + course;
            if (counter == 1) {
                classList = classList + ", ";
            }
        }

        classList = classList + "]";

        if (courses.isEmpty()) {
            return "not qualified to teach courses yet.";
        }
        else {
            return classList;
        }
    }

    public void addCourseToInstructorAbilities(String newCourse) {
        if(!courses.contains(newCourse)){
            courses.add(newCourse);
        }
    }
}
