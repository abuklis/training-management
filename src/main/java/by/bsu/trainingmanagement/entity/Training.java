package by.bsu.trainingmanagement.entity;

import java.sql.Date;
import java.util.List;

/**
 * Created by anyab on 06.12.2017.
 */
public class Training {
    private int trainingId;
    private String title;
    private String description;
    private int attendeesAmount;
    private Teacher teacher;
    private Date startDate;
    private Date endDate;
    private boolean isRegistrationOpen;
    private List<Student> students;

    public Training() {
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttendeesAmount() {
        return attendeesAmount;
    }

    public void setAttendeesAmount(int attendeesAmount) {
        this.attendeesAmount = attendeesAmount;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isRegistrationOpen() {
        return isRegistrationOpen;
    }

    public void setRegistrationOpen(boolean registrationOpen) {
        isRegistrationOpen = registrationOpen;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Training{" +
                "trainingId=" + trainingId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", attendeesAmount=" + attendeesAmount +
                ", teacher=" + teacher +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isRegistrationOpen=" + isRegistrationOpen +
                ", students=" + students +
                '}';
    }
}
