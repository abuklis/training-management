package by.bsu.trainingmanagement.dao.impl;

import by.bsu.trainingmanagement.dao.ITeacherDAO;
import by.bsu.trainingmanagement.dao.mapper.TeacherMapper;
import by.bsu.trainingmanagement.dao.mapper.TrainingMapper;
import by.bsu.trainingmanagement.entity.Teacher;
import by.bsu.trainingmanagement.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

/**
 * Created by anyab on 06.12.2017.
 */
@Repository
public class TeacherDAOImpl implements ITeacherDAO{
    private JdbcTemplate jdbcTemplate;

    private final TeacherMapper teacherMapper;

    private static final String SQL_FIND_TEACHER = "SELECT teacher_id, email, password," +
            " first_name, last_name, position, faculty_id FROM teachers WHERE teacher_id = ?";

    @Autowired
    public TeacherDAOImpl(DriverManagerDataSource dataSource, TeacherMapper teacherMapper) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.teacherMapper = teacherMapper;
    }


    @Override
    public void addTeacher(Training training) {

    }

    @Override
    public void deleteTeacher(Training training) {

    }

    @Override
    public void updateTeacher(Training training) {

    }

    @Override
    public Teacher findTeacher(int teacherId) {
        return (Teacher) jdbcTemplate.queryForObject(SQL_FIND_TEACHER,
                new Object[]{teacherId}, teacherMapper);
    }
}
