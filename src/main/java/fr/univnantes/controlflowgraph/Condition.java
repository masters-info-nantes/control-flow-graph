package fr.univnantes.controlflowgraph;

import java.lang.Integer;
import java.lang.String;

/** Class for represent {@code Condition} node.
 */
public class Condition extends Node {
	/** Previous {@code Condition} {@code name}. Use for attribute a unique {@code name} for a new {@code Condition} if no {@code name} is specified
	 */
	private static int previousConditionName = -1;
	
	/** Generates the next {@code name}.
	 */
	private static String genNextName() {
		previousConditionName++;
		return Integer.toString(previousConditionName);
	}
	
	/** Constructs a new {@code Condition}.
	 * 
	 * @param id the id of the new {@code Condition}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 * @param name the name of the new {@code Condition}.
	 */
	public Condition(int id, String name) {
		super(id,name);
	}
	
	/** Constructs a new {@code Condition}.
	 * 
	 * @param id the id of the new {@code Condition}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 */
	public Condition(int id) {
		super(id, genNextName());
	}
	
	/** Constructs a new {@code Condition}.
	 * 
	 * @param name the name of the new {@code Condition}.
	 */
	public Condition(String name) {
		super(name);
	}
	
	/** Constructs a new {@code Condition} with a generated name.
	 * 
	 */
	public Condition() {
		super(genNextName());
	}
}