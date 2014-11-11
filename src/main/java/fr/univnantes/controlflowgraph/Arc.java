package fr.univnantes.controlflowgraph;

public class Arc {
	private String label;
	private Node next;
	
	public Arc(String label, Node next) {
		this.label = label;
		this.next = next;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public String toString() {
		return "label="+this.label+",next="+next.toString();
	}
}