import java.util.List;
import java.util.Scanner;

import com.p.DAO.OrdersDAO;
import com.p.DAOImpl.OrdersDAOImpl;
import com.p.models.Orders;

public class OrdersLaunch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the userId");
//		int userId=sc.nextInt();
//		System.out.println("Enter the Restaurant id");
//		int resId=sc.nextInt();
//		System.out.println("Enter the total amount");
//		int totalAmount=sc.nextInt();
//		System.out.println("Enter the Status");
//		String status=sc.next();
//		System.out.println("Enter the Payment Mode");
//		String paymentMode=sc.next();
		
//		System.out.println("Enter the orderitemId");
//		int orderitemId=sc.nextInt();

		// add 
		//Orders o=new Orders(userId, resId, totalAmount, status, paymentMode);
		
		
		//update
//		Orders o=new Orders(orderitemId, userId, resId, null, totalAmount, status, paymentMode);
//		
//		OrdersDAO impl=new OrdersDAOImpl();
//		impl.updateOrders(o);
		
		// delete
//		Orders o=new Orders();
//		OrdersDAO impl=new OrdersDAOImpl();
//		impl.deleteOrders(orderitemId);
//		
		//getOrders
//		OrdersDAO impl=new OrdersDAOImpl();
//		Orders getOrders= impl.getOrders(orderitemId);
//		System.out.println(getOrders);
		
		//getAll Orders
		
		Orders o=new Orders();
		OrdersDAO impl=new OrdersDAOImpl();
		List<Orders> allOrders= impl.getAllOrders();
		for(Orders order: allOrders) {
			System.out.println(order);
		}
		
		
		
		
	}
	
	
}