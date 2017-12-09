package by.bsu.trainingmanagement.entity;

/**
 * Created by anyab on 06.12.2017.
 */
public class Faculty {
    private int facultyId;
    private String title;

    public Faculty(int facultyId, String title) {
        this.facultyId = facultyId;
        this.title = title;
    }

    public Faculty() {

    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", title='" + title + '\'' +
                '}';
    }
}
