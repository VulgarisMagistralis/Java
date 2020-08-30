package singleton;

public class Directory {
	private static Directory single;
	/*  static { // implentation with final keyword
    	single = new Directory();
    }
    */
	private Directory(){ // private construct to preevent usage of new Directory();
		
	}
    public static Directory getInstance() {
    	if(single == null) {
    		System.err.println("CREATING!");
    		single = new Directory();
    	}else 	System.err.println("ALREADY EXISTS");
    	return single;
    }
    public void meth() {
    	//Directory d =new Directory();// still works
    }
}
