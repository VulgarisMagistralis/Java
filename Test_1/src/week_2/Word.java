package week_2;

public class Word {
	private String word;
	private int count = 0;
	Word(String word) {// accessible in the package 
		//necessary initialization
		this.word = word;
        this.count = 1; //count++; ??
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
