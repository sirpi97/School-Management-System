package schoolManagement;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class School 
{
	private static final String Id = null;
	String NumOfStudent;
	//String ClassTeacherName;
	String SchoolName,PrincipleName;
	int NumOfTeacher,ch;
	String courses;
	String events;
	//Double fees;
	//Double salary;
	String Sname,FirstName,LastName;
	String Gender;
	String Course;
	int age,id;
	Scanner sc=new Scanner(System.in);
	
	void get()
	{
		System.out.println("***************************************SCHOOL MANAGEMENT SYSTEM***********************");
		System.out.println("Enter the School Name: ");
		String SchoolName=sc.next();
		System.out.println("PRINCIPLE NAME:");
		String PrincipleName=sc.next();
		System.out.println("**********Faculties Members:**************");
		System.out.println("MAHENDRAN - M.TECH(COMPUTER SCIENCE)");
		System.out.println("VIJI - P.hd(ZOOLOGY) " );
		System.out.println("GOPI - M.Sc,B.Ed(PHYSICS)");
		System.out.println("Enter the Number of Students in the school: ");
		int NumOfStudent =sc.nextInt();
		System.out.println("Enter the Number of Teachers In the  School: ");
		int NumOfTeacher=sc.nextInt();
		
		System.out.println();
		System.out.println("****************Offered Courses are:*************** ");
		System.out.println("1.Maths_biology");
		System.out.println("2.computer science");
		System.out.println("3.Science group");
		System.out.println("4.Accounts");
		System.out.println("5.English");
		System.out.println("Enter your choice:");
		//System.out.println("Conducting events are: ");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("1.Maths_biology");
			System.out.println("The fees Rs.2000 only");
			break;
		case 2:
			System.out.println("2.computer science");
			System.out.println("The fees Rs.10000 only");

			break;
		case 3:
			System.out.println("3.Science group");
			System.out.println("The fees Rs.3000 only");

			break;
		case 4:
			System.out.println("4.Accounts");
			System.out.println("The fees Rs.4000 only");

			break;
		case 5:
			System.out.println("5.English");
			System.out.println("The fees Rs.5000 only");

			break;
			default:
				System.out.println("invalid");
			
			
			
			
		}
		System.out.println();
		{
		System.out.println("great!");
		System.out.println("Thank you for selecting this course");
	}
		
		System.out.println("************Conducting events are:***************");
		System.out.println("1.Dancing");
		System.out.println("2.Volley Ball");
		System.out.println("3.Shuttle");
		System.out.println("4.Football");
		System.out.println("Enter your choice:");
		int ch1=sc.nextInt();
		switch(ch1)
		{
		case 1:
			System.out.println("1.Dancing");
			break;
		case 2:
			System.out.println("1.volley ball");
			break;
		case 3:
			System.out.println("3.shuttle");
			break;
		case 4:
			System.out.println("4.football");
			break;
			default:
				System.out.println("Invalid");
			
		}
		System.out.println();
	
	
	System.out.println("*********APPLICATION FORM****************");
	System.out.println("Enter the student name:");
	Sname=sc.next();
	System.out.println("Enter the student gender:");
    Gender=sc.next();
	System.out.println("Enter the course name:");
    Course=sc.next();
	System.out.println("Enter the age:");
    age=sc.nextInt();
	
	}
	
	void put()
	{
		//System.out.println("APPLICATION FORM");
		System.out.println("StudentName="+Sname);
		System.out.println("Gender="+Gender);
		System.out.println("Enter the course name="+Course);
		System.out.println("Student age="+age);
		System.out.println("YOUR APPLICATION WILL BE RECEIVED");


		
	}
	void createDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
		PreparedStatement ps=con.prepareStatement("Create Database school ");
		int i=ps.executeUpdate();
		System.out.println(i+"Database Created Successfully");
	}
	void useDB() throws ClassNotFoundException, SQLException
	{
		String sql;
		System.out.println("Connecting to a selected database....");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
		System.out.println("Connected Database successfully");
		java.sql.Statement ps=con.createStatement();
		{
			sql="CREATE TABLE SCHOOL" +"(Id INTEGER not NULL,"+"FirstName VARCHAR(255),"+"LastName VARCHAR(255),"+"Age INTEGER(20))";
		}
		 ps.executeUpdate(sql);
		System.out.println("Created table in given database");
		
	}
	void InsertRecord()throws ClassNotFoundException
	{
		try
		{
			System.out.println("you want insert  your database:");
			System.out.println("1.YES");
			
			int ch2=sc.nextInt();
			switch(ch2)
			{
			case 1:
				System.out.println("1.YES");
				break;
				
			}
			System.out.println("Enter Your SID:");
			id=sc.nextInt();
			System.out.println("Enter your FirstName:");
			FirstName=sc.next();
			System.out.println("Enter your LastName:");
			LastName=sc.next();
			System.out.println("Enter your age:");
			age=sc.nextInt();
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			PreparedStatement ps=con.prepareStatement("insert into SCHOOL values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, FirstName);
			ps.setString(3, LastName);
			ps.setInt(4, age);
			int i=ps.executeUpdate();
			System.out.println(i+" Record inserted");
			con.close();
			}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	void RetriveRecord() throws SQLException
	 {
		try
		{
			System.out.println("you want retrive your database:");
			System.out.println("1.YES");
			
			int ch3=sc.nextInt();
			switch(ch3)
			{
			case 1:
				System.out.println("1.YES");
				break;
				}


			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			PreparedStatement ps=con.prepareStatement("Select * from SCHOOL");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}	
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	 }
	
			

	
	void UpdateRecord()throws ClassNotFoundException
	{
		try
		{
			System.out.println("you want Update your database:");
			System.out.println("1.YES");
			
			int ch3=sc.nextInt();
			switch(ch3)
			{
			case 1:
				System.out.println("1.YES");
				break;
				}

			System.out.println("Enter the id");
			id=sc.nextInt();
			System.out.println("Enter the FirstName");
			FirstName=sc.next();
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			PreparedStatement ps=con.prepareStatement("UPDATE SCHOOL SET FirstName=? where Id=?");
			ps.setString(1, FirstName);
			ps.setInt(2, id);
			int i=ps.executeUpdate();
			System.out.println(i+" Record updated");
			con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	void DeleteRecord()throws SQLException
	{
		try
		{
			System.out.println("Enter the LastName");
			LastName=sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			PreparedStatement ps=con.prepareStatement("delete from SCHOOL where LastName=?");
			ps.setString(1, LastName);
			int i=ps.executeUpdate();
			System.out.println(i+" Record deleted");
			con.close();	
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
 


 
	
	

	public static void main(String[] args) throws SQLException, ClassNotFoundException  
	{
		School s=new School();
		
		s.get();
		s.put();
		//s.createDB();
		//s.useDB();
		s.InsertRecord();
		s.RetriveRecord();
		
		s.UpdateRecord();
		s.DeleteRecord();
		

	}

}
