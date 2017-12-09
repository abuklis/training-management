package by.bsu.trainingmanagement.entity;

/**
 * Created by anyab on 06.12.2017.
 */
public class Student extends User {
    private int course;
    private String group;

    public Student(int userId, String email, String password, String firstName,
                   String lastName, Faculty faculty, int course, String group) {
        super(userId, email, password, firstName, lastName, faculty);
        this.course = course;
        this.group = group;
    }

    public Student() {

    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", group='" + group + '\'' +
                '}';
    }
}
