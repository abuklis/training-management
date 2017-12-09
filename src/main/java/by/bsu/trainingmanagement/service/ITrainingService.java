package by.bsu.trainingmanagement.service;

import by.bsu.trainingmanagement.entity.Training;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
public interface ITrainingService {
    void addTraining(Training training);

    void deleteTraining(Training training);

    void updateTraining(Training training);

    Training findTraining(int trainingId);

    List<Training> findTrainings();
}
