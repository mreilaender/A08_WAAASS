package test;

import Client_NetworkManager.Controller_Client;

public class testClass {
	public static void main(String[] args) throws InterruptedException {
		new Controller_Client(new String[]{"localhost", "45967"}).waitForMessage();
//		new Controller_Client(new String[]{"localhost", "45967"});
	}
}