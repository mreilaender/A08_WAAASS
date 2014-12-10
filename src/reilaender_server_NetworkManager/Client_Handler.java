package reilaender_server_NetworkManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import reilaender_stop.Stoppable;

public class Client_Handler implements Runnable,Stoppable {
	private Socket client;
	private PrintWriter writer;
	private BufferedReader reader;
	private boolean running;
	private MessageHandler handler;
	
	public Client_Handler(Socket c, MessageHandler handler) throws IOException {
		client = c;
		writer = new PrintWriter(client.getOutputStream());
		reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		this.handler = handler;
		writer.println("Successfully connected to Server");
		writer.flush();
	}
	@Override
	public void run() {
		running = true;
		try {
			while(running) {
				String s = null;
				
				while((s = reader.readLine()) != null) {
					this.handler.notifyClients(s);
					System.out.println("Client [" + client.getInetAddress() + "]: " + s);
				}
			}
			closeStreams();
			//TODO
		} catch (IOException e) {
			e.printStackTrace();
//			System.err.println("Died for some reason...don't ask..."+"\n"+e.getMessage());
			System.exit(1);
		}
	}
	public void closeStreams() throws IOException {
		writer.close();
		reader.close();
	}
	@Override
	public void stoping() {
		running = false;
	}
}
