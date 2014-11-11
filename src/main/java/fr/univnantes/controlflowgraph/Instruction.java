package fr.univnantes.controlflowgraph;

import java.lang.Integer;
import java.lang.Math;
import java.lang.String;
import java.util.LinkedList;

public class Instruction extends Node {
	private static int nameNext = -1;
	private String value;
	
	private static String genNext() {
		nameNext++;
		return toBase26(nameNext);
	}
	
	public static String toBase26(int number){
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