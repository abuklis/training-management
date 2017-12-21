package by.bsu.trainingmanagement.controller;

import by.bsu.trainingmanagement.entity.Training;
import by.bsu.trainingmanagement.entity.User;
import by.bsu.trainingmanagement.service.ITrainingService;
import by.bsu.trainingmanagement.service.IUserService;
import by.bsu.trainingmanagement.service.dto.StudentTrainingDTO;
import by.bsu.trainingmanagement.service.dto.TeacherDTO;
import by.bsu.trainingmanagement.service.dto.TrainingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
@RestController
@RequestMapping(value = "/api")
public class TrainingController {
    private final ITrainingService service;
    private final IUserService userService;

    @Autowired
    public TrainingController(ITrainingService service, IUserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping(value = "/trainings")
    public List<Training> viewTrainings(){
        return service.findTrainings();
    }

    @GetMapping(value = "/trainings/{id}")
    public Training findTraining(@PathVariable("id") int trainingId){
        return service.findTraining(trainingId);
    }

    @GetMapping(value = "/trainings/{id}/teacher")
    public User viewTrainingTeacher(@PathVariable("id") int trainingId){
        return service.findTraining(trainingId).getTeacher();
    }

    @PostMapping(value = "/trainings/{id}/users/me")
    public void registerUserOnTraining(@PathVariable("id") int trainingId, @RequestBody StudentTrainingDTO studentDto){
        userService.registerUserOnTraining(studentDto.getUserId(), trainingId);
    }

    @PutMapping(value = "/trainings/{id}/teacher")
    public void updateTraining(@RequestBody TeacherDTO teacherDTO , @PathVariable("id") int trainingId){
        service.updateTrainingTeacher(trainingId, teacherDTO.getTeacherId());
    }

    @DeleteMapping(value = "/trainings/{id}")
    public void deleteTraining(@PathVariable("id") int trainingId){
        service.deleteTraining(trainingId);
    }

    /**
     * Method for adding new training
     * @param trainingDTO
     */
//    @PostMapping(value = "/trainings")
//    public void addTraining(@RequestBody TrainingDTO trainingDTO){
//        service.addTraining(trainingDTO);
//    }

    /***
     * TODO FIX IT!!!
     * Method for updating certain training
     * @param trainingDTO
     * @param trainingId
     */
    @PatchMapping(value = "/trainings/{id}")
    public void updateTrainingWithPatch(@RequestBody TrainingDTO trainingDTO, @PathVariable("id") int trainingId){
        service.updateTraining(trainingDTO, trainingId);
    }

}
