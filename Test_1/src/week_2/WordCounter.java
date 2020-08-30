package week_2;

public class WordCounter {
	private static final int num = 1024; // #define num = 1024, final = unchangeable 
	// static vars and methods can be gotten without class instances

	private Word[] text;
	public WordCounter() {
		text = new Word[num];
	}
	public WordCounter(int number) {
		text = new Word[number]; //1024 -> magic numbers => dont use them
	}
	private int getIndex(String word) {
		int i = 0;
		for(Word w: text)
			if(w!= null && w.getWord().equals(word)) return i;
			else ++i;
		return -1;
	}
	private int initElement() {
		int i = 0;
		for(Word w: text)
			if(w == null) return i;
		    else ++i;
		incSize();
		return i;
	}
	private void incSize() { // to increase space in case input exceeds current space for array
		int i = 0;
		Word[] textTemp = new Word[text.length * 2];
		for(Word w : text) textTemp[i++] = w;
		text = textTemp;	
	}
	public void addWord(String word) {
		int i = getIndex(word);
		if(i < 0) {
			i = initElement();
			text[i] = new Word(word);
		}else text[i].setCount(text[i].getCount() + 1);
		
	}
	public void print() {
		for(Word w: text) if(w != null) System.out.println("Word:"+ w.getWord() +", count: "+ w.getCount());	
	}
}
//nogaykucuk@hotmail.com