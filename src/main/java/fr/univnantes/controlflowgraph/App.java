package fr.univnantes.controlflowgraph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Node origin,nA,nB,nC,nD,n;
		Arc a;
		
		/* Example :
		 * 
		 * x = 8;
		 * if(x > 8) {
		 *	  y = 6
		 * } else if(x == 8 ) {
		 *	  y = 7
		 * } else {
		 *    y = 1;
		 * }
		 * 
		 */
		
		origin = new Instruction("x = 8");
		
		nA = new Condition();
		a = new Arc(" ",nA);
		origin.addArc(a);
		
		nB = new Instruction("y = 6");
		a = new Arc("x > 8",nB);
		nA.addArc(a);
		
		nC = new Instruction("y = 7");
		a = new Arc("x == 8",nC);
		nA.addArc(a);
		
		nD = new Instruction("y = 1");
		a = new Arc(" ",nD);
		nA.addArc(a);
		
		// Print example
		System.out.println("Node["+origin+"]");
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(origin);
		Node cur = null;
		System.out.println("size ="+queue.size());
		while(queue.size() > 0) {
			cur = queue.remove();
			System.out.println(cur.toString());	
			for(Arc arc : cur.getArcs()) {
				queue.add(arc.getNext());
			}
		}
		
		for(int i=0;i<1000;i++) {
			n = new Instruction("inst "+i);
			System.out.println(n.toString());
		}
	}
}
