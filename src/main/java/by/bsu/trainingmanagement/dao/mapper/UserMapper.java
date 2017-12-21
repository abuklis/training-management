package by.bsu.trainingmanagement.dao.mapper;

import by.bsu.trainingmanagement.dao.IFacultyDAO;
import by.bsu.trainingmanagement.entity.Faculty;
import by.bsu.trainingmanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anyab on 07.12.2017.
 */
@Component
public class UserMapper implements RowMapper {
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String USER_ID = "user_id";
    private static final String FACULTY_ID = "faculty_id";
    private static final String ROLE = "role";

    private final IFacultyDAO facultyDAO;

    @Autowired
    public UserMapper(IFacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt(USER_ID));
        user.setFirstName(resultSet.getString(FIRST_NAME));
        user.setLastName(resultSet.getString(LAST_NAME));
        user.setEmail(resultSet.getString(EMAIL));
        user.setPassword(resultSet.getString(PASSWORD));
        int facultyId = resultSet.getInt(FACULTY_ID);
        if (facultyId != 0){
            Faculty faculty = facultyDAO.findFaculty(facultyId);
            user.setFaculty(faculty);
        }
        user.setRole(resultSet.getString(ROLE));
        return user;
    }
}
