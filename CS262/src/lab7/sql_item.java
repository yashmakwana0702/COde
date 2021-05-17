package lab7;
import java.sql.*;
import java.util.Scanner;
public class sql_item {
	public static Scanner sc=new Scanner(System.in);
	  static Statement smt() {
	      try {
	    		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cus_it?allowMultiQueries=true","root", "2648");
	    		  Statement stmt = conn.createStatement();
	    		  System.out.println(stmt);
	    		  return stmt;  
	    		  }
	       catch(SQLException ex) {
	         ex.printStackTrace();
	         return null; 
	      }
	   }
	static void displaycustomer(Statement stmt) throws SQLException{
        String strSelect = "select * from customer";
        System.out.println("The SQL statement is: " + strSelect + "\n"); 
        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are:\n");
        System.out.format("%10s%20s\n","Customer No","Name " );
        while(rset.next()) {   
        	String Rol = rset.getString("CUSTOMERNO");
        	String name = rset.getString("cname");
        	System.out.format("%10s%20s\n",Rol,name);        	
        }       
        System.out.println();
     } 
	static void displayitem(Statement stmt) throws SQLException{
        String strSelect = "select * from item";
        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are:\n");
        System.out.format("%10s%20s%5s\n","Item No","Name ","Unit price" );
        while(rset.next()) {   
        	String Rol = rset.getString("ITEMNO");
        	String name = rset.getString("ITEM_NAME");
        	int rs=rset.getInt("UNIT_PRICE");
        	System.out.format("%10s%20s%5d\n",Rol,name,rs);        	
        }       
        System.out.println();
     } 
	static void displayORD_item(Statement stmt) throws SQLException{
        String strSelect = "select * from order_item";
        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are:\n");
        System.out.format("%10s%20s%5s\n","Order No","Item number ","Quantity" );
        while(rset.next()) {   
        	String Rol = rset.getString("ORDERNO");
        	String name = rset.getString("ITEMNO");
        	int rs=rset.getInt("QTY");
        	System.out.format("%10s%20s%5d\n",Rol,name,rs);        	
        }       
        System.out.println();
     }  
	static void displayview(Statement stmt) throws SQLException{
        String strSelect = "select * from customer_details";
        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are:\n");
        System.out.format("%10s%20s%5s\n","Customer No"," Name ","No of Orders" );
        while(rset.next()) {   
        	String Rol = rset.getString("CUSTOMERNO");
        	String name = rset.getString("CNAME");
        	int rs=rset.getInt("ORDER_COUNT");
        	System.out.format("%10s%20s%5d\n",Rol,name,rs);        	
        }       
        System.out.println();
     }
	static void displayCUS_ORD(Statement stmt) throws SQLException{
        String strSelect = "select * from cust_order";
        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are:\n");
        System.out.format("%10s %10s %10s %5s\n","Order_no ","Ord_Date","Customer_No","Order_Amount" );
        while(rset.next()) {   
        	String Rol = rset.getString("CUSTOMERNO");
        	String date = rset.getString("ORDERNO");
        	String cno=rset.getString("ODATE");
        	int rs=rset.getInt("ORD_AMT");
        	System.out.format("%10s %10s %10s %5d\n",date,cno,Rol,rs);        	
        }       
        System.out.println();
     }
	static void insert(Statement sta) throws SQLException {
		System.out.println("1--> enter to insert CUSTOMER");
		System.out.println("2--> enter to insert item");
		System.out.println("3--> enter to insert order");
		int a=sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("enter the Customer no :");
			String dno=sc.next();
			System.out.println("enter the Customer name");
			String dname=sc.nextLine();
			String S1="INSERT INTO 'cus_it'.'customer' ('CUSTOMERNO', 'CNAME') VALUES ('"+dno+"', '"+dname+"')";
			boolean rset = sta.execute(S1);
			System.out.println(rset);
			displaycustomer(sta);
			break;
		case 2:
			System.out.println("enter the Item no :");
			String ino=sc.next();
			System.out.println("enter the Item name :");
			String bno=sc.next();
			System.out.println("enter the price");
			int dno1=sc.nextInt();
			String s1 ="INSERT INTO 'cus_it'.'item' ('ITEMNO', 'ITEM_NAME', 'UNIT_PRICE') VALUES ('"+ino+"', '"+bno+"','"+dno1+"')";
			boolean rset1 = sta.execute(s1);
			System.out.println(rset1);
			displayitem(sta);
			break;
		case 3:
			System.out.println("enter the order no :");
			String ino1=sc.next();
			System.out.println("enter the date :");
			String bno1=sc.next();
			System.out.println("enter the Customer no");
			String dno11=sc.next();
			String addorder="INSERT INTO 'cus_it'.'cust_order' ('ORDERNO', 'ODATE', 'CUSTOMERNO') VALUES ('"+ino1+"',STR_TO_DATE('"+bno1+"','%d-%m-%Y'),'"+dno11+"')";
			boolean rset12=sta.execute(addorder);
			System.out.println(rset12);
			System.out.println("enter the no of different item you want to order:");
			int i=sc.nextInt();
			for(int b=1;b<=i;b++) {
				System.out.println("enter the Item No :");
				String bno11=sc.next();
				System.out.println("enter the number of item");
				int dno12=sc.nextInt();
				String additem="INSERT INTO 'cus_it'.'order_item' ('ORDERNO', 'ITEMNO', 'QTY') VALUES ('"+ino1+"', '"+bno11+"', '"+dno12+"');";
				boolean rset121=sta.execute(additem);
				System.out.println(rset121);
			}
			String s12="call cus_it.update()" ;
			boolean rset1211=sta.execute(s12);
			System.out.println(rset1211);
			displayORD_item(sta);
			displayCUS_ORD(sta);
			break;
		default :
			System.out.println("enter valid input");
			break;
		}
	}
}

