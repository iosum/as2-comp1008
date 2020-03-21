import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseWithLab extends Course{
    private Instructor instructor;
    private String courseCode;
    private String courseDescription;
    private String courseRoom;
    private DayOfWeek courseDay;
    private LocalTime courseTime;
    private int hours;
    private Instructor labTech;
    private String labRoom;
    private DayOfWeek labDay;
    private LocalTime labTime;

    public CourseWithLab(Instructor instructor, String courseCode, String courseDescription, String courseRoom, DayOfWeek courseDay, LocalTime courseTime, int hours, Instructor labTech, String labRoom, DayOfWeek labDay, LocalTime labTime) {
        super(instructor, courseCode, courseDescription, courseRoom, courseDay, courseTime, hours);
        this.instructor = instructor;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.courseRoom = courseRoom;
        this.courseDay = courseDay;
        this.courseTime = courseTime;
        this.hours = hours;
        setLabTech(labTech);
        this.labRoom = labRoom;
        this.labDay = labDay;
        this.labTime = labTime;
    }


    public void setLabTech(Instructor labTech){
        if(labTech.instructorCanTeach(courseCode+"-LAB")){
            this.labTech = labTech;
        } else {
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        }
    }


    public String toString() {
        return String.format("%s-%s with lab", courseCode, courseDescription);
    }
}
