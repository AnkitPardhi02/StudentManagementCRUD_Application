package StudentManagement.Service;

import StudentManagement.Model.StudentModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentManagementServiceImpl {
    void insertOneStudent(StudentModel studentModel);
    void insertListStudent(List<StudentModel> studentModel);
    List<StudentModel> fetchListStudent();
    StudentModel fetchOneStudent();
    StudentModel updateOneStudent( StudentModel studentModel);
    boolean deleteOneStudent(int id);
    void deleteAllStudent();

}
