package hydraulic;
public class Split extends Element {
	private Element next1;
	private Element next2;
	public Split(String name) {super(name);super.elemType = "SPLIT";}
	@Override
	public Element getOutput() {
		System.out.println("First Output");
		return this.getNext1();
	}
	@Override
	public void setNext(Element next) {
		if(this.getNext1()!= null) { this.setNext1(next); return;}
		else if(this.getNext2() != null) { this.setNext2(next); return;}
		System.err.println("New item cannot be connected!"); return;
	}
	@Override
	public void setFlowOut(double flow) {super.setFlowOut(flow / 2);}
	public Element[] getOutputs(){
		Element[] outList = new Element[2];
		outList[0] = this.getNext1();
		outList[1] = this.getNext2();
        return outList;
    }
	public void connect(Element elem, int noutput){
		if(noutput == 0) { 
			this.setNext1(elem);
			elem.setFlow(this.getFlowOut());
			return;
		}else if(noutput == 1) { 
			this.setNext2(elem); 
			elem.setFlow(this.getFlowOut());
			return;
		}
		else System.err.println("Invalid parameter");
	}
	//GETTERS - SETTERS
	
	public Element getNext1() {return next1;}
	@Override
	public Element getNext() {
		if(this.getNext1() != null) return this.getNext1();
		else if(this.getNext2() != null) return this.getNext2();
		System.err.println("No output detected!");
		return null;
	}
	public void setNext1(Element next1) {this.next1 = next1;}
	public Element getNext2() {return next2;}
	public void setNext2(Element next2) {this.next2 = next2;}
}
