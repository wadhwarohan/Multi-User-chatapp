package com.chatapp.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.chatapp.dao.UserDAO;
import com.chatapp.dto.UserDTO;
import com.chatapp.utils.UserInfo;

public class UserScreen extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	public static void main(String[] args) {
		UserScreen window=new UserScreen();
		
	}
	UserDAO userDAO=new UserDAO();
	private void doLogin()
	{
		String userid=textField.getText();
		char []password=passwordField.getPassword();
		System.out.println("Userid:"+userid+"Password:"+password);
		
		UserDTO userDTO=new UserDTO(userid,password);	
        try {
        	String message="";
			if(userDAO.isLogin(userDTO)) {
				message="Welcome "+userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this,message);
				setVisible(false);
				dispose();
				Dashboard dashboard =new Dashboard(message);
				dashboard.setVisible(true);
				
			}
			else {
				message="Invalid userid or password";
				JOptionPane.showMessageDialog(this,message);
			}
				//JOptionPane.showMessageDialog(this,message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void register() {
		String userid=textField.getText();
		char []password=passwordField.getPassword();
		System.out.println("Userid:"+userid+  "Password:"+password);
		//UserDAO userDAO=new UserDAO();
		UserDTO userDTO=new UserDTO(userid,password);
		try {
		int result=userDAO.add(userDTO);
		if(result>0)
		{
			JOptionPane.showMessageDialog(this,"Register Successfully");
			//System.out.println("Record Added");
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Register Failed");
			//System.out.println("Record not added");
		}
		}
		catch(Exception ex)
		{
			System.out.println("Some generic Exception");
			ex.printStackTrace();
		}

		System.out.println("userid "+userid+"Password "+password+" "+password.toString());
	}

	public UserScreen() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		setResizable(false);
		setTitle("LOGIN");
		setSize( 567, 339);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(32, 20, 469, 33);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(230, 64, 212, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel UserIdlbl = new JLabel("UserId");
		UserIdlbl.setBounds(132, 62, 88, 33);
		UserIdlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		getContentPane().add(UserIdlbl);
		
		JLabel passwordlbl = new JLabel("Password");
		passwordlbl.setBounds(132, 123, 88, 33);
		passwordlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		getContentPane().add(passwordlbl);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			doLogin();
			}
		});
		login.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		login.setBounds(230, 196, 89, 23);
		getContentPane().add(login);
		
		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				register();
			}
			});
		Register.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Register.setBounds(353, 196, 89, 23);
		getContentPane().add(Register);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 123, 212, 33);
		getContentPane().add(passwordField);
	    setVisible(true);
	
	}
}
