package fr.univnantes.controlflowgraph;

import java.util.HashSet;
import java.util.Iterator;

/** Class for simplify graph construction
 */
public class GraphFactory {
	
	protected HashSet arcSet;
	protected HashSet nodeSet;
	
	/** Constructs a new {@code GraphFactory}.
	 */
	public GraphFactory() {
		arcSet = new HashSet<Arc>();
		nodeSet = new HashSet<Node>();
	}
	
	/** Constructs a new {@code Arc}.
	 * 
	 * @param id the id of the new {@code Arc}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 * @param name the name of the new {@code Arc}.
	 * @param next the @see fr.univnantes.controlflowgraph.Node this {@code Arc} may target.
	 * 
	 * @return the new {@code Arc}
	 */
	public Arc makeArc(int id, String name, Node next) {
		Arc a = new Arc(id,name,next);
		arcSet.add(a);
		return a;
	}
	
	/** Constructs a new {@code Arc}.
	 * 
	 * @param name the name of the new {@code Arc}.
	 * @param next the @see fr.univnantes.controlflowgraph.Node this {@code Arc} may target.
	 * 
	 * @return the new {@code Arc}
	 */
	public Arc makeArc(String name, Node next) {
		Arc a = new Arc(name,next);
		arcSet.add(a);
		return a;
	}
	
	
	/** Constructs a new {@code Condition}.
	 * 
	 * @param id the id of the new {@code Condition}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 * @param name the name of the new {@code Condition}.
	 * 
	 * @return the new {@code Condition}
	 */
	public Condition makeCondition(int id, String name) {
		Condition c = new Condition(id,name);
		nodeSet.add(c);
		return c;
	}
	
	/** Constructs a new {@code Condition}.
	 * 
	 * @param id the id of the new {@code Condition}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 * 
	 * @return the new {@code Condition}
	 */
	public Condition makeCondition(int id) {
		Condition c = new Condition(id);
		nodeSet.add(c);
		return c;
	}
	
	/** Constructs a new {@code Condition}.
	 * 
	 * @param name the name of the new {@code Condition}.
	 * 
	 * @return the new {@code Condition}
	 */
	public Condition makeCondition(String name) {
		Condition c = new Condition(name);
		nodeSet.add(c);
		return c;
	}
	
	/** Constructs a new {@code Condition} with a generated name.
	 * 
	 * @return the new {@code Condition}
	 * 
	 */
	public Condition makeCondition() {
		Condition c = new Condition();
		nodeSet.add(c);
		return c;
	}
	
	
	
	/** Constructs a new {@code Instruction}.
	 * 
	 * @param id the id of the new {@code Instruction}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 * @param name the name of the new {@code Instruction}.
	 * @param value the value of the new {@code Instruction}.
	 * 
	 * @return the new {@code Instruction}
	 */
	public Instruction makeInstruction(int id, String name, String value) {
		Instruction i = new Instruction(id, name,value);
		nodeSet.add(i);
		return i;
	}
	
	/** Constructs a new {@code Instruction}.
	 * 
	 * @param name the name of the new {@code Instruction}.
	 * @param value the value of the new {@code Instruction}.
	 * 
	 * @return the new {@code Instruction}
	 */
	public Instruction makeInstruction(String name, String value) {
		Instruction i = new Instruction(name,value);
		nodeSet.add(i);
		return i;
	}
	
	/** Constructs a new {@code Instruction}.
	 * 
	 * @param id the id of the new {@code Instruction}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 * @param value the value of the new {@code Instruction}.
	 * 
	 * @return the new {@code Instruction}
	 */
	public Instruction makeInstruction(int id, String value) {
		Instruction i = new Instruction(id,value);
		nodeSet.add(i);
		return i;
	}
	
	/** Constructs a new {@code Instruction} with a generated name.
	 * 
	 * @param value the value of the new {@code Instruction}.
	 * 
	 * @return the new {@code Instruction}
	 */
	public Instruction makeInstruction(String value) {
		Instruction i = new Instruction(value);
		nodeSet.add(i);
		return i;
	}
	
	/** Finds a node in this graph.
	 * 
	 * @param toFind the {@code Node} to find
	 * 
	 * @return a {@code Node} whose is equals to the {@code Node} in parameter if a {@code Node} correspond to it in this graph; {@code null} otherwise.
	 */
	public Node findNode(Node toFind){
		Node n;
		Iterator itr = nodeSet.iterator();
		while (itr.hasNext()) {
			n = (Node)itr.next();
			if(n.equals(toFind)) {
				return n;
			}
		}
		return null;
	}
	
	/** Finds a node in this graph.
	 * 
	 * @param id the id of the {@code Node} to find
	 * 
	 * @return a {@code Node} whose have the same id than {@code Node} in parameter if a {@code Node} correspond to it in this graph; {@code null} otherwise.
	 */
	public Node findNode(int id) {
		return findNode(new Node(id,""){});
	}
	
}