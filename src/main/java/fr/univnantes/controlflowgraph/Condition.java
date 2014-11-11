package fr.univnantes.controlflowgraph;

import java.lang.Integer;
import java.lang.String;

public class Condition extends Node {
	private static int nameNext = -1;
	
	private static String genNext() {
		nameNext++;
		return Integer.toString(nameNext);
	}
	
	public Condition() {
		super(genNext());
	}
}