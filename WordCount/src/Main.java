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

// import it.polito.oop.wc_array.*;

import it.polito.oop.wc_tree.*;

public class Main {

	public static void main(String[] args) {
		WordCount wc = new WordCount();
		wc.addWord("Fluttershy");
		wc.addWord("Rarity");
		wc.addWord("Spike");
		wc.addWord("Cheerilee");
		wc.addWord("Rarity");
		wc.addWord("Applejack");
		wc.addWord("Scootaloo");
		wc.addWord("Zecora");
		wc.addWord("Spike");
		wc.addWord("Cheerilee");
		wc.addWord("Rarity");
		wc.addWord("Applejack");
		wc.addWord("Scootaloo");
		wc.addWord("Lyra");
		wc.addWord("Octavia");

		for(WordCount.Entry e: wc.getEntries()) {
			System.out.println(e.getWord() + ": " + e.getCount());
		}
	}
}
