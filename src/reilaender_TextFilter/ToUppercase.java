package reilaender_TextFilter;

public class ToUppercase extends TextFilter {

	public ToUppercase(Text t) {
		super(t);
	}
	@Override
	public String getFilteredText() {
		// TODO Auto-generated method stub
		return getText().getFilteredText().toUpperCase();
	}

}
