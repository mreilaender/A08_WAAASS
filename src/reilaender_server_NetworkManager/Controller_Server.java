package reilaender_server_NetworkManager;

import java.io.IOException;

public class Controller_Server {
	private Model_Server m_serv;
	private GUI_Server gui_serv;
	public Controller_Server(String[]args) {
		try {
			m_serv = new Model_Server(Integer.parseInt(args[0]));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		gui_serv = new GUI_Server(this);
	}
	public void waitForConnections() {
		m_serv.listen();
	}
	public static void main(String[] args) {
		Controller_Server server = 
				new Controller_Server(new String[]{"45967"});

		server.waitForConnections();
	}
}