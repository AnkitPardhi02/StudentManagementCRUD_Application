package StudentManagement.Repo;

import StudentManagement.Model.StudentModel;

import java.util.List;

public interface StudentManagementRepoImpl {
    void insertOneStudent(StudentModel studentModel);
    void insertListStudent(List<StudentModel> studentModel);
    List<StudentModel> fetchListStudent();
}
