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

    /**
     * constructor
     * @param firstName
     * @param lastName
     * @param city
     * @param streetAddress
     * @param postalCode
     * @param program
     * @param studentNumber
     * @param enrollmentDate
     * @param birthDate
     */
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

    /**
     * get student city
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * set student city
     * @param city
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * get student street address
     * @return
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * set student street address
     * @param streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * get student postal code
     * @return
     */

    public String getPostalCode() {
        return postalCode;
    }


    /**
     * set student postal code
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    /**
     * get student number
     * @return
     */

    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * set valid birthday
     * @param birthDate
     */
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

    /**
     * format the string
     * @return
     */
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

    /**
     * change the address
     * @param streetAddress
     * @param city
     * @param postalCode
     */
    public void changeAddress(String streetAddress, String city, String postalCode) {
        setStreetAddress(streetAddress);
        setCity(city);
        setPostalCode(postalCode);
    }

    /**
     * get student's address and format
     * @return
     */
    public String getStudentAddress() {
        return String.format("%s %s %s", getStreetAddress(), getCity(), getPostalCode());
    }

    /**
     * check if a student is in a good standing
     * @return
     */
    public boolean studentInGoodStanding() {
        if(goodStanding == true) {
            return true;
        }
        return false;
    }

    /**
     * suspend student
     */
    public void suspendStudent() {
        goodStanding = false;
    }

    /**
     * gets the year of enrollment of student
     * @return
     */
    public int getNoOfYearEnrolled() {
        return enrollmentDate.getYear();
    }

    /**
     * reinstates student
     */
    public void reinstateStudent() {
        this.goodStanding = true;
    }

    /**
     * sets the student's birthday
     * @param birthDate
     */
    public void setBirthday(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        long diff = Period.between(birthDate, today).getYears();

        if(diff > 100){
            throw new IllegalArgumentException(birthDate + " would make " + firstName + " over 100 years old");
        } else {
            this.birthDate = birthDate;
        }
    }

    /**
     * adds a course if a student completed
     * @param addCourse
     * @param grade
     */
    public void addCompletedCourse(Course addCourse, int grade) {
        if(grade > 50 && grade < 100){
            CompletedCourse course = new CompletedCourse(addCourse, grade);
            completedCourses.add(course);
        } else if (grade > 100 || grade < 0){
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
        }
    }

    /**
     * get all the completed courses from student
     * @return
     */
    public String getCoursesCompleted() {
            String courses = "[";
            for (CompletedCourse course : completedCourses){
                courses = courses + course.getCourse()+ " grade=" + course.getGrade();
            }
            return courses + "]";

    }

    /**
     * check if the course completes or not
     * @param course
     * @return
     */
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