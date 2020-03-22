public class CompletedCourse {
    private Course course;
    private int grade;

    public CompletedCourse(Course course, int grade) {
        this.course = course;
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if(grade > 100 || grade < 0){
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        } else {
            this.grade = grade;
        }
    }

    public String toString(){
        return "[" + getCourse() + " =" + getGrade();
    }
}
