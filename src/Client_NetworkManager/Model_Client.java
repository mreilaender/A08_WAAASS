package Client_NetworkManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Model_Client {
	//	private GUI_Chat gui;
	private Socket client;
	private PrintWriter writer;
	private BufferedReader reader;

	public Model_Client(String ip, int port) {
		setSocket(ip, port);
	}
	private void setSocket(String ip, int port) {
		try {
			System.out.println("Trying to connect to Server on " + ip + ":" + port);
			client = new Socket(ip, port);
			
			writer = new PrintWriter(client.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			writer.println("I have just connected to you");
			writer.flush();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}
	public void closeStreams() throws IOException {
		writer.close();
		reader.close();
	}
	public void waitForMessage() {
		System.out.println("Waiting for Messages from Server");
		while(true) {
			try {
				String msg = reader.readLine();
				if(msg != null) {
					System.out.println("\n"+msg);
					writer.println("I got a Message from you");
					writer.flush();
				} else {
					System.out.print(".");
				}
			} catch (IOException e) {
				System.out.print(".");
			}
		}
	}
}