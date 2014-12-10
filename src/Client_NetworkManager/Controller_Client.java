package Client_NetworkManager;

public class Controller_Client {
	//Model
	private Model_Client m_client;
	
	//View
	private GUI_Client v_chat;
	
	public Controller_Client(String[]args) {
		m_client = new Model_Client(args[0], Integer.parseInt(args[1]));
//		v_chat = new GUI_Client(this);
	}
	public void waitForMessage() {
		m_client.waitForMessage();
	}
}