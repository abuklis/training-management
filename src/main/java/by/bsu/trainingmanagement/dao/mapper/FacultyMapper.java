package by.bsu.trainingmanagement.dao.mapper;

import by.bsu.trainingmanagement.entity.Faculty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anyab on 07.12.2017.
 */
public class FacultyMapper implements RowMapper {
    private static final String TITLE = "title";
    private static final String FACULTY_ID = "faculty_id";

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Faculty faculty = new Faculty();
        faculty.setFacultyId(rs.getInt(FACULTY_ID));
        faculty.setTitle(rs.getString(TITLE));
        return faculty;
    }
}
