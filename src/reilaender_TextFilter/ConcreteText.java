package reilaender_TextFilter;

public class ConcreteText implements Text {
	private String text;
	public ConcreteText(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}
	@Override
	public String getFilteredText() {
		return this.text;
	}
}