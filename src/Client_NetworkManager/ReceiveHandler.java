package Client_NetworkManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import reilaender_observing.Observer;
import reilaender_observing.Subject;
import reilaender_stop.Stoppable;

/**
 * Retrieves the given BufferedReader and updates its Observers if a Messages comes in.
 * @author manuel
 *
 */
public class ReceiveHandler implements Runnable, Stoppable, Subject {
	private boolean running;
	private BufferedReader reader;
	private ArrayList<Observer> observer;
	
	public ReceiveHandler(BufferedReader reader) {
		this.reader = reader;
		observer = new ArrayList<>();
	}
	@Override
	public void run() {
		running = true;
		while(running) {
			try {
				String msg = reader.readLine();
				if(msg != null) {
					for(int i = 0;i < observer.size();++i) {
						observer.get(i).update(msg);
					}
				} else {
					System.out.print(".");
				}
			} catch (IOException e) {
				System.out.print(".");
			}
		}
	}
	/**
	 * Stops this Thread
	 */
	@Override
	public void stoping() {
		running = false;
	}
	@Override
	public void register(Observer ob) {
		observer.add(ob);
	}
	@Override
	public void unregister(Observer ob) {
		observer.remove(ob);
	}
	@Override
	public void notifyObservers() {
		// UNUSED
	}
}