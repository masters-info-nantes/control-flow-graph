package fr.univnantes.controlflowgraph;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import org.junit.Before;

public class NodeTest {

	Node graphLinear = null;
	Node graphLinearOneNode = null;
	Node graphCondition = null;
	Node graphConditionOneNode = null;
	Node graphCycle = null;
	Node graphCycleOneNode = null;
	
	@Before
	public void setUp() throws Exception {
		Node n0,n1,n2,n3,n4,n5;
		
		n0 = new Node("n0"){};
		n1 = new Node("n1"){};
		n2 = new Node("n2"){};
		n3 = new Node("n3"){};
		n0.addArc(new Arc("n0->n1",n1));
		n1.addArc(new Arc("n0->n1",n2));
		n2.addArc(new Arc("n0->n1",n3));
		graphLinear = n0;
		graphLinearOneNode = n2;
		
		
		n0 = new Node("n0"){};
		n1 = new Node("n1"){};
		n2 = new Node("n2"){};
		n3 = new Node("n3"){};
		n4 = new Node("n4"){};
		n0.addArc(new Arc("n0->n1",n1));
		n1.addArc(new Arc("n1->n2",n2));
		n1.addArc(new Arc("n1->n3",n3));
		n2.addArc(new Arc("n2->n4",n4));
		n3.addArc(new Arc("n3->n4",n4));
		graphCondition = n0;
		graphConditionOneNode = n2;
		
		n0 = new Node("n0"){};
		n1 = new Node("n1"){};
		n2 = new Node("n2"){};
		n3 = new Node("n3"){};
		n4 = new Node("n4"){};
		n5 = new Node("n5"){};
		n0.addArc(new Arc("n0->n1",n1));
		n1.addArc(new Arc("n1->n2",n2));
		n2.addArc(new Arc("n2->n3",n3));
		n3.addArc(new Arc("n3->n1",n1));
		n1.addArc(new Arc("n1->n4",n4));
		n4.addArc(new Arc("n4->n5",n5));
		graphCycle = n0;
		graphCycleOneNode = n5;
	}
	
	@Test
	public void testFindNodeLinearExists() throws IOException{
		Node n = graphLinear.findNode(graphLinearOneNode);
		assertNotNull(n);
		assertEquals(graphLinearOneNode, n);
	}
	
	@Test
	public void testFindNodeLinearNotExists() throws IOException{
		Node n = graphLinear.findNode(new Node("not exist"){});
		assertNull(n);
	}
	
	@Test
	public void testFindNodeConditionExists() throws IOException{
		Node n = graphCondition.findNode(graphConditionOneNode);
		assertNotNull(n);
		assertEquals(graphConditionOneNode, n);
	}
	
	@Test
	public void testFindNodeConditionNotExists() throws IOException{
		Node n = graphCondition.findNode(new Node("not exist"){});
		assertNull(n);
	}
	
	@Test
	public void testFindNodeCycleExists() throws IOException{
		Node n = graphCycle.findNode(graphCycleOneNode);
		assertNotNull(n);
		assertEquals(graphCycleOneNode, n);
	}
	
	@Test
	public void testFindNodeCycleNotExists() throws IOException{
		Node n = graphCycle.findNode(new Node("not exist"){});
		assertNull(n);
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
