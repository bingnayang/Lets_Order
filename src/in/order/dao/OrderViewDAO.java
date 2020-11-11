package in.order.dao;

import java.util.List;

import in.order.entity.OrderInfo;
import in.order.entity.Ticket;

public interface OrderViewDAO {

	List<OrderInfo> getActiveOrder();

	boolean submitOrder(Ticket ticket, String[] itemNameArray, String[] itemPriceArray);

}
