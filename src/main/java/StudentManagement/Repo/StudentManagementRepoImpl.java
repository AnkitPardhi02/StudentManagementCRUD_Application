package StudentManagement.Repo;

import StudentManagement.Model.StudentModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentManagementRepoImpl {
    void insertOneStudent(StudentModel studentModel);
    void insertListStudent(List<StudentModel> studentModel);
    List<StudentModel> fetchListStudent();
    StudentModel fetchOneStudent();
    StudentModel updateOneStudent( StudentModel studentModel);
}
