package StudentManagement.Controller;
import StudentManagement.Model.StudentModel;
import StudentManagement.Service.StudentManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
public class StudentManagementController {
    @Autowired
    private StudentManagementServiceImpl studentManagementService;
    @RequestMapping("/insertOne")
    @ResponseBody
    void insertOneStudent(@RequestBody StudentModel studentModel){
        studentManagementService.insertOneStudent(studentModel);
    }
    @RequestMapping("/insertList")
    @ResponseBody
    void insertListStudent(@RequestBody List<StudentModel> studentModel){
        studentManagementService.insertListStudent(studentModel);
    }
    @RequestMapping("/FetchOneData")
    @ResponseBody
    StudentModel  fetchOneStudent(){
        return studentManagementService.fetchOneStudent();

    }
    @RequestMapping("/FetchListOfData")
    @ResponseBody
    List<StudentModel> fetchListStudent(){
        return studentManagementService.fetchListStudent();
    }
    @RequestMapping("/UpdateOneData")
    @ResponseBody
    StudentModel updateOneStudent(@RequestBody StudentModel studentModel){
        return studentManagementService.updateOneStudent(studentModel);
    }
    @RequestMapping("/DeleteOneData")
    @ResponseBody
    boolean deleteOneStudent(@RequestParam int id){
        return studentManagementService.deleteOneStudent(id);
    }
    @RequestMapping("/DeleteAllData")
    @ResponseBody
    void deleteAllStudent(){
        studentManagementService.deleteAllStudent();

    }





}
