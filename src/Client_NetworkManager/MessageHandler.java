package Client_NetworkManager;

import stop.Stoppable;

public class MessageHandler implements Runnable, Stoppable {
	private boolean running;
	
	public MessageHandler() {
		
	}
	@Override
	public void run() {
		running = true;
		while(running) {
			
		}
	}
	@Override
	public void stoping() {
		running = false;
	}
}