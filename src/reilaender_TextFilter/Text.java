package reilaender_TextFilter;

public interface Text {
	/**
	 * Returns a filtered Text, depending on its sub class. 
	 * @param toBeFiltered Text which has to be filtered
	 * @return filtered text
	 */
	public String getFilteredText();
}
