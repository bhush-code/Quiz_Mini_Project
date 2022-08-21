import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Exam {

    public int Give_exam() throws Exception {
        int count = 0;
        int score = 0;

        Connection con = DbConnection.GetConnection();
        PreparedStatement ps = con.prepareStatement("select *from Question_answer order by rand() limit 100");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Question >> " + rs.getString(2));
            System.out.println("A>> " + rs.getString(3));
            System.out.println("B>> " + rs.getString(4));
            System.out.println("C>> " + rs.getString(5));
            System.out.println("D>> " + rs.getString(6));
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter your choice");
            char ch = scanner.next().charAt(0);
            //System.out.println("correct answer "set.getNString(7));
            if (ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D') {
                String str = rs.getString(7);
                char option = str.charAt(0);
                if (option == ch) {
                    score++;
                }
            } else {
                System.out.println("invalid input VALUES MUST BE EITHER OF THESE A,B,C,D");
                System.out.println("Question >> " + rs.getString(2));
                System.out.println("A>> " + rs.getString(3));
                System.out.println("B>> " + rs.getString(4));
                System.out.println("C>> " + rs.getString(5));
                System.out.println("D>> " + rs.getString(6));
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("enter your choice");
                scanner1.next();
            }

        }
        return score;

    }

    public String check_Grade(int score)

    {

        String grade;
        System.out.println("total marks out of 10 you got >>>"+score+"");
        if(score>=4 && score <=5) {
            grade="A";
            System.out.println("Grade "+grade );
            //eturn grade;
        }else if(score>=3 && score<4)
        {
            grade="B";
            System.out.println("Grade "+grade);
        }
        else if(score==2)
        {
            grade="C";
            System.out.println("Grade "+grade);
            //return  grade;

        }
        else
        {
            System.out.println("failed");
            grade= "F";
            System.out.println("Grade "+grade);
            //return grade;

        }

        return  grade;
    }

    public  void UpdateScore(int Student_id, int score, String grade,int attempts) throws Exception
    {

        Connection con = DbConnection.GetConnection();
        if(attempts==0)
        {
            String cmd1="insert  into score_details values (?,?,?,?,?)";
            PreparedStatement stmt1=con.prepareStatement(cmd1);
            stmt1.setInt(1,Student_id);
            stmt1.setInt(2,Student_id+1);
            stmt1.setInt(3,score);
            stmt1.setInt(4,attempts+1);
            stmt1.setString(5,grade);
            stmt1.executeUpdate();

            System.out.println("Successfully added score details");

        }
        else
        {
            String cmd1="update score_details set score=? ,grade =?,attempts=? where student_id=?";
            PreparedStatement stmt1=con.prepareStatement(cmd1);
            stmt1.setInt(1,score);
            stmt1.setString(2,grade);
            stmt1.setInt(3,attempts+1);
            stmt1.setInt(4,Student_id);
            stmt1.executeUpdate();
            System.out.println("Successfully updated score details");

        }

    }

    public int check_attempts(int Student_id) throws  Exception
    {
        int attempts=0;
        Connection con = DbConnection.GetConnection();
       String cmd="select attempts from score_details where Student_id=?";
       PreparedStatement stmt= con.prepareStatement(cmd);
       stmt.setInt(1,Student_id);
        ResultSet rs=stmt.executeQuery();
        if(rs.next())
        {
             attempts=rs.getInt(1);



        }




        return  attempts;

    }

    public  void show_score(int Student_id) throws  Exception
    {
        Connection con = DbConnection.GetConnection();

        String cmd="select A.Name,B.score,B.grade from Login_data A, Score_Details B where A.Student_id=B.Student_id and B.Student_id=? ";
        PreparedStatement stmt=con.prepareStatement(cmd);
        stmt.setInt(1,Student_id);
        ResultSet rs=stmt.executeQuery();
        if(rs.next())
        {

            System.out.println("HI "+rs.getString(1) +" your Score is "+rs.getInt(2)+"  and Grade is "+rs.getString(3));
        }
        else
        {
            System.out.println("Please give exam to genrate the score");
        }


    }




}
