package StudentManagement.Service;

import StudentManagement.Model.StudentModel;
import StudentManagement.Repo.StudentManagementRepo;
import StudentManagement.Repo.StudentManagementRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentManagementService implements StudentManagementServiceImpl{
    @Autowired
    private StudentManagementRepoImpl studentManagementRepo;

    @Override
    public void insertOneStudent(StudentModel studentModel) {
        studentManagementRepo.insertOneStudent(studentModel);

    }

    @Override
    public void insertListStudent(List<StudentModel> studentModel) {
        studentManagementRepo.insertListStudent(studentModel);
    }

    @Override
    public List<StudentModel> fetchListStudent() {
      return studentManagementRepo.fetchListStudent();
    }
}
