package in.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.order.entity.OrderItem;
import in.order.entity.Ticket;
import in.order.util.DBConnectionUtil;

public class OrderViewImpl implements OrderViewDAO {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public List<Ticket> getActiveOrder() {

		List<Ticket> orderList = null;
		Ticket orderDetail = null;
		String sql = "SELECT * FROM orderTickets";
		try {
			orderList = new ArrayList<Ticket>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			
			// Process the resultSet
			while(resultSet.next()) {
				orderDetail = new Ticket();
				orderDetail.setTicket_Id(resultSet.getInt("ticket_Id"));
				orderDetail.setOrderTotal(resultSet.getDouble("orderTotal"));
				orderDetail.setOrderQuantity(resultSet.getInt("orderItemQuantity"));
				// Add book to list
				orderList.add(orderDetail);
			}
			
		}catch (Exception e) {
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
			// Insert new order to ticket table
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(ticketSQL);
			preparedStatement.executeUpdate();
			System.out.println("SQL: "+ticketSQL);
			// Get the last ticket Id
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(getLastId);
			resultSet = preparedStatement.executeQuery();
			lastID = resultSet.getInt("ticket_Id");
			System.out.println("SQL: "+getLastId);
			System.out.println("Ticket Table last ID: "+lastID);
			// Insert order items and price to order table
			for(int i=0; i<itemNameArray.length; i++) {
				connection = DBConnectionUtil.openConnection();
				preparedStatement = connection.prepareStatement(itemSQL);
				preparedStatement.setInt(1,lastID);
				preparedStatement.setString(2,itemNameArray[i]);
				preparedStatement.setString(3,itemPriceArray[i]);
				preparedStatement.executeUpdate();
				System.out.println("SQL: "+itemSQL);
			}

			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public List<OrderItem> getActiveOrderItem() {
		List<OrderItem> orderItemList = null;
		OrderItem orderItemDetail = null;
		String sql = "SELECT * FROM orderItems";
		try {
			orderItemList = new ArrayList<OrderItem>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			
			// Process the resultSet
			while(resultSet.next()) {
				orderItemDetail = new OrderItem();
				orderItemDetail.setTicket_Id(resultSet.getInt("ticket_Id"));
				orderItemDetail.setName(resultSet.getString("itemName"));
				orderItemDetail.setPrice(resultSet.getDouble("itemPrice"));
				// Add book to list
				orderItemList.add(orderItemDetail);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderItemList;
	}

}
