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

    /**
     * constructor
     * @param firstName
     * @param lastName
     * @param instructorNumber
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param hireDate
     * @param birthday
     */

    public Instructor(String firstName, String lastName, int instructorNumber, String streetAddress, String city, String postalCode, LocalDate hireDate, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructorNumber = instructorNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        setHireDate(hireDate);
        setBirthday(birthday);
        courses = new ArrayList<>();
    }

    /**
     * set the hire day for an instructor, which cannot exceed over 80 years
     * @param input
     */
    private void setHireDate(LocalDate input) {
        LocalDate today = LocalDate.now();
        long diff = Period.between(input, today).getYears();
        if(diff > 80){
            throw new IllegalArgumentException(input + " as a hire date would mean Anita started working over " + 80 + " years ago");
        } else {
            hireDate = input;
        }
    }

    /**
     * set an instructor's birthday, which cannot be over 100 years old
     * @param birthday
     */

    public void setBirthday(LocalDate birthday) {
        int age = LocalDate.now().getYear() - birthday.getYear();

        if (LocalDate.now().getMonth().compareTo(birthday.getMonth()) < 0) {
            age = age - 1;
        }
        else if (LocalDate.now().getMonth().compareTo(birthday.getMonth()) == 0) {
            if (LocalDate.now().getDayOfMonth() < birthday.getDayOfMonth()) {
                age = age - 1;
            }
        }
        if(age >= 14 && age <= 90) {
            this.birthday = birthday;
        } else {
            throw new IllegalArgumentException("Expected output: java.lang.IllegalArgumentException: Please check the year entered, student cannot be over 100 years old");
        }
    }

    /**
     * return an instructor's first name and last name
     * @return
     */

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

    /**
     * get the total years of an instructor in a college
     * @return
     */
    public int noOfYearsAtCollege() {
        LocalDate today = LocalDate.now();
        long diff = Period.between(hireDate, today).getYears();

        return (int) diff;
    }

    /**
     * get an instructor's address
     * @return
     */

    public String getInstructorAddress() {
        return streetAddress + ", " + city + ", " + postalCode;
    }

    /**
     * change an instructor's address
     * @param streetAddress
     * @param city
     * @param postalCode
     */

    public void changeAddress(String streetAddress, String city, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
    }

    /**
     * know which subjects that an instructor can teach
     * @return
     */
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

    /**
     * set the course so that an instructor can teach
     * @param newCourse
     */
    public void addCourseToInstructorAbilities(String newCourse) {
        if(!courses.contains(newCourse)){
            courses.add(newCourse);
        }
    }

    /**
     * check if an instructor can teach the course
     * @param course
     * @return
     */
    public boolean instructorCanTeach(String course) {
        if(courses.contains(course)){
            return true;
        } else {
            return false;
        }
    }
}
