package by.bsu.trainingmanagement.dao;

import by.bsu.trainingmanagement.entity.User;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
public interface IUserDAO {
    void registerUser(User user);

    boolean isUserExists(String email);

    List<User> findUsersOnTraining(int trainingId);

    User findTeacher(int userId);

    User findStudent(int studentId);

    List<User> viewAllUsers();

    User findUser(int userId);

    User findUserByEmail(String email);

    void registerUserOnTraining(int userId, int trainingId);
}
