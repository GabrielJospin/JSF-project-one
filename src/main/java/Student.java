import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class Student {

    private String firstName;
    private String lastName;
    private String course;
    private List<String> courseOptions;
    private String typeOfStudent;
    private List<String> typeOfStudentOptions;
    private List<String> aids;
    private List<String> aidsOptions;

    public Student() {
        //Country list construct
        courseOptions = new ArrayList<String>();
        courseOptions.add("Information System");
        courseOptions.add("Nutrition");
        courseOptions.add("Medicine");
        courseOptions.add("Advocacy");
        courseOptions.add("Engineering");
        courseOptions.add("physiotherapy");
        courseOptions.add("psychology");

        //Country list construct
        typeOfStudentOptions = new ArrayList<String>();
        typeOfStudentOptions.add("graduate");
        typeOfStudentOptions.add("pos-graduate");
        typeOfStudentOptions.add("Master");
        typeOfStudentOptions.add("Doctorate");
        typeOfStudentOptions.add("PHD");

        //Aids
        aids = new ArrayList<String>();
        aidsOptions = new ArrayList<String>();
        aidsOptions.add("Papef");
        aidsOptions.add("Transport");
        aidsOptions.add("University");
        aidsOptions.add("Food");
        aidsOptions.add("Medical");
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<String> getCourseOptions() {
        return courseOptions;
    }

    public String getTypeOfStudent() {
        return typeOfStudent;
    }

    public void setTypeOfStudent(String typeOfStudent) {
        this.typeOfStudent = typeOfStudent;
    }

    public List<String> getTypeOfStudentOptions() {
        return typeOfStudentOptions;
    }

    public List<String> getAidsOptions() {
        return aidsOptions;
    }

    public List<String> getAids() {
        return aids;
    }

    public void setAids(List<String> aids) {
        this.aids = aids;
    }
}
