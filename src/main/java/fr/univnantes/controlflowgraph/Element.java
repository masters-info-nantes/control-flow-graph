package fr.univnantes.controlflowgraph;

/** {@code Element} is a uniform base to have a unique {@code id} for each element in the structure.
 */
public abstract class Element {
	/** Previous {@code Element} {@code id}. Use for attribute a unique {@code id} for a new {@code Element} if no {@code id} is specified
	 */
	private static int previousElementId = -1;
	/** {@code id} of the current {@code Element}. {@code id} is unique for all {@code Element}.
	 */
	private int id;
	
	/** Generates the next {@code id}.
	 */
	private final static int genNextId() {
		previousElementId++;
		return previousElementId;
	}
	
	/** Constructs a new {@code Element}.
	 * 
	 * @param id the id of the new {@code Element}. May be unique, if you can't be sure that your id is unique use blank constructor.
	 */
	public Element(int id) {
		this.id = id;
		if(id > previousElementId)
			previousElementId = id;
	}
	
	/** Constructs a new {@code Element} 
	 */
	public Element() {
		this(genNextId());
	}
	
	/** Gets the id of the {@code Element}.
	 * 
	 * @return the id of this {@code Element}
	 */
	public int getId() {
		return this.id;
	}
	
	/** Tests this {@code Element} for equality with {@code other}.
	 * Two {@code Element} are equals if there ids are equals.
	 * 
	 * @param other {@code Element} to compare with.
	 * 
	 * @return {@code true} if specified object other is equal to this {@code Element}; {@code false} otherwise.
	 */
	public boolean equals(Element other) {
		return this.id == other.id;
	}
	
	public String toString() {
		return "id="+id;
	}
}