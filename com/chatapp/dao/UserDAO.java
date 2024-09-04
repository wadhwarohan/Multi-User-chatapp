package com.chatapp.dao;
import com.chatapp.dto.UserDTO;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chatapp.utils.Encryption;
public class UserDAO {
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException
	{
		Connection con=null;
		PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    final String SQL="select userid from users where userid=? and password=? ";
	    try {
	    con=CommonDao.createConnection();
	    pstmt=con.prepareStatement(SQL);
	    
	    pstmt.setString(1, userDTO.getUserid());
	    String encryptedpwd=Encryption.passwordEncrypt(new String(userDTO.getPassword()));
    pstmt.setString(2, encryptedpwd);
	    rs=pstmt.executeQuery();
	    return rs.next();
	    /*if(rs.next()) {
	    	return true;
	    }
	    else 
	    	return false;*/
	    }
	    finally
	    {
	    	if(rs!=null)
	    		rs.close();
	    	if(pstmt!=null)
	    		pstmt.close();
	    	if(con!=null)
	    		con.close();
	    		
	    }
	}
public int add(UserDTO userDTO) throws SQLException, ClassNotFoundException, Exception {
	System.out.println("Rec"+userDTO.getUserid()+""+userDTO.getPassword());
	Connection connection=null;
	Statement stmt=null;
	try {//try is used if error occur in these lines then also connection and statement will close
	connection=CommonDao.createConnection();
	stmt=connection.createStatement();
	int record=stmt.executeUpdate("insert into users (userid,password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"')");
	return record;
	}
	finally
	{
	if(stmt!=null)
	stmt.close();
	if(connection!=null)
	connection.close();
	}
}
}
