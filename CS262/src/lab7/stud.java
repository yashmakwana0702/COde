package lab7;
import java.sql.*;
import java.util.*;
public class stud extends MySQL{
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		Statement sta=stat();
		int x=1;
		while(x!=0) {
			System.out.println("1--> enter to see student table in database  ");
			System.out.println("2--> enter to see Department table in database  ");
			System.out.println("3--> enter to see branch table in database  ");
			System.out.println("4--> enter to see course table in database  ");
			System.out.println("5--> enter to see branch-course table in database  ");
			System.out.println("6--> enter to see enroll table in database  ");
			System.out.println("7--> enter to insert data into  student table in database  ");
			System.out.println("8--> enter to to enroll student in courses");
			System.out.println("9--> enter to insert branch or department or course");
			System.out.println("10--> enter to see view or lists");
			System.out.println("0--> to exit the program  ");
			x= sc.nextInt();
			switch(x){
			case 7: insertstud(sta);
			case 1: displaystudent(sta);
					break;
			case 2:
				displaydepartment(sta);
				break;
			case 3:
				displayBranch(sta);
				break;
			case 4:
				displaycourse(sta);
				break;
			case 5:
				displayBC(sta);
				break;
			case 8:insertenrol(sta);
			case 6:
				displayenroll(sta);
				break;
			case 9:
				insert(sta);
				break;
			case 10:
				display(sta);
				break;
			default :
				System.out.println("the code is finish");
				x=0;
				break;
			}
		}
	}
	static void insertstud(Statement sta) throws SQLException {
			System.out.println();
			System.out.println("the name of student  is :" );
			String na=sc.next();
			System.out.println();
			System.out.println("the roll no  for student  is :" );
			int ro =sc.nextInt();
			System.out.println("The gender of student is " );
			String gen = sc.next();
			System.out.println("The date of birth of student is in dd-mm-yyyy format " );
			String dOB = sc.next();
			System.out.println("The Date of joining of student is  in dd-mm-yyyy format" );
			String DoA=sc.next();
			System.out.println("The Branch code of student is " );
			int bno= sc.nextInt();
		String sin=" INSERT INTO student VALUES ("+ro+", '"+na+"',STR_TO_DATE('"+dOB+"', '%d-%m-%Y'),'"+gen+"',STR_TO_DATE('"+DoA+"', '%d-%m-%Y'), "+bno+")";
		boolean rset = sta.execute(sin);
		System.out.println(rset);
	}
	static void insertenrol(Statement sta) throws SQLException {
		try(Scanner sc=new Scanner(System.in)){
		System.out.println();
		System.out.println("the roll no  for student  is :" );
		int ro =sc.nextInt();
		System.out.println("The course code of course is " );
		int co=sc.nextInt();
		System.out.println("enter the semester ");
		String gen = sc.next();
		System.out.println("The GRADE of student is " );
		String GRA= sc.next();
		String sin=" INSERT INTO enrolls  VALUES ("+ro+"," +co+", '"+gen+ "', '"+GRA+"') ";
		boolean rset = sta.execute(sin);
		System.out.println(rset);
		displayenroll(sta);
		}
		}
	static void display(Statement sta) throws SQLException {
		System.out.println("1--> List details of Departments that offer more than 3 branches.\n"
				+ "2--> List the details of Departments that offer more than 6 courses.\n"
				+ "3--> List the details of courses that are common for more than 3 branches.\n"
				+ "4--> List students who got ‘S’ in more than 2 courses during single enrollment.\n");
		int x= sc.nextInt();
		switch(x) {
		case 1:
			String s1="SELECT * FROM DEPARTMENT D WHERE D.DNO IN (SELECT B.DNO FROM BRANCH B GROUP BY B.DNO HAVING COUNT(B.DNO) > 3)";
			ResultSet rset1 = sta.executeQuery(s1);
	        System.out.println("The records selected are:");
	        System.out.format("%5s%20s\n","Department no","Name " );
	        while(rset1.next()) {   
	        	int Rol = rset1.getInt("DNO");
	        	String name = rset1.getString("dname");
	        	System.out.format("%5d%20s\n",Rol,name);
	        }
	        System.out.println();
			break;
		case 2:
			String s2="SELECT * FROM DEPARTMENT D WHERE D.DNO IN (SELECT C.DNO FROM COURSE C GROUP BY C.DNO HAVING COUNT(C.CCODE) > 6);";
			ResultSet rset2 = sta.executeQuery(s2);
	        System.out.println("The records selected are:");
	        System.out.format("%5s%20s\n","Department no","Name " );
	        while(rset2.next()) {   
	        	int Rol = rset2.getInt("DNO");
	        	String name = rset2.getString("dname");
	        	System.out.format("%5d%20s\n",Rol,name);
	        }
	        System.out.println();
			break;
		case 3:
			String s3="SELECT * FROM COURSE C WHERE C.CCODE IN (SELECT B.CCODE FROM BRANCH_COURSE B GROUP BY B.CCODE HAVING COUNT(B.BCODE) > 3)";
			ResultSet rset3 = sta.executeQuery(s3);
	        System.out.println("The records selected are:");	      
	        System.out.format("%10s%20s%10s%5s\n","branch no","Name ","Credit "," Department no" );
	        while(rset3.next()) {   
	        	int Rol = rset3.getInt("CCODE");
	        	String name = rset3.getString("cname");
	        	int credit=rset3.getInt("Credits");
	        	int dno=rset3.getInt("DNO");
	        	System.out.format("%10d%20s%8d%5d\n",Rol,name,credit,dno);
	        }
	        System.out.println();
			break;
		case 4:
			String s4="SELECT * FROM STUDENT S WHERE S.ROLLNO IN (SELECT E.ROLLNO FROM ENROLLS E WHERE E.GRADE = 'S' GROUP BY E.ROLLNO HAVING COUNT(E.GRADE) > 2)";
			ResultSet rset4 = sta.executeQuery(s4);
	        System.out.println("The records selected are:");	        
	        System.out.format("%5s%20s%5s%20s%20s%10s\n","Roll no","Name ","gender","date of birth","date of join","bno" );
	        while(rset4.next()) {   
	       	int Rol = rset4.getInt("ROLLNO");
	           String name = rset4.getString("name");
	           String dob = rset4.getString("DOB");
	           String gen = rset4.getString("gender");
	           String date = rset4.getString("DOA");
	           int bno = rset4.getInt("bcode");
	           System.out.format("%5d%20s%5s%20s%20s%10d\n",Rol,name,gen,dob,date,bno );	       
	        }
	        System.out.println();
			break;
		default :
			System.out.println("invalid input");
			break;
		}
	}
}
