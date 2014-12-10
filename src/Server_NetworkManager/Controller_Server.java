package Server_NetworkManager;

import java.io.IOException;

public class Controller_Server {
	private GUI_Server gui_serv;
	private Model_Server m_serv;

	public Controller_Server(String[]args) {
		try {
			m_serv = new Model_Server(Integer.parseInt(args[0]));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			//			System.out.println("Died .. Don't know why ... ");
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