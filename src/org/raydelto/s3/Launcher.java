package org.raydelto.s3;

import java.io.IOException;

import org.raydelto.s3.net.Server;

public class Launcher {
	public static void main(String[] args) {
		try {
			int port = args.length > 0 ? Integer.parseInt(args[0]) : 4444;			
			new Server(port).listen();
			System.out.println("Server is exiting gracefully"); // this line is never reached yet. TODO: Add a stop mechanism
		} catch (IOException e) {
			System.err.println("Server error: " + e);
			e.printStackTrace();
		}catch(NumberFormatException nfe){
			System.err.println("Please specify a numeric value for defining the server port");
		}
	}

}
