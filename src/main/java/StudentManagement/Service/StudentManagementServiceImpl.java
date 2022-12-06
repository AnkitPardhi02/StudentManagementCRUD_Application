package StudentManagement.Service;

import StudentManagement.Model.StudentModel;

import java.util.List;

public interface StudentManagementServiceImpl {
    void insertOneStudent(StudentModel studentModel);
    void insertListStudent(List<StudentModel> studentModel);
    List<StudentModel> fetchListStudent();
}
