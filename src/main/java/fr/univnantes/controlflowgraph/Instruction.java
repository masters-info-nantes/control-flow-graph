package fr.univnantes.controlflowgraph;

import java.lang.Integer;
import java.lang.Math;
import java.lang.String;
import java.util.LinkedList;

/** Class for represent {@code Instruction} node.
 */
public class Instruction extends Node {
	/** Previous {@code Instruction} {@code name}. Use for attribute a unique {@code name} for a new {@code Condition} if no {@code name} is specified
	 */
	private static int previousInstructionName = -1;
	private String value;
	
	/** Generates the next {@code name}.
	 */
	private static String genNextName() {
		previousInstructionName++;
		return toBase26(previousInstructionName);
	}
	
	/** Converts number in hexavigesimal base (A=0,B=1,..,Z=25,BA=26,...)
	 * 
	 * @param number the number to convert.
	 * 
	 * @return the {@code String} representation of the number in hexavigesimal base.
	 */
	private static String toBase26(int number){
		number = Math.abs(number);
		String converted = "";
		// Repeatedly divide the number by 26 and convert the
		// remainder into the appropriate letter.
		while (number > 0) {
			int remainder = number % 26;
			converted = (char)(remainder + 'A') + converted;
			number = (number - remainder) / 26;
		}
		if(converted.equals(""))
			converted = "A";
		return converted;
    }
    
	/** Constructs a new {@code Instruction}.
	 * 
	 * @param id the id of the new {@code Instruction}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 * @param name the name of the new {@code Instruction}.
	 * @param value the value of the new {@code Instruction}.
	 */
	public Instruction(int id, String name, String value) {
		super(id, name);
		this.value = value;
	}
	
	/** Constructs a new {@code Instruction}.
	 * 
	 * @param name the name of the new {@code Instruction}.
	 * @param value the value of the new {@code Instruction}.
	 */
	public Instruction(String name, String value) {
		super(name);
		this.value = value;
	}
	
	/** Constructs a new {@code Instruction}.
	 * 
	 * @param id the id of the new {@code Instruction}. @see fr.univnantes.controlflowgraph.Element#Element(int).
	 * @param value the value of the new {@code Instruction}.
	 */
	public Instruction(int id, String value) {
		super(id,genNextName());
		this.value = value;
	}
	
	/** Constructs a new {@code Instruction} with a generated name.
	 * 
	 * @param value the value of the new {@code Instruction}.
	 */
	public Instruction(String value) {
		this(genNextName(),value);
	}
	
	/** Gets the value of this {@code Instruction}.
	 * 
	 * @return The value of this {@code Instruction}.
	 */
	public String getValue() {
		return this.value;
	}
	
	public String toString() {
		return super.toString()+",value=\""+this.value+"\"";
	}
}