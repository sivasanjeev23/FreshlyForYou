package practice;
import java.sql.SQLException;
import java.util.Scanner;
public class FreshlyForYou {
	public static void main(String[] args){
		try {
			Scanner sc=new Scanner(System.in);
			Freshly f1=new Freshly();
			System.out.println("Enter email");
			String email=sc.nextLine();
			System.out.println("Enter PassWord");
			String password=sc.nextLine();
			String name=f1.login(email, password);
			System.out.println(name!=null?"Welcome "+name+" !!!":"Invalid user");
			if(name!=null) {
				System.out.println("Select Anyone Catagorie Key:");
				System.out.println(f1.fcat());
			}
			int k1=sc.nextInt();
			System.out.println(f1.fprod(k1));
			int k2=sc.nextInt();
			if(f1.forder(name, k2)>0)System.out.println("Order Placed Successfully");
			else System.out.println("Wrong Input");
			sc.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
}
