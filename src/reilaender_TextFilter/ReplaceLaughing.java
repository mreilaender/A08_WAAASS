package reilaender_TextFilter;

public class ReplaceLaughing extends TextFilter {

	public ReplaceLaughing(Text t) {
		super(t);
	}
	@Override
	public String getFilteredText() {
		// TODO Auto-generated method stub
		return getText().getFilteredText() + ", ReplaceLaughing";
	}
}
