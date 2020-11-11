package in.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.order.entity.MenuInfo;
import in.order.entity.OrderInfo;
import in.order.util.DBConnectionUtil;

public class OrderViewImpl implements OrderViewDAO {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public List<OrderInfo> getActiveOrder() {

		List<OrderInfo> orderList = null;
		OrderInfo orderDetail = null;
		String sql = "SELECT orderItems.order_Id,orderTickets.ticket_Id,orderItems.itemName,orderItems.itemPrice, orderTickets.orderTotal,orderTickets.orderItemQuantity " + 
				"FROM orderItems INNER JOIN orderTickets " + 
				"WHERE orderTickets.order_Id = orderItems.order_Id";
		try {
			orderList = new ArrayList<OrderInfo>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			
			// Process the resultSet
			while(resultSet.next()) {
				orderDetail = new OrderInfo();
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
