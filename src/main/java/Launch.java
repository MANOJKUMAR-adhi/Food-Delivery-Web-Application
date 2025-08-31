import java.util.List;
import java.util.Scanner;

import com.p.DAO.UserDAO;
import com.p.DAOImpl.UserDAOimpl;
import com.p.models.User;

public class Launch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	
 	

//		System.out.println("Enter the Name"); 
//		String name=sc.next();
//		System.out.println("Enter the Username"); 
//		String username=sc.next();
//		System.out.println("Enter the password");
//		String password=sc.next();
//		System.out.println("Enter the email");
//		String email=sc.next();
//		System.out.println("Enter the Phone Number");
//		String phoneNumber=sc.next();
//		System.out.println("Enter the Address");
//		String address=sc.next();
//		System.out.println("Enter the Role"); String role=sc.next();
//	
		//System.out.println("Enter the Id");
	  	//int id=sc.nextInt();
	 	User u=new User();
	  	//User u=new User(id, name, username, password, email, phoneNumber, address, role, null, null);
		//User u=new User(name, username, password, email, phoneNumber, address, role,null,null);
		UserDAO oimpl= new UserDAOimpl();
	  List<User> alluser=oimpl.getAllUsers();
	  for(User user: alluser) {
		  System.out.println(user);
	  }
//		oimpl.addUser(u);
//		
				//oimpl.updateUser(u);
			//oimpl.deleteUser(id);
//				User user =oimpl.getUser(id);
//		System.out.println(user);
		
		
		
//		System.out.println("Enter the Name"); 
//		String name=sc.next();
//		System.out.println("Enter the Address");
//		String address=sc.next();		
//		System.out.println("Enter the Phone Number");
//		String phoneNumber=sc.next();
//		System.out.println("Enter the Rating");
//		String rating=sc.next();
//		System.out.println("Enter the Active Status");
//		boolean isActive=sc.nextBoolean();
//		System.out.println("Enter the user Id");
//		int id=sc.nextInt();
//		System.out.println("Enter the cusineType ");
//		String cusineType=sc.next();
//		System.out.println("Enter the imagePath ");
//		String imagePath=sc.next();
//		add restaurant
//		Restaurant r= new Restaurant(name, address, phoneNumber, rating, isActive, id,cusineType,imagePath);
//		RestaurantDAO impl=new RestaurantDAOimpl();
//		impl.addRestaurant(r);
//		Update restaurant
//		System.out.println("Enter the restaurant Id");
//		int rid=sc.nextInt();	
//		Restaurant r= new Restaurant(rid,name, address, phoneNumber, rating, isActive, id,cusineType,imagePath);
//		RestaurantDAO impl=new RestaurantDAOimpl();
//		impl.updateRestaurant(r);
		
		//delete restaurant
//		Restaurant r=new Restaurant();
//		RestaurantDAO impl=new RestaurantDAOimpl();
//		impl.deleteRestaurant(rid);
		
	//getRestaurant    ------------------------------------------
		
//		RestaurantDAOimpl restimpl = new RestaurantDAOimpl();
//		Restaurant restaurant = restimpl.getRestaurant(rid);
//		System.out.println(restaurant);
		
//all Restaurant
//		Restaurant r=new Restaurant();
//		RestaurantDAO impl=new RestaurantDAOimpl();	
//		List<Restaurant> alluser=impl.getAllRestaurant();
//		for(Restaurant res: alluser) {
//		  System.out.println(res);
	  }
//		
		
		
	}