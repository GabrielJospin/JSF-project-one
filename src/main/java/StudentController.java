import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class StudentController {

    private List<Student> students;
    private StudentDBUtil studentDBUtil;
    private Logger logger = Logger.getLogger(getClass().getName());
    private String theSearchName;

    public StudentController(){
        students = new ArrayList<Student>();
        studentDBUtil = new StudentDBUtil();
    }

    public List<Student> getStudents(){
        return students;
    }

    public String getTheSearchName() {
        return theSearchName;
    }

    public void setTheSearchName(String theSearchName) {
        this.theSearchName = theSearchName;
    }

    public void loadStudents(){
        logger.info("Loading Students");
        students.clear();

        try {

            if(theSearchName != null && theSearchName.trim().length()>0)
                students = studentDBUtil.searchStudents(theSearchName);
            else
                students = studentDBUtil.getStudents();
        }catch (Exception e){
            logger.log(Level.SEVERE, "error Loading students", e);
            addErrorMessage(e);
        }finally {
            theSearchName = null;
        }
    }

    private void addErrorMessage(Exception e) {
        FacesMessage message = new FacesMessage("Error" + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    public String addStudent(Student student){
        logger.info("adding student:" + student);

        try {
            studentDBUtil.addStudent(student);
        }catch (Exception e){
            logger.log(Level.SEVERE, "Error adding students", e);
            addErrorMessage(e);
            return null;
        }
        return "studentList";
    }

    public String loadStudent(int id){

        try{
            logger.info("loading student: "+ id);
            Student theStudent = studentDBUtil.getStudent(id);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Map<String,Object> requestMap = externalContext.getRequestMap();

            requestMap.put("student",theStudent);

        }catch (Exception e){
            logger.log(Level.SEVERE, "Error loading student id: "+id, e);
            addErrorMessage(e);

            return null;
        }

        return "updateStudent.xhtml";

    }

    public String updateStudent(Student student){

        logger.info("updating student: "+student);

        try{
            studentDBUtil.updateStudent(student);
        }catch (Exception e){
            logger.log(Level.SEVERE,"Error updating student: "+student,e);
            addErrorMessage(e);
            return  null;
        }

        return "studentList";
    }

    public String deleteStudent(int id){
        logger.info("deleting student: "+id);

        try{
            studentDBUtil.deleteStudent(id);
        }catch (Exception e) {
            logger.log(Level.SEVERE, "Error deleting student: " + id, e);
            addErrorMessage(e);
            return null;
        }

        return "studentList";
    }

}
