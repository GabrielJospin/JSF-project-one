
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String courseCode;
    private int age;
    private String cep;

    public Student() {

    }

    public Student(int id,String firstName, String lastName, String courseCode, int age, String cep){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseCode = courseCode;
        this.age = age;
        this.cep = cep;
    }

    public void validateTheCourseCode(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        if(value == null) return;

        String data = value.toString();
        if(!data.startsWith("ACH") || data.length() != 7){

            FacesMessage message = new FacesMessage("Curse must be an code like ACH****");
            context.addMessage(component.getClientId(context), message);
            throw new ValidatorException(message);
        }

    }
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString(){
        return "Student [firstName = "+firstName+", lastName = "+lastName+", courseCode="+courseCode
                +", age = "+age+", cep = "+cep+"]";
    }

}
