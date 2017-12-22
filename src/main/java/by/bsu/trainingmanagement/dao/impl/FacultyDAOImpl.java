package by.bsu.trainingmanagement.dao.impl;

import by.bsu.trainingmanagement.dao.IFacultyDAO;
import by.bsu.trainingmanagement.dao.mapper.FacultyMapper;
import by.bsu.trainingmanagement.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

/**
 * Created by anyab on 07.12.2017.
 */
@Repository
public class FacultyDAOImpl implements IFacultyDAO{
    private static final String SQL_FIND_FACULTY = "SELECT faculty_id, title FROM faculties WHERE faculty_id = ?";
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FacultyDAOImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void addFaculty(Faculty faculty) {

    }

    @Override
    public void deleteFaculty(Faculty faculty) {

    }

    @Override
    public void updateFaculty(Faculty faculty) {

    }

    @Override
    public Faculty findFaculty(int facultyId) {
        return (Faculty) jdbcTemplate.queryForObject(SQL_FIND_FACULTY,
                new Object[]{facultyId}, new FacultyMapper());
    }
}
