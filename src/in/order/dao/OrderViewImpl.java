package in.order.dao;

import java.util.List;

import in.order.entity.OrderDetail;

public class OrderViewImpl implements OrderViewDAO {

	@Override
	public List<OrderDetail> getActiveOrder() {
//		SELECT *
//		FROM orders INNER JOIN ticketOrder
//		WHERE ticketOrder.order_Id = orders.order_Id
		
		
		return null;
	}

}
