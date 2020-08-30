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

package it.polito.oop.wc_tree;

public class WordCount {
	public static class Entry {
		private String word;
		private int count;

		public String getWord() {
			return word;
		}
		public int getCount() {
			return count;
		}
		Entry(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}

	private Tree entries = new Tree();

	public WordCount() {
		// empty
	}
		
	public void addWord(String word) {
		Entry e = entries.findEntry(word);
		if(e != null)
			++e.count;
		else
			entries.addEntry(word);
	}
	
	public Entry[] getEntries() {
		return entries.visit();
	}
}
