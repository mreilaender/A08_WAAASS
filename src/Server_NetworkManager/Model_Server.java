package Server_NetworkManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Model_Server {
	private ServerSocket server;
	
	public Model_Server(int port) throws IOException {
		System.out.println("Trying to start ServerSocket on port "+port);
		server = new ServerSocket(port);
		System.out.println("Server has been started on port "+server.getLocalPort());
//		for(int i = 0;i < 100;++i)System.out.println();
	}
	public void listen() {
		while(true) {
			try {
				Socket client = server.accept();
				
				Thread t = new Thread(new Client_Handler(client));
				t.start();
				
			} catch (IOException e) {
				System.out.println("died ....");
			}
		}
	}
}