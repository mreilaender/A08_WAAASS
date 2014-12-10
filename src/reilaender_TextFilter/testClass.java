package reilaender_TextFilter;

import java.io.FileNotFoundException;

public class testClass {
	public static void main(String[] args) {
		Text t = new ConcreteText("haha ConcreteText anus anal");
		try {
			t = new ReplaceLaughing(t);
			t = new BadWords(t, "C:\\Users\\Markus\\Desktop\\bads.txt");
			t = new DoubleLetter(t);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(t.getFilteredText());
	}
}
