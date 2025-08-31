import java.util.List;
import java.util.Scanner;

import com.p.DAO.MenuDAO;
import com.p.DAOImpl.MenuDAOImpl;
import com.p.models.Menu;

public class MenuLaunch {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the Restaurant id");
//		int resId=sc.nextInt();
//		System.out.println("Enter the itemname:");
//		String itemname=sc.next();
//		System.out.println("Enter the description:");
//		String description=sc.next();
////		sc.next();
//		System.out.println("Enter the price");
//		int price=sc.nextInt();
//		System.out.println("Enter the ratings:");
//		String ratings=sc.next();
//		System.out.println("Enter the isAvailable:");
//		boolean isAvailable=sc.nextBoolean();
//		System.out.println("Enter the imagePath:");
//		String imagePath=sc.next();
		
//		System.out.println("Enter the Menu id");
//		int mId=sc.nextInt();
		
		//add
//		Menu m=new Menu(resId, itemname, description, price, ratings, isAvailable, imagePath);
//		MenuDAO impl=new MenuDAOImpl();
//		impl.addMenu(m);
		
		//Update
//		Menu m=new Menu(mId,resId, itemname, description, price, ratings, isAvailable, imagePath);
//		MenuDAO impl=new MenuDAOImpl();
//		impl.updateMenu(m);
		
		//delete
//		Menu m=new Menu();
//		MenuDAO impl=new MenuDAOImpl();
//		impl.deleteMenu(mId);
		
		//getMenu
		
//		MenuDAO impl=new MenuDAOImpl();
//		Menu m=impl.getMenu(mId);
//		System.out.println(m);
		
		//getAllMenu
		Menu m=new Menu();
		MenuDAO impl=new MenuDAOImpl();
		List<Menu> li=impl.getAllMenus();
		for(Menu m1:li) {
			System.out.println(m1);
		}
		
		
	}
}