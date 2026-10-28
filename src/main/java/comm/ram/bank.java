package comm.ram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bank 
{
	public static void main(String[] args)
	{
		Connection con =null;
		int result;
		try 
		{
			String query="update deposit set AMT=  ? where NAME = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##narayanpadhy","Narayan123");
			System.out.println("class loaded");
			
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 700);
			pstmt.setString(2, "narayan");
			result = pstmt.executeUpdate();
			con.commit();
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			try {
				if(con!=null)
				{
					con.rollback();
					System.out.println("technical error");
				}
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
