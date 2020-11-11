package in.order.dao;

import java.util.List;

import in.order.entity.OrderInfo;

public interface OrderViewDAO {

	List<OrderInfo> getActiveOrder();

}
