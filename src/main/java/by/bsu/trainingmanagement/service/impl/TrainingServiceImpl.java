package by.bsu.trainingmanagement.service.impl;

import by.bsu.trainingmanagement.dao.ITrainingDAO;
import by.bsu.trainingmanagement.entity.Training;
import by.bsu.trainingmanagement.service.ITrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
@Service
public class TrainingServiceImpl implements ITrainingService{
    private final ITrainingDAO trainingDAO;

    @Autowired
    public TrainingServiceImpl(ITrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    @Override
    public void addTraining(Training training) {

    }

    @Override
    public void deleteTraining(Training training) {

    }

    @Override
    public void updateTraining(Training training) {

    }

    @Override
    public Training findTraining(int trainingId) {
        return null;
    }

    @Override
    public List<Training> findTrainings() {
        return trainingDAO.findTrainings();
    }
}
