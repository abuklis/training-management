package by.bsu.trainingmanagement.dao.impl;

import by.bsu.trainingmanagement.dao.IStudentDAO;
import by.bsu.trainingmanagement.dao.mapper.StudentMapper;
import by.bsu.trainingmanagement.dao.mapper.TrainingMapper;
import by.bsu.trainingmanagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anyab on 07.12.2017.
 */
@Repository
public class StudentDAOImpl implements IStudentDAO {
    private static final String SQL_FIND_STUDENTS_BY_TRAINING = "SELECT  students.student_id, students.email, students.password, students.first_name, students.last_name, " +
            "  students.course, students.group, students.faculty_id from students join trainings_students on students.student_id = trainings_students.student_id " +
            " where trainings_students.training_id = ?";

    private JdbcTemplate jdbcTemplate;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentDAOImpl(DriverManagerDataSource dataSource, StudentMapper studentMapper) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.studentMapper = studentMapper;
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public void updateStudent(Student student) {
    }

    @Override
    public Student findStudent(int studentId) {
        return null;
    }

    @Override
    public List<Student> findStudentsOnTraining(int trainingId) {
        return (List<Student>) jdbcTemplate.query(SQL_FIND_STUDENTS_BY_TRAINING,
                new Object[]{trainingId}, studentMapper);
    }
}
