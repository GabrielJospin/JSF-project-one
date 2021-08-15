import java.sql.*;

public class Connect {

    static Connect instance;
    Connection conn;
    Statement st;

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String USER = "root";
    final String PASS = "";
    final String SERVER_URL = "jdbc:mysql://localhost/jsfteste1";

    public static Connect getInstance() throws SQLException, ClassNotFoundException {
        if(instance instanceof Connect){
            return instance;
        }

        return new Connect();
    }

    private Connect() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(SERVER_URL, USER, PASS);
        st = conn.createStatement();
       ;
    }
}
