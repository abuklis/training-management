package by.bsu.trainingmanagement.dao.mapper;

import by.bsu.trainingmanagement.dao.IFacultyDAO;
import by.bsu.trainingmanagement.entity.Faculty;
import by.bsu.trainingmanagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anyab on 07.12.2017.
 */
@Component
public class StudentMapper implements RowMapper {
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String STUDENT_ID = "student_id";
    private static final String FACULTY_ID = "faculty_id";
    private static final String COURSE = "course";
    private static final String GROUP = "group";

    private final IFacultyDAO facultyDAO;

    @Autowired
    public StudentMapper(IFacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Student student = new Student();
        student.setUserId(resultSet.getInt(STUDENT_ID));
        student.setFirstName(resultSet.getString(FIRST_NAME));
        student.setLastName(resultSet.getString(LAST_NAME));
        student.setEmail(resultSet.getString(EMAIL));
        student.setPassword(resultSet.getString(PASSWORD));
        student.setGroup(resultSet.getString(GROUP));
        student.setCourse(resultSet.getInt(COURSE));
        int facultyId = resultSet.getInt(FACULTY_ID);

        Faculty faculty = facultyDAO.findFaculty(facultyId);
        student.setFaculty(faculty);
        return student;
    }
}
