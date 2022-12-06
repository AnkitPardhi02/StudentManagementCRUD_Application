package StudentManagement.Repo;
import StudentManagement.Model.StudentModel;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentManagementRepo implements StudentManagementRepoImpl{
    String url = "jdbc:mysql://localhost:3306/all";
    String username = "root";
    String password ="";
    @Override
    public void insertOneStudent(StudentModel studentModel) {
        String query="insert into data values ('"+studentModel.getId()+"'," +
                "'"+studentModel.getName()+"','"+studentModel.getEmail()+"')";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            st.executeUpdate(query);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public void insertListStudent(List<StudentModel> studentModel) {
        int n=studentModel.size();
        String[] query=new String[n];
        for (int i=0;i<n;i++){
            query[i]="insert into data values ('"+studentModel.get(i).getId()+"'," +
                                               "'"+studentModel.get(i).getName()+"'," +
                                               "'"+studentModel.get(i).getEmail()+"')";
        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            for (int i=0;i<n;i++) {
                st.executeUpdate(query[i]);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public List<StudentModel> fetchListStudent() {
        String query="select * from data";
        List<StudentModel> studentModel =new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            StudentModel sm=new StudentModel();
            while (rs.next()){
                sm.setId(rs.getInt(1));
                sm.setName(rs.getString(2));
                sm.setEmail(rs.getString(3));
                studentModel.add(sm);
            }
        }catch (Exception e){
            System.out.println(e);
        }
return studentModel;
    }
}
