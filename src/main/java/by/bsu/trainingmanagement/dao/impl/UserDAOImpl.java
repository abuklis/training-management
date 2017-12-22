package by.bsu.trainingmanagement.dao.impl;

import by.bsu.trainingmanagement.dao.IUserDAO;
import by.bsu.trainingmanagement.dao.mapper.UserMapper;
import by.bsu.trainingmanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anyab on 09.12.2017.
 */
@Repository
public class UserDAOImpl implements IUserDAO {

    private static final String SQL_FIND_USER = "SELECT users.user_id, users.email, users.password, " +
            "users.first_name, users.last_name, users.faculty_id, users.role from users WHERE user_id = ?";

    private static final String SQL_INSERT_USER = "INSERT INTO users (email, password, role) " +
            " VALUES (?, ?, ?)";
    private static final String SQL_FIND_USER_BY_EMAIL = "SELECT user_id, email, password," +
            " first_name, last_name, faculty_id, role FROM users WHERE email = ?";

    private static final String SQL_FIND_USERS = "SELECT users.user_id, users.email, users.password, " +
            "users.first_name, users.last_name, users.faculty_id, users.role from users";

    private static final String SQL_FIND_USERS_BY_TRAINING = "SELECT users.user_id, users.email, users.password, " +
            "users.first_name, users.last_name, users.faculty_id, users.role from users join training_students " +
            "on users.user_id = training_students.student_id where training_students.training_id = ?";

    private static final String SQL_FIND_TEACHER = "SELECT user_id, email, password," +
            " first_name, last_name, faculty_id, role FROM users WHERE user_id = ? AND role=UPPER('teacher')";


    private static final String SQL_IS_USER_EXISTS = "SELECT COUNT(*) FROM users WHERE email = ?";

    private static final String SQL_FIND_STUDENT = "SELECT user_id, email, password," +
            " first_name, last_name, faculty_id, role FROM users WHERE user_id = ? AND role=UPPER('student')";
    private static final String SQL_ADD_USER_ON_TRAINING = "INSERT into training_students (training_id, student_id) " +
            " VALUES (?, ?)";

    private final JdbcTemplate jdbcTemplate;

    private final UserMapper userMapper;

    @Autowired
    public UserDAOImpl(DriverManagerDataSource dataSource, UserMapper userMapper) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.userMapper = userMapper;
    }

    @Override
    public void registerUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER , new Object[] {
                user.getEmail(), user.getPassword(), user.getRole()});
    }

    @Override
    public boolean isUserExists(String email) {
        Integer userId = jdbcTemplate.queryForObject(SQL_IS_USER_EXISTS, Integer.class, email);
        return userId != 0;
    }

    @Override
    public List<User> findUsersOnTraining(int trainingId) {
        return (List<User>) jdbcTemplate.query(SQL_FIND_USERS_BY_TRAINING,
                new Object[]{trainingId}, userMapper);
    }

    @Override
    public User findTeacher(int teacherId) {
        return (User) jdbcTemplate.queryForObject(SQL_FIND_TEACHER,
                new Object[]{teacherId}, userMapper);
    }

    @Override
    public User findStudent(int studentId) {
        return (User) jdbcTemplate.queryForObject(SQL_FIND_STUDENT,
                new Object[]{studentId}, userMapper);
    }

    @Override
    public List<User> viewAllUsers() {
        return (List<User>) jdbcTemplate.query(SQL_FIND_USERS, userMapper);
    }

    @Override
    public User findUser(int userId) {
        return (User) jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] {userId},
                userMapper);
    }

    @Override
    public User findUserByEmail(String email) {
        return (User) jdbcTemplate.queryForObject(SQL_FIND_USER_BY_EMAIL, userMapper, email);
    }

    @Override
    public void registerUserOnTraining(int userId, int trainingId) {
        jdbcTemplate.update(SQL_ADD_USER_ON_TRAINING, trainingId, userId);
    }
}
