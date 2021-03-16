
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class Student {

    private String firstName;
    private String lastName;
    private String courseCode;
    private String errors;
    private int age;
    private String cep;

    public Student() {

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


}
