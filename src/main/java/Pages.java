import javax.faces.bean.ManagedBean;

@ManagedBean
public class Pages {
    private String namePage;

    public Pages(){

    }

    public String getNamePage() {
        return namePage;
    }

    public void setNamePage(String namePage) {
        this.namePage = namePage;
    }

    public String start(){
        return namePage;
    }
}
