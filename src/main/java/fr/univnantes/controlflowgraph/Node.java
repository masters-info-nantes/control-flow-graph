package fr.univnantes.controlflowgraph;

import java.util.List;
import java.util.ArrayList;

public abstract class Node {
	private String label;
	private String name;
	private ArrayList<Arc> arcs;
	
	public Node(String name){
		this.name = name;
		this.label = "";
		arcs = new ArrayList<Arc>();
	}
	
	public Node(String label, String name) {
		this(name);
		this.label = label;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Arc> getArcs() {
		return this.arcs;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	public void addArc(Arc a) {
		this.arcs.add(a);
	}
	
	public boolean isFinal() {
		return this.arcs.isEmpty();
	}
	
	public String toString() {
		return "name="+this.name+",arcs["+this.arcs.size()+"]";
	}
	
	public Node findNode(String label){
		if(this.label.equals(label)){
			return this;
		}
		else if(this.isFinal()){
			return null;
		}
		
		Node node = null;
		for (Arc arc : arcs) {
			Node anode = arc.getNext().findNode(label);
			node = (anode != null) ? anode : node;
		}
		return node;
	}
}