package in.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.order.entity.MenuInfo;
import in.order.util.DBConnectionUtil;

public class MenuDAOImplement implements MenuDAO {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	@Override
	public List<MenuInfo> getMenu() {
		// Create reference variables
		List<MenuInfo> list = null;
		MenuInfo menuInfo = null;
		String sql = "SELECT * FROM menuInfo";
		try {
			list = new ArrayList<MenuInfo>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			// Process the resultSet
			while(resultSet.next()) {
				menuInfo = new MenuInfo();
				menuInfo.setItem_Id(resultSet.getInt("item_Id"));
				menuInfo.setItemName(resultSet.getString("itemName"));
				menuInfo.setItemPrice(resultSet.getDouble("itemPrice"));
				menuInfo.setDescription(resultSet.getString("description"));
				menuInfo.setCategoryType(resultSet.getString("categoryType"));
				// Add book to list
				list.add(menuInfo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
}
