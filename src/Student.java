import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

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

    private boolean goodStanding;
    public ArrayList<CompletedCourse> completedCourses;

    public Student(String firstName, String lastName, String city, String streetAddress, String postalCode, String program, int studentNumber, LocalDate enrollmentDate, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.program = program;
        this.studentNumber = studentNumber;
        this.enrollmentDate = enrollmentDate;
        setBirthDate(birthDate);
        this.goodStanding = true;
        completedCourses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public LocalDate getBirthDate() {

        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        int age = LocalDate.now().getYear() - birthDate.getYear();

        if (LocalDate.now().getMonth().compareTo(birthDate.getMonth()) < 0) {
            age = age - 1;
        }
        else if (LocalDate.now().getMonth().compareTo(birthDate.getMonth()) == 0) {
            if (LocalDate.now().getDayOfMonth() < birthDate.getDayOfMonth()) {
                age = age - 1;
            }
        }
        if(age >= 14 && age <= 90) {
            this.birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("Expected output: java.lang.IllegalArgumentException: Please check the year entered, student cannot be over 100 years old");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s, student number: %d", firstName, lastName, studentNumber);
    }

    public LocalDate getStudentBirthday() {
        return birthDate;
    }


    /**
     * get the student age
     * if the birthdate month is not greater than the month this year, age-1
     *
     * @return
     */

    public int getStudentAge() {
        int age = LocalDate.now().getYear() - birthDate.getYear();

        if (LocalDate.now().getMonth().compareTo(birthDate.getMonth()) < 0) {
            age = age - 1;
        }
        else if (LocalDate.now().getMonth().compareTo(birthDate.getMonth()) == 0) {
            if (LocalDate.now().getDayOfMonth() < birthDate.getDayOfMonth()) {
                age = age - 1;
            }
        }
        if(age >= 14 && age <= 90) {
            this.birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }

        return age;
    }

    public void changeAddress(String streetAddress, String city, String postalCode) {
        setStreetAddress(streetAddress);
        setCity(city);
        setPostalCode(postalCode);
    }

    public String getStudentAddress() {
        return String.format("%s %s %s", getStreetAddress(), getCity(), getPostalCode());
    }

    public boolean studentInGoodStanding() {
        if(goodStanding == true) {
            return true;
        }
        return false;
    }

    public void suspendStudent() {
        goodStanding = false;
    }

    public int getNoOfYearEnrolled() {
        return enrollmentDate.getYear();
    }

    public void reinstateStudent() {
        goodStanding = true;
    }

    public void setBirthday(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        long diff = Period.between(birthDate, today).getYears();

        if(diff > 100){
            throw new IllegalArgumentException(birthDate + " would make " + firstName + " over 100 years old");
        } else {
            this.birthDate = birthDate;
        }
    }

    public void addCompletedCourse(Course addCourse, int grade) {
        if(grade > 50 && grade < 100){
            CompletedCourse course = new CompletedCourse(addCourse, grade);
            completedCourses.add(course);
        } else if (grade > 100 || grade < 0){
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
        }
    }

    public String getCoursesCompleted() {

            String courses = "[";
            for (CompletedCourse course : completedCourses){
                courses = courses + course.getCourse()+ " grade=" + course.getGrade();
            }
            return courses + "]";

    }


    public boolean hasCompleted(String course) {
        int grades = 0;

        for (CompletedCourse completedCourse : completedCourses) {
            if(completedCourse.getCourse().getCourseCode() == course) {
                grades = completedCourse.getGrade();
                break;
            }
        }

        if(grades < 50){
            return false;
        } else {
            return true;
        }
    }
}