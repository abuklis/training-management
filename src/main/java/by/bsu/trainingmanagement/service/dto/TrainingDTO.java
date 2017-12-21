package by.bsu.trainingmanagement.service.dto;

import java.sql.Date;


/**
 * Created by anyab on 09.12.2017.
 */
public class TrainingDTO {
    private String title;
    private String description;
    private int attendeesAmount;
    private int teacher_id;
    private Date startDate;
    private Date endDate;
    private String isRegistrationOpen;

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

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
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

    public String getIsRegistrationOpen() {
        return isRegistrationOpen;
    }

    public void setIsRegistrationOpen(String isRegistrationOpen) {
        this.isRegistrationOpen = isRegistrationOpen;
    }

    @Override
    public String toString() {
        return "TrainingDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", attendeesAmount=" + attendeesAmount +
                ", teacher_id=" + teacher_id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
