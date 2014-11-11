package fr.univnantes.controlflowgraph;

import java.lang.Integer;
import java.lang.String;

public class Instruction extends Node {
	private static int nameNext = -1;
	private String value;
	
	private static String genNext() {
		nameNext++;
		return toAZBase(nameNext);
	}
	
	private static String toAZBase(int i) {
		return Integer.toString(i);
	}
	
	public Instruction(String value) {
		super(genNext());
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public String toString() {
		return super.toString()+",value=\""+this.value+"\"";
	}
}