package org.raydelto.s3.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port;
	private ServerSocket server;
	private Socket client;
	private boolean started;
	
	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public Server(int port) {
		super();
		this.port = port;
		started = true;
	}

	public void listen() throws IOException {
		System.out.println("Starting server at port "+port);
		server = new ServerSocket(port);
		while(started){
			client = server.accept();
			new ListenerThread(client).start();
		}
		
	}

}
