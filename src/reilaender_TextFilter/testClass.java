package reilaender_TextFilter;

import java.io.FileNotFoundException;

public class testClass {
	public static void main(String[] args) {
		Text t = new ConcreteText("ConcreteText anus anal");
		try {
			t = new BadWords(t, "C:\\Users\\manuel\\Desktop\\bads.txt");
			t = new DoubleLetter(t);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(t.getFilteredText());
	}
}
