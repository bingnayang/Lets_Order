package in.order.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
	// Define the database properties
    public static final String DB_NAME = "letsorder.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Bing/eclipse-workspace/Lets_Order/"+ DB_NAME;
    private static Connection connection;
    public static Connection openConnection() {
    	// Check the connection
    	if(connection != null) {
    		return connection;
    	}else {
    		try {
    			// Load the driver
    			Class.forName("org.sqlite.JDBC");
    			// Get the connection
    			connection = DriverManager.getConnection(CONNECTION_STRING);
    		}catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    		// Return connection
    		return connection;
    	}
    }
}
