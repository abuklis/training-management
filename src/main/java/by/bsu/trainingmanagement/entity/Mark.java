package by.bsu.trainingmanagement.entity;

/**
 * Created by anyab on 06.12.2017.
 */
public class Mark {
    private int markId;
    private int mark;
    private Student student;
    private Training training;
    private Teacher teacher;

    public Mark(){}

    public Mark(int markId, int mark, Student student, Training training, Teacher teacher) {
        this.markId = markId;
        this.mark = mark;
        this.student = student;
        this.training = training;
        this.teacher = teacher;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markId=" + markId +
                ", mark=" + mark +
                ", student=" + student +
                ", training=" + training +
                ", teacher=" + teacher +
                '}';
    }
}
