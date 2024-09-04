package com.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.chatapp.utils.configReader;
public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker worker;
	JTextArea textArea;
public Client(JTextArea textArea) throws UnknownHostException, IOException {
	int PORT=Integer.parseInt(configReader.getvalue("PORTNO"));
//	socket=new Socket(configReader.getvalue("SERVER_IP"),PORT);
	InetAddress localHost = InetAddress.getLocalHost();
	socket = new Socket(localHost, PORT);
	out=socket.getOutputStream();
    in=socket.getInputStream();
    this.textArea=textArea;
    readMessages();
}
public void sendMessage(String message) throws IOException {
	message=message+ "\n";
	out.write(message.getBytes());
}
public void readMessages()
{
	worker=new ClientWorker(in,textArea);
    worker.start();
}
	
}
