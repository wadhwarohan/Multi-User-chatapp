package com.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	public Dashboard(String message) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 513);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu chatapp = new JMenu("chat");
		menuBar.add(chatapp);
		
		JMenuItem startchat = new JMenuItem("startchat");
		startchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					dispose();
					new ClientChatScreen();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		chatapp.add(startchat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setTitle(message);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/images/P2.jpg")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel);
	}

}
