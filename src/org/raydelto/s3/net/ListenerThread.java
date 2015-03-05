package org.raydelto.s3.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListenerThread extends Thread{
	private Socket client;
	public ListenerThread(Socket client){
		this.client = client;
	}
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String line = null;
			while( (line = reader.readLine() ) != null){
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Error while reading remote stream: " + e);
			e.printStackTrace();
		}
	}

}
