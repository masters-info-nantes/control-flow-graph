package fr.univnantes.controlflowgraph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		File file = new File("html/data.js");
		App.display(file);
	}
	
	public static void anthMain(){
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
	
	/**
	 * Generate js code to display graph in web browser
	 * 	- html folder in root directory contains vis.js library
	 *  - to see graph see html/index.html in a browser
	 *  - not sure to keep for future release
	 * @param file
	 * @throws IOException
	 */
	public static void display(File file) throws IOException {
		Node origin,nA,nB,nC,nD,n;
		Arc a;
		
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
		
		//-----
		String path = file.getAbsolutePath();
		file.delete();
		BufferedWriter nfile = new BufferedWriter(new FileWriter(path, true));
		nfile.write("var nodes = [];\n");
		nfile.write("var edges = [];\n");
		//-----
		
		// Print example
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(origin);
		Node cur = null;
		while(queue.size() > 0) {
			cur = queue.remove();
			nfile.write("nodes.push({ id: " + cur.hashCode() + ", label: String(\"" + cur.getName() + "\")});\n");

			System.out.println(cur.toString());	
			for(Arc arc : cur.getArcs()) {
				nfile.write("edges.push({ from: " + cur.hashCode() + ", to: " + arc.getNext().hashCode() + "});\n");
				queue.add(arc.getNext());
			}
		}
		
		nfile.close();
	}
}
