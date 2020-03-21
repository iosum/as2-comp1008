import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class Course {
    private Instructor instructor;
    private String courseCode;
    private String courseDescription;
    private String courseRoom;
    private DayOfWeek courseDay;
    private LocalTime courseTime;
    private int hours;
    public ArrayList<Student> students;
    private int maxStudents;
    private int classSize;

    public Course(Instructor instructor, String courseCode, String courseDescription, String courseRoom,
                  DayOfWeek courseDay, LocalTime courseTime, int hours) {
        this.instructor = instructor;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.courseRoom = courseRoom;
        this.courseDay = courseDay;
        this.courseTime = courseTime;
        this.hours = hours;
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }

    public DayOfWeek getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(DayOfWeek courseDay) {
        this.courseDay = courseDay;
    }

    public LocalTime getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(LocalTime courseTime) {
        this.courseTime = courseTime;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String toString() {
        return String.format("%s-%s", courseCode, courseDescription);
    }

    public String getClassRoom() {
        return courseRoom;
    }

    public String getCourseDayAndTime() {
        String time = "";
        time = time + courseDay;
        time = time + "'s, starting at " + courseTime;

        return time;
    }

    public Instructor getInstructorToTeach() {
        return getInstructor();
    }

    public String addStudent(Student newStudent) {
        String result = "";
        students.add(newStudent);
        if(!newStudent.studentInGoodStanding()) {
            result += "The Student is not in good standing and cannot join the course.";
        }
        else if(students.size() >= maxStudents) {
            result += "Student was not added because the course is full";
        }
        return result;
    }

    public String displayTheClassList() {
        String classList = "";
        for (Student student : students) {
            classList += student;
        }
        return classList;
    }

    public String setClassSize(int classSize) {
        String result = "";
        if(classSize > 40) {
            classSize = 40;
            maxStudents = 40;
            result += "Max class size = 40, it has been set to 40";
        }
        return result;
    }

    public int getClassSize() {
        return maxStudents;
    }
}
