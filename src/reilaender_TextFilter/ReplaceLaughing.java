package reilaender_TextFilter;

public class ReplaceLaughing extends TextFilter {
	private String [] laugh = {"lachen","lache,","haha","xD"};
	public ReplaceLaughing(Text t) {
		super(t);
	}
	@Override
	public String getFilteredText() {
		String tmp = getText().getFilteredText();
		for(int i=0;i<laugh.length;i++){
			tmp= tmp.replace(this.laugh[i], "lol");
		}
		
		return tmp;
	}
}
