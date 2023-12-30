package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static Connection dbConn() throws ClassNotFoundException, SQLException {
		
		//Register the driver 
		Class.forName(DbConstantPool.DRIVER_CLASS);
		//connection with the dB 
		Connection con=DriverManager.getConnection(DbConstantPool.DB_URL,DbConstantPool.USERNAME,DbConstantPool.PASSWORD);
		return con;
	}

}
