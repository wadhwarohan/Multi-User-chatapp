package com.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	int counter;
	public UserView() {
		counter=0;
		setVisible(true);
		setSize(400,400);
		//setResizable(false);
		setTitle("Chatapp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocation(500,500);
		setLocationRelativeTo(null); // for display in center
		final JLabel welcome=new JLabel("Login");
		welcome.setFont(new Font("Times new Roman",Font.BOLD,50));;
		Container container=this.getContentPane();
        container.setLayout(null);
        welcome.setBounds(100,70,200,60);
        container.add(welcome);
        JButton button=new JButton("Count");
        container.add(button);
        button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event)
        {
        	counter ++;
        	welcome.setText("Count"+counter);
        }
        });
	}
	public static void main(String[] arg)
	{
		UserView userview=new UserView();
		
		
	}
}
