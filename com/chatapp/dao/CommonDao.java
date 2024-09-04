package com.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.chatapp.utils.configReader.getvalue;
public class CommonDao {
public static Connection createConnection() throws ClassNotFoundException, SQLException
{
	//step -1 loading a driver
	Class.forName(getvalue("DRIVER"));
	//create connection
	final String CONNECTION_STRING=getvalue("CONNECTION_URL");
	final String USER_ID=getvalue("USER_ID");
	final String PASSWORD=getvalue("PASSWORD");
	Connection con=DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
	if(con!=null)
	{
		System.out.println("Connection Created...");
	//con.close();
	}
	return con;
}
public static void main(String[] arg) throws ClassNotFoundException, SQLException
{
	CommonDao commondao= new CommonDao();
	commondao.createConnection();
}
}
