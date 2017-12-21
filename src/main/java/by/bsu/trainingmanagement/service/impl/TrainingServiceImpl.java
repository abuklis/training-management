package by.bsu.trainingmanagement.service.impl;

import by.bsu.trainingmanagement.dao.ITrainingDAO;
import by.bsu.trainingmanagement.entity.Training;
import by.bsu.trainingmanagement.service.ITrainingService;
import by.bsu.trainingmanagement.service.dto.TrainingDTO;
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
    public void addTraining(TrainingDTO trainingDTO) {
        trainingDAO.addTraining(trainingDTO);
    }

    @Override
    public void deleteTraining(int trainingId) {
        trainingDAO.deleteTraining(trainingId);
    }

    @Override
    public void updateTraining(TrainingDTO trainingDTO, int trainingId) {
        trainingDAO.updateTraining(trainingDTO, trainingId);
    }

    @Override
    public Training findTraining(int trainingId) {
        return trainingDAO.findTraining(trainingId);
    }

    @Override
    public List<Training> findTrainings() {
        return trainingDAO.findTrainings();
    }

    @Override
    public void updateTrainingTeacher(int trainingId, int teacherId) {
        trainingDAO.updateTrainingTeacher(trainingId, teacherId);
    }


}
