package reilaender_TextFilter;

public abstract class TextFilter implements Text {
	private Text text;
	
	public TextFilter(Text t) {
		this.text = t;
	}
	public Text getText() {
		return text;
	}
}