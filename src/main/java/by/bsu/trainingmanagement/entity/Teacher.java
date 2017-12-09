package by.bsu.trainingmanagement.entity;

/**
 * Created by anyab on 06.12.2017.
 */
public class Teacher extends User {
    private String position;

    public Teacher() {
    }

    public Teacher(int userId, String email, String password, String firstName,
                   String lastName, Faculty faculty, String position) {
        super(userId, email, password, firstName, lastName, faculty);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "position='" + position + '\'' +
                '}';
    }
}
