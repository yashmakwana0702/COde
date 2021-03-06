package lab7;
import java.sql.*;
import java.util.Scanner;
public class MySQL {
	public static Scanner sc=new Scanner(System.in);
	  static Statement stat() {
	      try {
	    		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stud?allowMultiQueries=true","root", "2648");
	    		  Statement stmt = conn.createStatement();
	    		  System.out.println(stmt);
	    		  return stmt;  
	    		  }
	       catch(SQLException ex) {
	         ex.printStackTrace();
	         return null; 
	      }
	   }
	static void displaystudent(Statement stmt) throws SQLException{
        // Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
        String strSelect = "select * from student";
        System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
        ResultSet rset = stmt.executeQuery(strSelect);
        // Step 4: Process the ResultSet by scrolling the cursor forward via next().
        //  For each row, retrieve the contents of the cells with getXxx(columnName).
        System.out.println("The records selected are:");
        int rowCount = 0;
        System.out.format("%5s%20s%5s%20s%20s%10s\n","Roll no","Name ","gender","date of birth","date of join","bno" );
        while(rset.next()) {   
       	int Rol = rset.getInt("ROLLNO");
           String name = rset.getString("name");
           String dob = rset.getString("DOB");
           String gen = rset.getString("gender");
           String date = rset.getString("DOA");
           int bno = rset.getInt("bcode");
           System.out.format("%5d%20s%5s%20s%20s%10d\n",Rol,name,gen,dob,date,bno );
           ++rowCount;
        }
        System.out.println("Total number of records = " + rowCount);
        System.out.println();
     } 
	static void displaydepartment(Statement stmt) throws SQLException{
        String strSelect = "select * from stud.department";
        System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are:");
        int rowCount = 0;
        System.out.format("%5s%20s\n","Department no","Name " );
        while(rset.next()) {   
        	int Rol = rset.getInt("DNO");
        	String name = rset.getString("dname");
        	System.out.format("%5d%20s\n",Rol,name);
        	rowCount++;
        }
        System.out.println("Total number of records = " + rowCount);
        System.out.println();
     } 
	static void displayBranch(Statement stmt) throws SQLException{
         String strSelect = "select * from stud.branch";
         System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
         ResultSet rset = stmt.executeQuery(strSelect);
         System.out.println("The records selected are:");
         int rowCount = 0;
         System.out.format("%10s%20s%5s\n","branch no","Name ","Department no" );
         while(rset.next()) {   
         	int Rol = rset.getInt("bcode");
         	String name = rset.getString("Bname");
         	int dno=rset.getInt("DNO");
         	System.out.format("%10d%20s%5d\n",Rol,name,dno);
         	rowCount++;
         }
         System.out.println("Total number of records = " + rowCount);
         System.out.println();
      } 
	static void displaycourse(Statement stmt) throws SQLException{
        String strSelect = "select * from stud.course";
        System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are:");
        int rowCount = 0;
        System.out.format("%10s%20s%10s%5s\n","branch no","Name ","Credit "," Department no" );
        while(rset.next()) {   
        	int Rol = rset.getInt("CCODE");
        	String name = rset.getString("cname");
        	int credit=rset.getInt("Credits");
        	int dno=rset.getInt("DNO");
        	System.out.format("%10d%20s%8d%5d\n",Rol,name,credit,dno);
        	rowCount++;
        }
        System.out.println("Total number of records = " + rowCount);
        System.out.println();
     }
	static void displayenroll(Statement stmt) throws SQLException{
        String strSelect = "select * from stud.enrolls";
        System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are:");
        int rowCount = 0;
        System.out.format("%10s%10s%15s%5s\n","Roll no","C_Code ","Session "," Grade" );
        while(rset.next()) {   
        	int Rol = rset.getInt("ROLLNO");
        	String name = rset.getString("SESS");
        	int credit=rset.getInt("CCODE");
        	String grade=rset.getString("GRADE");
        	System.out.format("%10d%10d%15s%5s\n",Rol,credit,name,grade);
        	rowCount++;
        }
        System.out.println("Total number of records = " + rowCount);
        System.out.println();
     }
	static void displayBC(Statement stmt) throws SQLException{
        String strSelect = "select * from stud.branch_course";
        System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are:");
        int rowCount = 0;
        System.out.format("%10s%10s%20s\n","branch no","course no","Semester " );
        while(rset.next()) {   
        	int Rol = rset.getInt("BCODE");
        	int col = rset.getInt("CCODE");
        	String name = rset.getString("SEMESTER");
        	System.out.format("%10d%10d%20s\n",Rol,col,name);
        	rowCount++;
        }
        System.out.println("Total number of records = " + rowCount);
        System.out.println();
     } 
}