package com.chatapp.views;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.chatapp.network.Client;
import com.chatapp.utils.UserInfo;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
private Client client;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//					try {
//						ClientChatScreen frame = new ClientChatScreen();
//						frame.setVisible(true);
//					} catch (UnknownHostException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//	}
private void sendit() {
	String message=textField.getText();
	
	try {
		client.sendMessage(UserInfo.USER_NAME+":"+message);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea = new JTextArea();
		client =new Client(textArea);
		setTitle("Chit Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 764, 323);
		contentPane.add(scrollPane);
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(10, 24, 713, 280);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(10, 340, 609, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendit = new JButton("Send Message");
		sendit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendit();
			}
		});
		sendit.setFont(new Font("Tahoma", Font.BOLD, 14));
		sendit.setBounds(629, 340, 144, 46);
		contentPane.add(sendit);
		setVisible(true);
		
	}
}
