package Client_NetworkManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Model_Client {
	//	private GUI_Chat GUI;
	private Socket client;
	private PrintWriter writer;
	private BufferedReader reader;

	public Model_Client() {
		
	}
	public void setSocket(String ip, int port) {
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
			
		}
	}
	public BufferedReader getReader() {
		return reader;
	}
	public void sendMessage(String msg) {
		writer.println(msg);
	}
}