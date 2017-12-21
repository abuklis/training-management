package by.bsu.trainingmanagement.service.impl;

import by.bsu.trainingmanagement.dao.IUserDAO;
import by.bsu.trainingmanagement.entity.User;
import by.bsu.trainingmanagement.service.IUserService;
import by.bsu.trainingmanagement.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
@Service
public class UserServiceImpl implements IUserService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final IUserDAO userDAO;
    private static final String STUDENT =  "student";

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder, IUserDAO userDAO) {
        this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        User user = new User();
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        if (!isUserExists(email)){
            user.setEmail(email);
            user.setRole(userDTO.getRole());
            user.setPassword(passwordEncoder.encode(password));
            userDAO.registerUser(user);
        }
    }

    @Override
    public List<User> viewAllUsers() {
        return userDAO.viewAllUsers();
    }

    @Override
    public User viewUserInfo(int userId) {
        return userDAO.findUser(userId);
    }

    @Override
    public User findUser(String email) {
        return userDAO.findUserByEmail(email);
    }
    @Override
    public void registerUserOnTraining(int userId, int trainingId){
        if (STUDENT.equalsIgnoreCase(viewUserInfo(userId).getRole())){
            userDAO.registerUserOnTraining(userId, trainingId);
        }
    }

    private boolean isUserExists(String email){
        return userDAO.isUserExists(email);
    }

}
