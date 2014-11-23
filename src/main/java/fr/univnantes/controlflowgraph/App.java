package fr.univnantes.controlflowgraph;

import java.io.IOException;
import java.util.LinkedList;

/** Example class
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("\n================================================================");
		System.out.println("  This is just an example for how to use this graph structure.");
		System.out.println("  Open fr.univnantes.controlflowgraph.App to see it.");
		System.out.println("================================================================\n");
		
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
		
		Node graph,nA,nB,nC,nD,n;
		Arc a;
		
		graph = new Instruction("x = 8");
		
		nA = new Condition();
		a = new Arc(" ",nA);
		graph.addArc(a);
		
		nB = new Instruction("y = 6");
		a = new Arc("x > 8",nB);
		nA.addArc(a);
		
		nC = new Instruction("L337", "y = 7");
		a = new Arc("x == 8",nC);
		nA.addArc(a);
		
		nD = new Instruction("y = 1");
		a = new Arc(" ",nD);
		nA.addArc(a);
		
		System.out.println("Node["+graph+"]");
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(graph);
		Node cur = null;
		System.out.println("size ="+queue.size());
		while(queue.size() > 0) {
			cur = queue.remove();
			System.out.println(cur.toString());	
			for(Arc arc : cur.getArcs()) {
				queue.add(arc.getNext());
			}
		}
	}	
}
