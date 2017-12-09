package by.bsu.trainingmanagement.dao;

import by.bsu.trainingmanagement.entity.Faculty;

/**
 * Created by anyab on 07.12.2017.
 */
public interface IFacultyDAO{

    void addFaculty(Faculty faculty);

    void deleteFaculty(Faculty faculty);

    void updateFaculty(Faculty faculty);

    Faculty findFaculty(int facultyId);
}
