package test;

import Client_NetworkManager.Controller_Client;

public class testClient {
	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			@Override
			public void run() {
				new Controller_Client(new String[]{"localhost", "4465"});
			}
		}.start();
	}
}