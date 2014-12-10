package reilaender_TextFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BadWords extends TextFilter {
	private File path;
	private BufferedReader reader;
	// TODO UML
	/**
	 * Constructor
	 * @param t TODO
	 * @param pathToFile Path to the bad-word file
	 * @throws FileNotFoundException Thrown when the file
	 */
	public BadWords(Text t, String pathToFile) throws FileNotFoundException {
		super(t);
		path = new File(pathToFile);
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
	}
	/**
	 * Reads a File of Bad Words each Line and substitutes every word matches
	 * with "$%&*"
	 * @return The substituted String
	 */
	@Override
	public String getFilteredText() {
		String tmp = getText().getFilteredText();
		try {
			String line = reader.readLine();
			for(; line != null; line=reader.readLine())
				tmp = tmp.replace(line, "$%&*");
			reader.close();
			return tmp;
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
			return null;
		}
	}
}