
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class EmoDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("The driver loaded");
		}
		catch(ClassNotFoundException clse)
		{
			clse.printStackTrace();
		}
		try
		{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		System.out.println("Connected ");
		
		//String query="insert into emptable values(1001,'Harsh',77777,'04/05/2006')";
		String query="insert into employee values(1001,'Harsh',77777)";
		Statement stat=con.createStatement();
			
		int nrows=stat.executeUpdate(query);	
		if(nrows>0)
			System.out.println("Record inserted successfully!!!");
		else
			System.out.println("Fail");
			
		
		
		stat.close();
		con.close();
		
		}// eof try
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	}


