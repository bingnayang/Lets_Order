package in.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.order.entity.MenuInfo;
import in.order.entity.OrderInfo;
import in.order.entity.Ticket;
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

	@Override
	public boolean submitOrder(Ticket ticket, String[] itemNameArray, String[] itemPriceArray) {
		boolean flag = false;
		int lastID = 0;
		
		String ticketSQL ="INSERT INTO orderTickets(orderTotal, orderItemQuantity) VALUES("+ticket.getOrderTotal()+","+ticket.getOrderQuantity()+")";
		String itemSQL ="INSERT INTO orderItems(ticket_Id, itemName, itemPrice) VALUES(?,?,?)";
		String getLastId ="SELECT ticket_Id " + 
				"FROM orderTickets " + 
				"WHERE orderTickets.ticket_Id = (SELECT MAX(orderTickets.ticket_Id)  FROM orderTickets);";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(ticketSQL);
			preparedStatement.executeUpdate();
			System.out.println("SQL: "+ticketSQL);
			
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(getLastId);
			resultSet = preparedStatement.executeQuery();
			lastID = resultSet.getInt("ticket_Id");
			System.out.println("SQL: "+getLastId);
			System.out.println("Ticket Table last ID: "+lastID);
			for(int i=0; i<itemNameArray.length; i++) {
				connection = DBConnectionUtil.openConnection();
				preparedStatement = connection.prepareStatement(itemSQL);
				preparedStatement.setInt(1,lastID);
				preparedStatement.setString(2,itemNameArray[i]);
				preparedStatement.setString(3,itemPriceArray[i]);
				preparedStatement.executeUpdate();
				System.out.println("SQL: "+itemSQL);
			}
//			connection = DBConnectionUtil.openConnection();
//			preparedStatement = connection.prepareStatement(itemSQL);
//			preparedStatement.setInt(1,lastID);
//			preparedStatement.setString(1,itemNameArray[i]);
//			preparedStatement.executeUpdate();
//			System.out.println("SQL: "+itemSQL);

			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

}
