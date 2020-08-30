/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY••)    *
*   #####     *  (!) Mar-2018, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, is permitted in any medium without royalty,   *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

package it.polito.oop.wc_array;

public class WordCount {
	static final private int BASE_SIZE = 3;
	static final private int INCREMENT = 2;
	public static class Entry {
		private String word;
		private int count;

		public String getWord() {
			return word;
		}
		public int getCount() {
			return count;
		}
		private Entry(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}

	private Entry[] entries = new Entry[BASE_SIZE];

	public WordCount() {
		// empty
	}
	
	private void expandEntryArray(int newEntries) {
		Entry[] e = new Entry[entries.length + newEntries];
		for(int t = 0; t < entries.length; ++t)
			e[t] = entries[t];
		entries = e;
	}
	
	private int findEmptySlot() {
		for(int t = 0; t < entries.length; ++t)
			if(entries[t] == null)
				return t;
		expandEntryArray(INCREMENT);
		return findEmptySlot();
	}
	
	private int findWord(String word) {
		for(int t = 0; t < entries.length; ++t)
			if(entries[t] != null && word.equals(entries[t].word))
				return t;
		return -1;
	}
	
	public void addWord(String word) {
		int pos = findWord(word);
		if(pos >= 0) {
			++entries[pos].count;
		} else {
			pos = findEmptySlot();
			entries[pos] = new Entry(word, 1);
		}
	}
	
	public Entry[] getEntries() {
		return entries;
	}
}
