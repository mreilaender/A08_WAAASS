package reilaender_server_NetworkManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Model_Server {
	private MessageHandler handler;
	private ServerSocket server;
	
	public Model_Server(int port) throws IOException {
		System.out.println("Trying to start ServerSocket on port "+port);
		server = new ServerSocket(port);
		System.out.println("Server has been started on port "+server.getLocalPort());
		handler = new MessageHandler();
//		for(int i = 0;i < 100;++i)System.out.println();
	}
	public void listen() {
		while(true) {
			try {
				Socket client = server.accept();
				handler.registerClient(new PrintWriter(client.getOutputStream()));
				
				Thread t = new Thread(new Client_Handler(client, handler));
				t.start();
				
			} catch (IOException e) {
				System.out.println("died ....");
			}
		}
	}
}