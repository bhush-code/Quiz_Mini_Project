import org.w3c.dom.css.CSSStyleDeclaration;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        int ans,check,score,attempts;
        String grade=null;
        attempts=0;
        score=0;
        check=0;
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        System.out.println("enter login id");
        int Student_id = sc.nextInt();
        System.out.println("Enter Password");
        String Password = sc.next();
        try {
             check = login.Check_login(Student_id, Password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (check == 1) //login successful

        {
            do {


                System.out.println("1.give exam");
                System.out.println("2.check score ");
                System.out.println("3.exit");
                ans = sc.nextInt();
                switch (ans) {

                    case 1:
                        Exam exam = new Exam();
                        try {
                            attempts= exam.check_attempts(Student_id);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }

                       if(attempts>=0 && attempts <3)
                       {
                           try {
                               System.out.println(" You have "+(3-attempts)+" attempts left");
                               score = exam.Give_exam();
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                           try
                           {
                                grade = exam.check_Grade(score);
                           }
                           catch (Exception e)
                           {
                               e.printStackTrace();
                           }

                           try {
                               exam.UpdateScore(Student_id, score, grade,attempts);

                           }
                           catch (Exception e)
                           {
                               e.printStackTrace();
                           }

                       }
                       else
                       {
                           System.out.println("No attempts left");
                       }
                    break;
                    case 2:
                        Exam exam1=new Exam();
                        try {
                            exam1.show_score(Student_id);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }

                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("Invalid Choice");
                }


            } while (ans != 3);
        }

        else
            {
                System.out.println("Login details are incorrect");
            }


        }
    }

