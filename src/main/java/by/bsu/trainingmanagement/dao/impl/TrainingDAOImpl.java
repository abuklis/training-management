package by.bsu.trainingmanagement.dao.impl;

import by.bsu.trainingmanagement.dao.ITrainingDAO;
import by.bsu.trainingmanagement.dao.mapper.StudentMapper;
import by.bsu.trainingmanagement.dao.mapper.TrainingMapper;
import by.bsu.trainingmanagement.entity.Student;
import by.bsu.trainingmanagement.entity.Training;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger LOGGER = Logger.getLogger(TrainingDAOImpl.class);

    private static final String SQL_FIND_TRAINING = "SELECT training_id, title, description, " +
            "attendees_amount, teacher_id, start_date, end_date, is_registration_open FROM trainings WHERE training_id = ?";

    private static final String SQL_FIND_TRAININGS = "SELECT training_id, title, description, " +
            "attendees_amount, teacher_id, start_date, end_date, is_registration_open FROM trainings";

    @Autowired
    public TrainingDAOImpl(DriverManagerDataSource dataSource, TrainingMapper trainingMapper, StudentMapper studentMapper) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.trainingMapper = trainingMapper;
    }
    @Override
    public void addTraining(Training training) {

    }

    public void deleteTraining(Training training) {

    }
    @Override
    public void updateTraining(Training training) {

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

}
