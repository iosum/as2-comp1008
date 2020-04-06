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

    private String prerequisiteCourse;


    /**
     * constructor
     *
     * @param instructor
     * @param courseCode
     * @param courseDescription
     * @param courseRoom
     * @param courseDay
     * @param courseTime
     * @param hours
     */
    public Course(Instructor instructor, String courseCode, String courseDescription, String courseRoom,
                  DayOfWeek courseDay, LocalTime courseTime, int hours) {
        this.instructor = instructor;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.courseRoom = courseRoom;
        this.courseDay = courseDay;
        setCourseTime(courseTime);
        this.hours = hours;
        students = new ArrayList<>();
        setProf(instructor);
    }

    /**
     * constructor
     * @param instructor
     * @param courseCode
     * @param courseDescription
     * @param courseRoom
     * @param courseDay
     * @param courseTime
     * @param hours
     * @param prerequisiteCourse
     */
    public Course(Instructor instructor, String courseCode, String courseDescription,
                  String courseRoom, DayOfWeek courseDay, LocalTime courseTime,
                  int hours, String prerequisiteCourse) {
        this.instructor = instructor;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.courseRoom = courseRoom;
        this.courseDay = courseDay;
        this.courseTime = courseTime;
        this.hours = hours;
        this.prerequisiteCourse = prerequisiteCourse;
        students = new ArrayList<>();
    }

    /**
     * add a professor to a course
     * @param addProf
     * @return
     */
    public Instructor setProf(Instructor addProf) {
        if (addProf.instructorCanTeach(courseCode) == true) {
            return addProf;
        }
        else {
            instructor = null;
            throw new IllegalArgumentException("Professor " + addProf.toString() + " is not qualified to teach " + courseCode);
        }
    }

    /**
     * get an instructor
     * @return
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * get the course code
     * @return
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * set the course time between 8-18
     * @param courseTime
     */

    public void setCourseTime(LocalTime courseTime) {
        if (courseTime.getHour() >= 8 && courseTime.getHour() < 18) {
            this.courseTime = courseTime;
        }
        else {
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }
    }

    /**
     * return course code and course description
     * @return
     */
    public String toString() {
        return String.format("%s-%s", courseCode, courseDescription);
    }

    /**
     * get the classroom of a course
     * @return
     */
    public String getClassRoom() {
        return courseRoom;
    }

    /**
     * get the course day and time
     * @return
     */

    public String getCourseDayAndTime() {
        String time = "";
        time = time + courseDay;
        time = time + "'s, starting at " + courseTime;
        return time;
    }

    /**
     * know which instructor is able to teach
     * @return
     */
    public Instructor getInstructorToTeach() {
        return getInstructor();
    }

    /**
     * add students into a course, which must complete prerequisite course,
     * be in good standing and the size of the
     * course can not be over 40
     * @param newStudent
     * @return
     */
    public String addStudent(Student newStudent) {
        String result = "";
        if (prerequisiteCourse != null) {
            if (!newStudent.getCoursesCompleted().contains(prerequisiteCourse)) {
                result = "Student has not completed the prerequisite course: " + prerequisiteCourse;
            }
            else {
                students.add(newStudent);
            }
        }
        else if (!newStudent.studentInGoodStanding()) {
            result = "The Student is not in good standing and cannot join the course.";
        }
        else if (students.size() >= maxStudents && students.size() > 0) {
            result = "Student was not added because the course is full";
        }
        else {
            students.add(newStudent);
        }

        return result;
    }

    /**
     * display the class list
     *
     * @return
     */
    public String displayTheClassList() {
        String classList = "";
        for (Student student : students) {
            classList += student;
        }
        return classList;
    }

    /**
     * set the class size which cannot exceed 40 students
     * @param classSize
     * @return
     */
    public String setClassSize(int classSize) {
        String result = "";
        if (classSize > 40) {
            classSize = 40;
            maxStudents = 40;
            result += "Max class size = 40, it has been set to 40";
        }
        return result;
    }

    /**
     * get the current number of students in a class
     * @return
     */
    public int getClassSize() {
        return maxStudents;
    }

    /**
     * check if the average age of students were over 25 or not
     * @return
     */
    public boolean matureClass() {
        double allStudentAge = 0;
        int sum = 0;

        for (Student student : students) {
            allStudentAge = allStudentAge + student.getStudentAge();
            sum = sum + 1;
        }
        double average = allStudentAge / sum;

        if (average > 25) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * get prerequisite courses
     * @return
     */
    public String checkPrerequisite() {
        return prerequisiteCourse;
    }

}
