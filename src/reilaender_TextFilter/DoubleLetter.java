package reilaender_TextFilter;

public class DoubleLetter extends TextFilter {

	public DoubleLetter(Text t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getFilteredText() {
		String tmp = getText().getFilteredText();
		String ntmp="";
		System.out.println(ntmp);
		for(int i = 0; i < tmp.length(); i++){
			for(int j=0; j < 2; j++){
				ntmp+= ""+tmp.charAt(i);
			}
		}
		
		return ntmp;
	}

}