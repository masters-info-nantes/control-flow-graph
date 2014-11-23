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

	@Before
	public void setUp() throws Exception {
		
	}

/*
	@Test
	public void testFileDisplay() throws IOException{
		/**
		 * Generate js code to display graph in web browser
		 * 	- html folder in root directory contains vis.js library
		 *  - to see graph see html/index.html in a browser
		 *  - not sure to keep for future release
		 * @param file
		 * @throws IOException
		 * /

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
	}*/
	
}
