
package OurConnection;
import java.sql.Connection;
import java.sql.DriverManager;

public class getconnect {
    static public Connection Getconnect()
    {    Connection con=null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecosort_Challenges","root","root");
//        System.out.println("Driverload");
//        System.out.println("Connection stabilish");
}
    catch(Exception e)
    {
        System.out.println(e);
    }
  return con;
}
}