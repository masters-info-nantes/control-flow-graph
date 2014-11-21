package fr.univnantes.controlflowgraph;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {

	private Node graph;
	
	@Before
	public void setUp() throws Exception {
		
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
		
		Node nA,nB,nC,nD,n;
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
	}

	@Test
	public void testPrint() {		
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
		
		for(int i=0;i<1000;i++) {
			Node n = new Instruction("inst "+i);
			System.out.println(n.toString());
		}		
	}

	@Test
	public void testFileDisplay() throws IOException{
		/**
		 * Generate js code to display graph in web browser
		 * 	- html folder in root directory contains vis.js library
		 *  - to see graph see html/index.html in a browser
		 *  - not sure to keep for future release
		 * @param file
		 * @throws IOException
		 */

		File file = new File("html/data.js");
		String path = file.getAbsolutePath();
		file.delete();
		BufferedWriter nfile = new BufferedWriter(new FileWriter(path, true));
		nfile.write("var nodes = [];\n");
		nfile.write("var edges = [];\n");
		
		// 2 loops because all nodes must declared before be mentionned in edges
		boolean start = true;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(graph);
		Node cur = null;
		ArrayList<Integer> idList = new ArrayList<Integer>();
		while(queue.size() > 0) {
			cur = queue.remove();
			if(!idList.contains(cur.hashCode())){
				if(start){
					nfile.write("nodes.push({ id: " + cur.hashCode() + ", label: String(\"" + cur.getName() + "\"), title: \"Start node\" });\n");
					start = false;
				}
				else {
					nfile.write("nodes.push({ id: " + cur.hashCode() + ", label: String(\"" + cur.getName() + "\"), title: String(\"" + cur.getLabel() + "\") });\n");		
				}	
			}
			
			idList.add(cur.hashCode());
			
			for(Arc arc : cur.getArcs()) {
				queue.add(arc.getNext());
			}
		}
		
		queue.add(graph);
		cur = null;
		while(queue.size() > 0) {
			cur = queue.remove();			

			for(Arc arc : cur.getArcs()) {
				nfile.write("edges.push({ from: " + cur.hashCode() + ", to: " + arc.getNext().hashCode() + " });\n");
				queue.add(arc.getNext());
			}
		}
		
		nfile.close();
	}
	
	@Test
	public void testFind(){
		assertNotNull(graph.findNode("L337"));
		assertNull(graph.findNode("I337"));
	}
}
