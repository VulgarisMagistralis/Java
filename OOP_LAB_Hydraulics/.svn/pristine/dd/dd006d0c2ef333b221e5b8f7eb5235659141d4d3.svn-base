package hydraulic;
public class Element {
	private Element next;
	private double flowIn;
	private double flowOut;
	public String elemType;
	private String elementName;
	public Element(String name){elementName = name;}
	public String getName(){return elementName;}
	public void connect(Element elem){ 
		if(this instanceof Sink) return;
		elem.setFlow(this.getFlowOut());
		this.setNext(elem);
	}
	//GETTER-SETTER
	public Element getOutput(){return next;}
	public String getElementName() {return elementName;}
	public void setElementName(String elementName) {this.elementName = elementName;}
	public Element getNext() {return next;}  
	public void setNext(Element next) {this.next = next;}
	public double getFlowIn() {return flowIn;}
	public void setFlow(double flow) {this.flowIn = flow;}
	public double getFlowOut() {return flowOut;}
	public void setFlowOut(double flow) {this.flowOut = flow;}	
}
