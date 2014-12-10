package reilaender_server_NetworkManager;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 * @author Manuel Reiländer
 * @author Markus Lupinek
 */
public class MessageHandler {
	public ArrayList<PrintWriter> clients;
	
	public MessageHandler() {
		clients = new ArrayList<>();
	}
	
	/**
	 * Adds an entry to the list of clients
	 * @param writer
	 */
	public synchronized void registerClient(PrintWriter writer) {
		clients.add(writer);
	}
	/**
	 * Notifies every client with the given message
	 * @param msg Message to be sent to the clients
	 */
	public synchronized void notifyClients(String msg) {
		for(int i = 0;i < clients.size();++i) {
			clients.get(i).println(msg);
			clients.get(i).flush();
		}
	}
}