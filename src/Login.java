import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    public int Check_login(int Student_id, String Password) throws  Exception
    {
        int result=0;

        Connection con=DbConnection.GetConnection();
        String cmd="select Student_id,Password from Login_data where student_id=?";
        PreparedStatement stmt=con.prepareStatement(cmd);
        stmt.setInt(1,Student_id);
        ResultSet rs=stmt.executeQuery();

        if(rs.next())
        {
            int id=rs.getInt(1) ;
            String Pass=rs.getString(2);
            System.out.println(id);
            System.out.println(Pass);
            if(id==Student_id && Password.equals(Pass))
            {
                result = 1;
            }
        }
        else
        {
            result=0;
        }

        return result;

    }


}
