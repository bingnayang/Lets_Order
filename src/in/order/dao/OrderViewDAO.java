package in.order.dao;

import java.util.List;

import in.order.entity.OrderDetail;

public interface OrderViewDAO {

	List<OrderDetail> getActiveOrder();

}
