//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//class DataBase
//{  
//	private int a;
//	public DataBase(int a)
//	{
//		this.a = a;	
//	}
//	public void setV()
//	{
//		
//		try{  
//			Class.forName("com.mysql.jdbc.Driver");  
//			  
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/high_score","root","");  
//			  
//			//here data is database name, root is username and password is ""
//			  
//			Statement stmt=con.createStatement();  
//			  
//			stmt.executeUpdate("update highscore set highscore = "+a+" where id = 0");  
//			  
//			/*while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2));  */
//			  
//			con.close();  
//			  
//			}
//		catch(Exception e)
//		{ 
//			System.out.println(e);
//		}  
//			  
//	}
//	
//	public int getV()
//	{
//		 int r = 0; 
//		try{  
//			Class.forName("com.mysql.jdbc.Driver");  
//			  
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/high_score","root","");  
//			  
//			//here data is database name, root is username and password is ""
//			  
//			Statement stmt=con.createStatement();  
//			  
//			ResultSet rs = stmt.executeQuery("Select highscore from highscore");  
//			
//			if(rs.next())
//			{ r = rs.getInt(1); }
//			  
//			con.close();  
//			  
//			}
//		catch(Exception e)
//		{ 
//			System.out.println(e);
//		}  
//		return r; 
//	}
//	
//}
//	