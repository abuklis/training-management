package by.bsu.trainingmanagement.dao;

import by.bsu.trainingmanagement.entity.Training;
import by.bsu.trainingmanagement.service.dto.TrainingDTO;

import java.util.List;

/**
 * Created by anyab on 06.12.2017.
 */
public interface ITrainingDAO {

    void addTraining(TrainingDTO trainingDTO);

    void deleteTraining(int trainingId);

    void updateTraining(TrainingDTO trainingDTO, int trainingId);

    Training findTraining(int trainingId);

    List<Training> findTrainings();

    void updateTrainingTeacher(int trainingId, int teacherId);
}
