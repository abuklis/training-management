package by.bsu.trainingmanagement.dao;

import by.bsu.trainingmanagement.entity.Teacher;
import by.bsu.trainingmanagement.entity.Training;

/**
 * Created by anyab on 06.12.2017.
 */
public interface ITeacherDAO {

    void addTeacher(Training training);

    void deleteTeacher(Training training);

    void updateTeacher(Training training);

    Teacher findTeacher(int teacherId);
}
