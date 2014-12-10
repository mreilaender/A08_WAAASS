package Client_NetworkManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import observing.Observer;

public class Controller_Client implements ActionListener, KeyListener, Observer {
	//Model
	private Model_Client m_client;
	
	//View
	private GUI_Client v_chat;
	
	//Some Classes
	private ReceiveHandler handler;
	
	public Controller_Client(String[]args) {
		m_client = new Model_Client();
			m_client.setSocket(args[0], Integer.parseInt(args[1]));
		
		v_chat = new GUI_Client(this);
			
		handler = new ReceiveHandler(m_client.getReader());
			handler.register(this);
			new Thread(handler).start();
			
		while(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Send")){//.equals() TODO
			m_client.sendMessage(v_chat.getText());
			v_chat.clearTextField();
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){//.equals() TODO
			m_client.sendMessage(v_chat.getText());
			v_chat.clearTextField();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// UNUSED
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// UNUSED
	}
	@Override
	public void update(String msg) {
		// TODO Auto-generated method stub
		v_chat.printMessage(msg);
	}
	@Override
	public void update() {
		// UNUSED
	}
}