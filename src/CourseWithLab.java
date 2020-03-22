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
    private int numOfStudents;

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
        setLabTime(labTime);
    }

    public CourseWithLab(Instructor instructor, String courseCode, String courseDescription, String courseRoom,
                         DayOfWeek courseDay, LocalTime courseTime, int hours, String prerequisiteCourse,
                         Instructor labTech, String labRoom, DayOfWeek labDay, LocalTime labTime) {
        super(instructor, courseCode, courseDescription, courseRoom, courseDay, courseTime,hours, prerequisiteCourse);

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

    private void setLabTime(LocalTime labTime) {
        if (labTime.getHour() >= 8 && labTime.getHour() < 18) {
            this.labTime = labTime;
        }
        else {
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
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

    public String getLabClassAndTime() {
        String time = "room: " + labRoom + ", ";
        time += labDay + " starting at " + labTime;
        return time;
    }

    public Instructor getLabTech() {
        return labTech;
    }
}
