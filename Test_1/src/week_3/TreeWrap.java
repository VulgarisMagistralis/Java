package week_3;

public class TreeWrap {
	Tree wordTree;
	public TreeWrap() {
		wordTree = new Tree();
		wordTree.add("ffs");
		System.out.println(wordTree.search("ffs").getWord());
	//	words.inOrderVisit();
	}
	public void addWord(String word) {
		 Word w = wordTree.search(word);
		 if(w!=null)w.setCount(w.getCount()+1);
		 else wordTree.add(word);
	}
	public void print() {
		wordTree.inOrderVisit();
	}
}
//nogaykucuk@hotmail.com