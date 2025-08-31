import java.util.List;
import java.util.Scanner;

import com.p.DAO.OrdersItemDAO;
import com.p.DAOImpl.OrderItemDAOImpl;
import com.p.models.OrdersItem;

public class OrderItemLaunch {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
//	 System.out.println("Enter the ordersId");
//		int orderid=sc.nextInt();
//		System.out.println("Enter the Menu id");
//		int menuId=sc.nextInt();
//		System.out.println("Enter the Quantity");
//		int quantity=sc.nextInt();
//		System.out.println("Enter the Total Prize");
//		int totalPrize=sc.nextInt();
//		System.out.println("Enter the orderItemid");
//		int orderItemid=sc.nextInt();
		
		//add
//		OrdersItem oitem=new OrdersItem(orderid, menuId, quantity, totalPrize);
//		OrdersItemDAO impl=new OrderItemDAOImpl();
//		impl.addOrdersItem(oitem);
		
		
		//update 
//		OrdersItem oitem=new OrdersItem(orderItemid,orderid, menuId, quantity, totalPrize);
//		OrdersItemDAO impl=new OrderItemDAOImpl();
//		impl.updateOrdersItem(oitem);
		
//		//delete
//		OrdersItem oi=new OrdersItem();
//		OrdersItemDAO impl=new OrderItemDAOImpl();
//		impl.deleteOrdersItem(orderItemid);
		
		// getOrderItem
		
//		OrdersItemDAO impl=new OrderItemDAOImpl();
//		OrdersItem get=impl.getOrdersItem(orderItemid);
//		System.out.println(get);
		
		//getAll
		OrdersItem oi=new OrdersItem();
		OrdersItemDAO impl=new OrderItemDAOImpl();
		List<OrdersItem> li=impl.getAllOrderItems();
		for(OrdersItem o:li) {
			System.out.println(o);
		}

}
}