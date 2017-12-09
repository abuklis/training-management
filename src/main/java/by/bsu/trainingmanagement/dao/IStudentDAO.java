package by.bsu.trainingmanagement.dao;

import by.bsu.trainingmanagement.entity.Student;

import java.util.List;

/**
 * Created by anyab on 07.12.2017.
 */
public interface IStudentDAO {

    void addStudent(Student student);

    void deleteStudent(Student student);

    void updateStudent(Student student);

    Student findStudent(int studentId);

    List<Student> findStudentsOnTraining(int trainingId);
}
