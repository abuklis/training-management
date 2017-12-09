package by.bsu.trainingmanagement.dao.mapper;

import by.bsu.trainingmanagement.dao.IFacultyDAO;
import by.bsu.trainingmanagement.dao.IStudentDAO;
import by.bsu.trainingmanagement.dao.ITeacherDAO;
import by.bsu.trainingmanagement.dao.ITrainingDAO;
import by.bsu.trainingmanagement.entity.Student;
import by.bsu.trainingmanagement.entity.Teacher;
import by.bsu.trainingmanagement.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by anyab on 06.12.2017.
 */
@Component
public class TrainingMapper implements RowMapper {
    private static final String TRAINING_ID = "training_id";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String ATTENDEES_AMOUNT = "attendees_amount";
    private static final String TEACHER_ID = "teacher_id";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String IS_REGISTRATION_OPEN = "is_registration_open";
    private static final String YES = "Y";

    private final ITeacherDAO teacherDAO;
    private final IStudentDAO studentDAO;

    @Autowired
    public TrainingMapper(ITeacherDAO teacherDAO,IStudentDAO studentDAO) {
        this.teacherDAO = teacherDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Training training = new Training();
        int trainingId = resultSet.getInt(TRAINING_ID);
        training.setTrainingId(trainingId);
        training.setTitle(resultSet.getString(TITLE));
        training.setDescription(resultSet.getString(DESCRIPTION));
        training.setAttendeesAmount(resultSet.getInt(ATTENDEES_AMOUNT));
        training.setStartDate(resultSet.getDate(START_DATE));
        training.setEndDate(resultSet.getDate(END_DATE));
        int teacherId = resultSet.getInt(TEACHER_ID);
        Teacher teacher= teacherDAO.findTeacher(teacherId);
        training.setTeacher(teacher);

        List<Student> students = studentDAO.findStudentsOnTraining(trainingId);
        training.setStudents(students);
        if (YES.equalsIgnoreCase(resultSet.getString(IS_REGISTRATION_OPEN))){
            training.setRegistrationOpen(Boolean.TRUE);
        } else {
           training.setRegistrationOpen(Boolean.FALSE);
        }
        return training;
    }
}

