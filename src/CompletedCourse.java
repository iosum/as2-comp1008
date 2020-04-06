public class CompletedCourse {
    private Course course;
    private int grade;

    /**
     * constructor
     * @param course
     * @param grade
     */
    public CompletedCourse(Course course, int grade) {
        this.course = course;
        this.grade = grade;
    }

    /**
     * get courses
     * @return
     */
    public Course getCourse() {
        return course;
    }

    /**
     * get grade
     * @return
     */
    public int getGrade() {
        return grade;
    }

    /**
     * set the grade for a lab tech
     * @param grade
     */
    public void setGrade(int grade) {
        if(grade > 100 || grade < 0){
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        } else {
            this.grade = grade;
        }
    }

    /**
     * return courses and grades
     * @return
     */
    public String toString(){
        return "[" + getCourse() + " =" + getGrade();
    }
}
