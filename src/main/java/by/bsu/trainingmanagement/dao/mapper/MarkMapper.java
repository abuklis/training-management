package by.bsu.trainingmanagement.dao.mapper;

import by.bsu.trainingmanagement.dao.ITrainingDAO;
import by.bsu.trainingmanagement.dao.IUserDAO;
import by.bsu.trainingmanagement.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anyab on 07.12.2017.
 */
@Component
public class MarkMapper implements RowMapper {
    private static final String STUDENT_ID = "student_id";
    private static final String TEACHER_ID = "teacher_id";
    private static final String TRAINING_ID = "training_id";
    private static final String MARK_ID = "mark_id";
    private static final String MARK = "mark";


    private final ITrainingDAO trainingDAO;

    private final IUserDAO userDAO;

    @Autowired
    public MarkMapper(ITrainingDAO trainingDAO, IUserDAO userDAO) {
        this.trainingDAO = trainingDAO;
        this.userDAO = userDAO;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Mark mark = new Mark();
        mark.setMarkId(resultSet.getInt(MARK_ID));
        mark.setMark(resultSet.getInt(MARK));

        int teacherId = resultSet.getInt(TEACHER_ID);
        User teacher = userDAO.findTeacher(teacherId);
        mark.setTeacher(teacher);

        int studentId = resultSet.getInt(STUDENT_ID);
        User student = userDAO.findStudent(studentId);
        mark.setStudent(student);

        int trainingId = resultSet.getInt(TRAINING_ID);
        Training training = trainingDAO.findTraining(trainingId);
        mark.setTraining(training);
        return student;
    }
}
