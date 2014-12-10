package test;

import Server_NetworkManager.Controller_Server;

public class testServer {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				new Controller_Server(new String[]{"4465"}).waitForConnections();
			}
		}.start();
	}
}
