package by.bsu.trainingmanagement.dao;

import by.bsu.trainingmanagement.entity.Training;

import java.util.List;

/**
 * Created by anyab on 06.12.2017.
 */
public interface ITrainingDAO {

    void addTraining(Training training);

    void deleteTraining(Training training);

    void updateTraining(Training training);

    Training findTraining(int trainingId);

    List<Training> findTrainings();

}
