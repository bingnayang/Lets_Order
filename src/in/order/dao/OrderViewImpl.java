package in.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.order.entity.MenuInfo;
import in.order.entity.OrderDetail;
import in.order.util.DBConnectionUtil;

public class OrderViewImpl implements OrderViewDAO {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public List<OrderDetail> getActiveOrder() {
//		SELECT *
//		FROM orders INNER JOIN ticketOrder
//		WHERE ticketOrder.order_Id = orders.order_Id
		List<OrderDetail> orderList = null;
		OrderDetail orderDetail = null;
		String sql = "SELECT orders.order_Id,ticketOrder.ticket_Id,orders.itemName,orders.itemPrice, ticketOrder.orderTotal,ticketOrder.orderItemQuantity " + 
				"FROM orders INNER JOIN ticketOrder " + 
				"WHERE ticketOrder.order_Id = orders.order_Id";
		try {
			orderList = new ArrayList<OrderDetail>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			
			// Process the resultSet
			while(resultSet.next()) {
				orderDetail = new OrderDetail();
				orderDetail.setTicket_Id(resultSet.getInt("ticket_Id"));
				orderDetail.setOrder_Id(resultSet.getInt("order_Id"));
				orderDetail.setItemName(resultSet.getString("itemName"));
				orderDetail.setItemPrice(resultSet.getDouble("itemPrice"));
				orderDetail.setOrderQuantity(resultSet.getInt("orderItemQuantity"));
				orderDetail.setOrderTotal(resultSet.getDouble("orderTotal"));
				
				// Add book to list
				orderList.add(orderDetail);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return orderList;
	}

}
