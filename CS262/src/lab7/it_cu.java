package lab7;
import java.sql.*;
import java.util.*;
public class it_cu extends sql_item {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		Statement smt=smt(); 
		int x=1;
		while(x!=0) {
			System.out.println("1--> enter to see the database  ");
			System.out.println("2--> enter to insert data ");
			System.out.println("3--> enter to to check select lists  ");
			System.out.println("4--> enter to update amount price");
			System.out.println("5--> enter to update amount price manualy");
			System.out.println("0--> to exit the program  ");
			x= sc.nextInt();
			switch(x){
			case 1: display(smt);
					break;
			case 2:
				insert(smt);
				break;
			case 3:
				list(smt);
				break;
			case 4:
				String s1="call cus_it.update()" ;
				boolean rset=smt.execute(s1);
				System.out.println(rset);
				break;
			case 5:
				System.out.println("Enter the order no");
				String on=sc.next();
				System.out.println("enter the amount");
				int amt=sc.nextInt();
				String s5="UPDATE 'cus_it'.'cust_order' SET 'ORD_AMT' = '"+amt+"' WHERE ('ORDERNO' = '"+on+"')";
				boolean rset1=smt.execute(s5);
				System.out.println(rset1);
				break;
			default :
				System.out.println("the code is finish");
				x=0;
				break;
			}
		}
	}
	static void list(Statement smt) throws SQLException {
		System.out.println("1--> List the details of customers who have placed more than 3 orders.\r\n"
				+ "2--> List details of items whose price is less than the average price of all items in each order.\r\n"
				+ "3--> List the orderno and number of items in each order.\r\n"
				+ "4--> List the details of items that are present in 25% of the orders.\n");
		int sa =sc.nextInt();
		switch(sa) {
		case 1:
			String mor3="SELECT * FROM CUSTOMER C WHERE C.CUSTOMERNO IN (SELECT O.CUSTOMERNO FROM CUST_ORDER O GROUP BY O.CUSTOMERNO HAVING COUNT(O.ORDERNO) > 3)";
			ResultSet rset = smt.executeQuery(mor3);
	        System.out.println("The records selected are:\n");
	        System.out.format("%10s%20s\n","Customer No","Name " );
	        while(rset.next()) {   
	        	String Rol = rset.getString("CUSTOMERNO");
	        	String name = rset.getString("cname");
	        	System.out.format("%10s%20s\n",Rol,name);        	
	        }
	        System.out.println();
			break;
		case 2:
			String q2="SELECT * FROM ITEM I WHERE I.UNIT_PRICE < (SELECT AVG(UNIT_PRICE) FROM ITEM)";
			ResultSet rset1 = smt.executeQuery(q2);
	        System.out.println("The records selected are:\n");
	        System.out.format("%10s%20s%5s\n","Item No","Name ","Unit price" );
	        while(rset1.next()) {   
	        	String Rol = rset1.getString("ITEMNO");
	        	String name = rset1.getString("ITEM_NAME");
	        	int rs=rset1.getInt("UNIT_PRICE");
	        	System.out.format("%10s%20s%5d\n",Rol,name,rs);        	
	        }       
	        System.out.println();
			break;
		case 3:
			String q3="SELECT ORDERNO, SUM(QTY) FROM ORDER_ITEM GROUP BY ORDERNO;";
			ResultSet rset3 = smt.executeQuery(q3);
	        System.out.println("The records selected are:\n");
	        System.out.format("%10s%10s\n","Order No","no of items " );
	        while(rset3.next()) {   
	        	String Rol = rset3.getString("ORDERNO");
	        	int name = rset3.getInt("SUM(QTY)");
	        	System.out.format("%10s%10d\n",Rol,name);        	
	        }
	        System.out.println();
			break;
		case 4:
			String q4="SELECT * FROM ITEM WHERE ITEMNO IN (SELECT ITEMNO FROM ORDER_ITEM GROUP BY ITEMNO HAVING COUNT(ITEMNO) >= (SELECT (COUNT(*)/4) FROM CUST_ORDER));";
			ResultSet rset11 = smt.executeQuery(q4);
	        System.out.println("The records selected are:\n");
	        System.out.format("%10s%20s%5s\n","Item No","Name ","Unit price" );
	        while(rset11.next()) {   
	        	String Rol = rset11.getString("ITEMNO");
	        	String name = rset11.getString("ITEM_NAME");
	        	int rs=rset11.getInt("UNIT_PRICE");
	        	System.out.format("%10s%20s%5d\n",Rol,name,rs);        	
	        }       
	        System.out.println();
			break;
		default :
			System.out.println("invalid input");
			break;
		}
	}
	static void display(Statement smt) throws SQLException {
		int x=1;
		while(x!=0) {
			System.out.println("1--> enter to see the customer table  ");
			System.out.println("2--> enter to  see the items table");
			System.out.println("3--> enter to see the customer order table  ");
			System.out.println("4--> enter to see the order item table");
			System.out.println("5--> enter to see view ");
			System.out.println("0--> to exit the program  ");
			x= sc.nextInt();
			switch(x){
			case 1: 
				displaycustomer(smt);
				break;
			case 2:
				displayitem(smt);
				break;
			case 3:
				displayCUS_ORD(smt);
				break;
			case 4:
				displayORD_item(smt);
				break;
			case 5:
				displayview(smt);
				break;
			default :
				System.out.println("invalid input");
				break;
			}
		}
	}

}
