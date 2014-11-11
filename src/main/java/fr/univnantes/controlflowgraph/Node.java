package fr.univnantes.controlflowgraph;

import java.util.List;
import java.util.ArrayList;

public abstract class Node {
	private String name;
	private ArrayList<Arc> arcs;
	
	public Node(String name) {
		this.name = name;
		arcs = new ArrayList<Arc>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Arc> getArcs() {
		return this.arcs;
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
}