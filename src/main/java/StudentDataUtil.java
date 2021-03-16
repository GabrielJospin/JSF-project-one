import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class StudentDataUtil {

    private List<Student> students;

    public StudentDataUtil(){
        loadSampleData();
    }

    private void loadSampleData() {
        students = new ArrayList<Student>();

        students.add(new Student("John", "Travolta", "ACH2053",18,"04674-225"));
        students.add(new Student("Amy", "Winehouse", "ACH2054",28,"04784-265"));
        students.add(new Student("Alexander", "Hamilton", "ACH1776",58,"55555-333"));
    }

    public List<Student> getStudents() {
        return students;
    }

}
