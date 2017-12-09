package by.bsu.trainingmanagement.dao.mapper;

import by.bsu.trainingmanagement.dao.IFacultyDAO;
import by.bsu.trainingmanagement.entity.Faculty;
import by.bsu.trainingmanagement.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anyab on 06.12.2017.
 */
@Component
public class TeacherMapper implements RowMapper {
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String TEACHER_ID = "teacher_id";
    private static final String POSITION = "position";
    private static final String FACULTY_ID = "faculty_id";

    private final IFacultyDAO facultyDAO;

    @Autowired
    public TeacherMapper(IFacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setUserId(rs.getInt(TEACHER_ID));
        teacher.setFirstName(rs.getString(FIRST_NAME));
        teacher.setLastName(rs.getString(LAST_NAME));
        teacher.setEmail(rs.getString(EMAIL));
        teacher.setPassword(rs.getString(PASSWORD));
        int facultyId = rs.getInt(FACULTY_ID);
        Faculty faculty = facultyDAO.findFaculty(facultyId);
        teacher.setFaculty(faculty);
        teacher.setPosition(rs.getString(POSITION));
        return teacher;
    }
}
