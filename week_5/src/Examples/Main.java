package Examples;

public class Main {

	public static void main(String args[]) {
		Alien a = new Alien("fuck","mars",1,2,2,"Yellow");
		a.greet();
		Alien b = new Martian();
		b.greet();
		Alien[] aliens = new Alien[3];
		aliens[0] = new Martian();
		aliens[1] = new Martian();
		aliens[2] = new Venusian();
		//Venusian v = (Venusian) aliens[1]; // we can't do it because we didnt dictate the transformation rule downcasting
		//v.playJazz(); // invalid shit -> class cast exception !!
		for(Alien al : aliens) {
			al.greet(); // inheritance polymorph to be able to do this
			if(al instanceof Venusian) {
				Venusian ve = (Venusian)al;
				ve.playJazz();
			}
		}

	
	}
}
