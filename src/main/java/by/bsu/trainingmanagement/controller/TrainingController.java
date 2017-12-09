package by.bsu.trainingmanagement.controller;

import by.bsu.trainingmanagement.entity.Training;
import by.bsu.trainingmanagement.service.ITrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
@RestController
public class TrainingController {
    private final ITrainingService service;

    @Autowired
    public TrainingController(ITrainingService service) {
        this.service = service;
    }

    @GetMapping(value = "/trainings")
    public List<Training> viewTrainings(){
        return service.findTrainings();
    }

    @GetMapping(value = "/trainings/{id}")
    public Training findTraining(@PathVariable("id") int trainingId){
        return service.findTraining(trainingId);
    }

  

}
