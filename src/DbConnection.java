import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {


    public static Connection GetConnection() throws Exception
    {
     Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "Thar@1997");

    return  con;

    }

}
