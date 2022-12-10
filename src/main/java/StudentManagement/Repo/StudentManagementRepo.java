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


//-----------------------------insert one data ---------------------------------------
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
    //--------------------------insert list of data -----------------------------------
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
    //-------------------------------fetch one data -----------------------------
    @Override
    public StudentModel fetchOneStudent() {
        int id=9325;
        String query="select * from data where id='"+id+"'";
        StudentModel sm=new StudentModel();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);
//            StudentModel sm=new StudentModel();
            while (rs.next()){
                sm.setId(rs.getInt(1));
                sm.setName(rs.getString(2));
                sm.setEmail(rs.getString(3));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return sm;

    }
    //----------------------------------fetch list of data -------------------------------------
    @Override
    public List<StudentModel> fetchListStudent() {
        String query="select * from data";
        List<StudentModel> studentModel =new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);

            while (rs.next()){
                StudentModel sm=new StudentModel();
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
    //-----------------------------------update one data--------------------------------------------

    @Override
    public StudentModel updateOneStudent(StudentModel studentModel) {
        int id=9325;
       String query="update data set name='"+studentModel.getName()+"'" +
                ",email='"+studentModel.getEmail()+"' where id='"+id+"' ";
        String query1="select * from data where id ='"+id+"' ";
        StudentModel studentModel1=new StudentModel();
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection(url,username,password);
           Statement st=connection.createStatement();
           st.executeUpdate(query);
           ResultSet rs=st.executeQuery(query1);
           while (rs.next()){
               studentModel1.setId(rs.getInt(1));
               studentModel1.setName(rs.getString(2));
               studentModel1.setEmail(rs.getString(3));
           }

       }catch (Exception exception){
           System.out.println(exception);
       }
       return studentModel1;
    }
    //-------------------------------delete one student -------------------------------------

    @Override
    public boolean deleteOneStudent(int id) {
        String query="delete from data where id='"+id+"'";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            int result=  st.executeUpdate(query);
            if (result==0){
                System.out.println("not deleted try again");
                return false;

            }

        }catch (Exception exception){
            System.out.println(exception);
        }
        return true;
    }
    //--------------------------delete all data from table-------------------------


    @Override
    public void deleteAllStudent() {
        String query="delete from data";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
