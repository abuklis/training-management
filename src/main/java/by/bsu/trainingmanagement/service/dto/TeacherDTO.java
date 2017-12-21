package by.bsu.trainingmanagement.service.dto;

/**
 * Created by anyab on 14.12.2017.
 */
public class TeacherDTO {
    private int teacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "teacherId=" + teacherId +
                '}';
    }
}
