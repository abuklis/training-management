package by.bsu.trainingmanagement.service;

import by.bsu.trainingmanagement.entity.Training;
import by.bsu.trainingmanagement.service.dto.TrainingDTO;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
public interface ITrainingService {
    void addTraining(TrainingDTO trainingDTO);

    void deleteTraining(int trainingId);

    void updateTraining(TrainingDTO trainingDTO, int trainingId);

    Training findTraining(int trainingId);

    List<Training> findTrainings();

    void updateTrainingTeacher(int trainingId, int teacherId);
}
