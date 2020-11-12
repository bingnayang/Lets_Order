package in.order.dao;

import java.util.List;

import in.order.entity.OrderItem;
import in.order.entity.Ticket;

public interface OrderViewDAO {

	List<Ticket> getActiveOrder();

	boolean submitOrder(Ticket ticket, String[] itemNameArray, String[] itemPriceArray);

	List<OrderItem> getActiveOrderItem();

}
