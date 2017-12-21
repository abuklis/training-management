package by.bsu.trainingmanagement.service;

import by.bsu.trainingmanagement.entity.User;
import by.bsu.trainingmanagement.service.dto.UserDTO;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
public interface IUserService {

    void registerUser(UserDTO userDTO);

    List<User> viewAllUsers();

    User viewUserInfo(int userId);

    User findUser(String email);

    void registerUserOnTraining(int userId, int trainingId);
}
