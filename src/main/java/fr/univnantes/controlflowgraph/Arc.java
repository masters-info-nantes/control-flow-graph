package fr.univnantes.controlflowgraph;

/** Class for represent Arc.
 */
public class Arc extends Element {
	private String name;
	private Node next;
	
	/** Constructs a new {@code Arc}.
	 * 
	 * @param id the id of the new {@code Arc}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 * @param name the name of the new {@code Arc}.
	 * @param next the @see fr.univnantes.controlflowgraph.Node this {@code Arc} may target.
	 */
	public Arc(int id, String name, Node next) {
		super(id);
		init(name,next);
	}
	
	/** Constructs a new {@code Arc}.
	 * 
	 * @param name the name of the new {@code Arc}.
	 * @param next the @see fr.univnantes.controlflowgraph.Node this {@code Arc} may target.
	 */
	public Arc(String name, Node next) {
		super();
		init(name,next);
	}
	
	private void init(String name, Node next) {
		this.name = name;
		this.next = next;
	}
	
	/** Gets the {@code name} of this {@code Arc}.
	 * 
	 * @return The {@code name} of this {@code Arc}.
	 */
	public String getName() {
		return this.name;
	}
	
	/** Gets the {@code Node} targeted by this {@code Arc}.
	 * 
	 * @return The {@code Node} targeted by this {@code Arc}.
	 */
	public Node getNext() {
		return this.next;
	}
	
	public String toString() {
		return super.toString()+",next="+next.toString();
	}
}