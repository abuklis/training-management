package by.bsu.trainingmanagement.dao.mapper;

import by.bsu.trainingmanagement.dao.IUserDAO;
import by.bsu.trainingmanagement.entity.Training;
import by.bsu.trainingmanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by anyab on 06.12.2017.
 */
@Component
public class TrainingMapper implements RowMapper {
    private static final String TRAINING_ID = "training_id";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String ATTENDEES_AMOUNT = "attendees_amount";
    private static final String TEACHER_ID = "teacher_id";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String IS_REGISTRATION_OPEN = "is_registration_open";
    private static final String YES = "Y";

    private final IUserDAO userDAO;

    @Autowired
    public TrainingMapper(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Training training = new Training();
        int trainingId = resultSet.getInt(TRAINING_ID);
        training.setTrainingId(trainingId);
        training.setTitle(resultSet.getString(TITLE));
        training.setDescription(resultSet.getString(DESCRIPTION));
        training.setAttendeesAmount(resultSet.getInt(ATTENDEES_AMOUNT));

        Date startDate = resultSet.getDate(START_DATE);
        Date endDate = resultSet.getDate(END_DATE);
        training.setEndDate(endDate);
        training.setStartDate(startDate);
        int teacherId = resultSet.getInt(TEACHER_ID);
        User teacher = userDAO.findTeacher(teacherId);
        training.setTeacher(teacher);

        List<User> users = userDAO.findUsersOnTraining(trainingId);
        training.setUsers(users);
        if (YES.equalsIgnoreCase(resultSet.getString(IS_REGISTRATION_OPEN))){
            training.setRegistrationOpen(Boolean.TRUE);
        } else {
           training.setRegistrationOpen(Boolean.FALSE);
        }
        return training;
    }
}

