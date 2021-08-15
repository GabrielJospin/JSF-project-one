import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentDBUtil {

    private List<Student> students;

    public List<Student> getStudents() throws SQLException, ClassNotFoundException {

        students = new ArrayList<Student>();
        Connect connect = Connect.getInstance();
        ResultSet rs = connect.st.executeQuery("select * from users order by LastName, firstName");

        return creatStudents(rs);

    }

    public void addStudent(Student student) throws SQLException, ClassNotFoundException {
        Connect connect = Connect.getInstance();
        connect.st.executeUpdate("insert into users (firstName, lastName, courseCode, age, cep) "+
                "values ('"+student.getFirstName()+"','"+
                student.getLastName()+"','"+
                student.getCourseCode()+"','"+
                student.getAge()+"','"+
                student.getCep() +"')");

    }

    public Student getStudent(int id) throws Exception{
        Connect connect = Connect.getInstance();
        ResultSet rs = connect.st.executeQuery("select  * from users where id = "+id);
        Student theStudent = null;
        if(rs.next()){
            id = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String courseCode = rs.getString(4);
            int age = rs.getInt(5);
            String cep = rs.getString(6);

            theStudent = new Student(id,firstName,lastName,courseCode,age,cep);
        }else{
           throw new Exception("Cold not dinf student id: "+id);
        }
        return theStudent;
    }

    public void updateStudent(Student student) throws SQLException, ClassNotFoundException {
        Connect connect = Connect.getInstance();
        connect.st.executeUpdate("update users set " +
                "   firstName = '"+ student.getFirstName()+
                "', lastName = '"+ student.getLastName()+
                "', courseCode = '"+ student.getCourseCode()+
                "', age = '"+ student.getAge()+
                "', cep ='"+ student.getCep() +
                "' where id ="+ student.getId());

    }

    public void deleteStudent(int id) throws SQLException, ClassNotFoundException {
        Connect connect = Connect.getInstance();
        connect.st.executeUpdate("delete from users where id ="+ id);
    }

    public List<Student> searchStudents(String theSearchName) throws SQLException, ClassNotFoundException {
        Connect connect = Connect.getInstance();
        ResultSet rs;

        if(theSearchName != null && theSearchName.trim().length() > 0){
            rs = connect.st.executeQuery("select * from users where " +
                    "lower(firstName) like '%"+theSearchName.toLowerCase()+"%' or " +
                    "lower(lastName) like  '%"+theSearchName.toLowerCase()+"%'");
        }else{
            rs = connect.st.executeQuery("select  * from student order by lastName");
        }

        return creatStudents(rs);
    }

    private List<Student> creatStudents(ResultSet rs) throws SQLException {
        while (rs.next()){
            int id = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String courseCode = rs.getString(4);
            int age = rs.getInt(5);
            String cep = rs.getString(6);

            Student tempStudent = new Student(id,firstName,lastName,courseCode,age,cep);

            students.add(tempStudent);

        }

        return students;
    }
}
