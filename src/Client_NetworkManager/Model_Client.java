package Client_NetworkManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import reilaender_TextFilter.BadWords;
import reilaender_TextFilter.ConcreteText;
import reilaender_TextFilter.DoubleLetter;
import reilaender_TextFilter.ReplaceLaughing;
import reilaender_TextFilter.Text;
import reilaender_TextFilter.ToUppercase;

public class Model_Client {
	//	private GUI_Chat GUI;
	private Socket client;
	private PrintWriter writer;
	private BufferedReader reader;
	private Text t;

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
	public BufferedReader getReader() {
		return reader;
	}
	public void sendMessage(String msg) {
		t = new ConcreteText(msg);
	    t = new ReplaceLaughing(t);
	    try {
			t = new BadWords(t, "bads.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    t = new DoubleLetter(t);
	    t = new ToUppercase(t);
	    
		writer.println(t.getFilteredText());
		writer.flush();
	}
}