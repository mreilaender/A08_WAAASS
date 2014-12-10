package Client_NetworkManager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.*;

public class GUI_Client extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller_Client con;
	private JTextField f1 = new JTextField();
	private TextArea t1;
	public GUI_Client(Controller_Client con) {
		this.con = con;
		
		
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new GridLayout(1, 2));
		t1 = new TextArea();
		
		
		
		
		JButton b1 = new JButton("Send");
		
		b1.setActionCommand("Send");
		b1.addActionListener(this.con);
		
		f1.addKeyListener(this.con);
		
		p2.add(f1);
		p2.add(b1);
		p1.add(t1,BorderLayout.CENTER);
		p1.add(p2,BorderLayout.SOUTH);
		add(p1);
		
		
		setVisible(true);
		
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public String getText() {
		return f1.getText();
	}
	/**
	 * Prints a String to the next line of the TextArea
	 * @param msg Message to be printed
	 */
	public void printMessage(String msg) {
		t1.setText(t1.getText() + "\n" + msg);
	}	
}