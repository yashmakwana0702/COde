package lab7;
import java.sql.*;
import java.sql.Date ;
import java.util.*;
public class students extends MySQL{

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
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
			case 6:
				displayenroll(sta);
				break;
			default :
				System.out.println("the code is finish");
				x=0;
				break;
			}
		}
	}
	static void insertstud(Statement sta) throws SQLException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println();
			System.out.println("the name of student  is :" );
			String na=sc.next();
			System.out.println("the roll no  for student  is :" );
			int ro =sc.nextInt();
			System.out.println("The gender of student is " );
			String gen = sc.next();
			System.out.println("The date of birth of student is " );
			Date dOB = Date.valueOf(sc.next());
			System.out.println("The Date of joining of student is " );
			Date DoA=Date.valueOf(sc.next());
			System.out.println("The Branch code of student is " );
			int bno= sc.nextInt();
			
		}
		String sinsert = "INSERT INTO student  VALUES (%d, 'rushi', '2002-01-06', %s, '2019-07-16', %d);",na,bno;
		boolean rset = sta.execute(sinsert);

	}
}
