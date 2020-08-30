package hydraulic;
public class Tap extends Element {
	private boolean open; 
	public Tap(String name) {super(name);super.elemType="TAP";}
	public void setOpen(boolean open){this.open = open;}
	public boolean isOpen() {return open;}
}
