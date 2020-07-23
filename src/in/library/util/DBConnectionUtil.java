package in.library.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBConnectionUtil {
	// Define the database properties
    public static final String DB_NAME = "libraryDB.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Bing/eclipse-workspace/FreeLibrary/"+ DB_NAME;
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
