package by.bsu.trainingmanagement.dao.impl;

import by.bsu.trainingmanagement.dao.ITrainingDAO;
import by.bsu.trainingmanagement.dao.mapper.TrainingMapper;
import by.bsu.trainingmanagement.entity.Training;
import by.bsu.trainingmanagement.service.dto.TrainingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anyab on 06.12.2017.
 */
@Repository
public class TrainingDAOImpl implements ITrainingDAO{

    private JdbcTemplate jdbcTemplate;

    private final TrainingMapper trainingMapper;

    private static final String SQL_FIND_TRAINING = "SELECT training_id, title, description, " +
            "attendees_amount, teacher_id, start_date, end_date, is_registration_open FROM trainings WHERE training_id = ?";

    private static final String SQL_FIND_TRAININGS = "SELECT training_id, title, description, " +
            "attendees_amount, teacher_id, start_date, end_date, is_registration_open FROM trainings";

    private static final String SQL_INSERT_TRAINING = "INSERT INTO trainings (title, description, attendees_amount, " +
            "teacher_id, start_date, end_date, is_registration_open) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_TRAINING = "DELETE from trainings WHERE training_id = ?";

    private static final String SQL_UPDATE_TRAINING = "UPDATE trainings SET title = ?, description = ?," +
            " attendees_amount = ?, teacher_id = ?, start_date = ?, end_date = ?, is_registration_open = ? WHERE training_id = ?";

    private static final String SQL_UPDATE_TRAINING_TEACHER = "UPDATE trainings SET teacher_id = ? WHERE training_id = ?";


    @Autowired
    public TrainingDAOImpl(DriverManagerDataSource dataSource, TrainingMapper trainingMapper) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.trainingMapper = trainingMapper;
    }

    @Override
    public void addTraining(TrainingDTO trainingDTO) {
        jdbcTemplate.update(SQL_INSERT_TRAINING, trainingDTO.getTitle(), trainingDTO.getDescription(),
                trainingDTO.getAttendeesAmount(), trainingDTO.getTeacherId(),
                trainingDTO.getStartDate(), trainingDTO.getEndDate(), trainingDTO.getIsRegistrationOpen());
    }

    public void deleteTraining(int trainingId) {
        jdbcTemplate.update(SQL_DELETE_TRAINING, trainingId);
    }

    @Override
    public void updateTraining(TrainingDTO trainingDTO, int trainingId) {
        jdbcTemplate.update(SQL_UPDATE_TRAINING, trainingDTO.getTitle(), trainingDTO.getDescription(),
                trainingDTO.getAttendeesAmount(), trainingDTO.getTeacherId(),
                trainingDTO.getStartDate(), trainingDTO.getEndDate(),
                trainingDTO.getIsRegistrationOpen(), trainingId);
    }

    @Override
    public Training findTraining(int trainingId) {
        return (Training) jdbcTemplate.queryForObject(SQL_FIND_TRAINING,
                new Object[]{trainingId}, trainingMapper);
    }

    @Override
    public List<Training> findTrainings() {
        return (List<Training>) jdbcTemplate.query(SQL_FIND_TRAININGS, trainingMapper);
    }

    @Override
    public void updateTrainingTeacher(int trainingId, int teacherId) {
        jdbcTemplate.update(SQL_UPDATE_TRAINING_TEACHER,
                teacherId, trainingId);
    }
}
