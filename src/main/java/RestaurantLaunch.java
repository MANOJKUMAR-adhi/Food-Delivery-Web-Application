import java.util.List;

import com.p.DAO.RestaurantDAO;
import com.p.DAOImpl.RestaurantDAOimpl;
import com.p.models.Restaurant;

public class RestaurantLaunch { 
		public static void main(String[] args) {
//			Scanner sc=new Scanner(System.in);	
//			System.out.println("Enter the Name"); 
//			String name=sc.next();
//			System.out.println("Enter the Address");
//			String address=sc.next();		
//			System.out.println("Enter the Phone Number");
//			String phoneNumber=sc.next();
//			System.out.println("Enter the Rating");
//			String rating=sc.next();
//			System.out.println("Enter the Active Status");
//			boolean isActive=sc.nextBoolean();
//			System.out.println("Enter the user Id");
//			int id=sc.nextInt();
//			System.out.println("Enter the cusineType ");
//			String cusineType=sc.next();
//			String eta=sc.next();
//			System.out.println("Enter the imagePath ");
//			String imagePath=sc.next();
//			//add restaurant
//			Restaurant r= new Restaurant(name, address, phoneNumber, rating, isActive, id,cusineType,eta,imagePath);
//			RestaurantDAO impl=new RestaurantDAOimpl();
//			impl.addRestaurant(r);
//			Update restaurant
//			System.out.println("Enter the restaurant Id");
//			int rid=sc.nextInt();	
//			Restaurant r= new Restaurant(rid,name, address, phoneNumber, rating, isActive, id,cusineType,imagePath);
//			RestaurantDAO impl=new RestaurantDAOimpl();
//			impl.updateRestaurant(r);
			
			//delete restaurant
//			Restaurant r=new Restaurant();
//			RestaurantDAO impl=new RestaurantDAOimpl();
//			impl.deleteRestaurant(rid);
			
		//getRestaurant    ------------------------------------------
			
//			RestaurantDAOimpl restimpl = new RestaurantDAOimpl();
//			Restaurant restaurant = restimpl.getRestaurant(rid);
//			System.out.println(restaurant);
			
	//all Restaurant
			Restaurant r=new Restaurant();
			RestaurantDAO impl=new RestaurantDAOimpl();	
			List<Restaurant> alluser=impl.getAllRestaurants();
			for(Restaurant res: alluser) {
			  System.out.println(res);
		  }
		}
}