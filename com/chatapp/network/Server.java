package com.chatapp.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.chatapp.utils.configReader;

public class Server {
ServerSocket serverSocket;
ArrayList<ServerWorker> workers= new ArrayList<>();
public Server() throws IOException {
	int PORT=Integer.parseInt(configReader.getvalue("PORTNO"));
	serverSocket=new ServerSocket(PORT);
	System.out.println("Server Start and waiting for client join");
	handleClientRequest();
}
//multiple client handshaking
public void handleClientRequest() throws IOException
{
	while(true)
	    {
		Socket clientSocket=serverSocket.accept();
		//per client per thread
		ServerWorker serverWorker =new ServerWorker(clientSocket,this);
		workers.add(serverWorker);
		serverWorker.start();//creating a new worker/thread
		}
}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Server server=new Server();
	}

}
