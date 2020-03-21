import java.time.DayOfWeek;
import java.time.LocalTime;

public class Course {
    private Instructor instructor;
    private String courseCode;
    private String courseDescription;
    private String courseRoom;
    private DayOfWeek courseDay;
    private LocalTime courseTime;
    private int hours;

    public Course(Instructor instructor, String courseCode, String courseDescription, String courseRoom, DayOfWeek courseDay, LocalTime courseTime, int hours) {
        this.instructor = instructor;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.courseRoom = courseRoom;
        this.courseDay = courseDay;
        this.courseTime = courseTime;
        this.hours = hours;
    }

    public String toString() {
        return String.format("%s-%s", courseCode,courseDescription);
    }
}
