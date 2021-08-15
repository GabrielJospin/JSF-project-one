import javax.faces.bean.ManagedBean;

@ManagedBean
public class Style {

    private String cssFile;
    private String namePage;

    public Style() {
        cssFile = "style.css";
    }

    public String getCssFile() {
        return cssFile;
    }

    public void setCssFile(String cssFile) {
        this.cssFile = cssFile;
    }

    public String getNamePage() {
        return namePage;
    }

    public void setNamePage(String namePage) {
        this.namePage = namePage;
    }

    public String start(){
        this.cssFile = namePage+".css";
        return "cssProject";
    }
}
