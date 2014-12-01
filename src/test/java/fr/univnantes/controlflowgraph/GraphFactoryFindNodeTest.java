package fr.univnantes.controlflowgraph;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import org.junit.Before;

public class GraphFactoryFindNodeTest {
	
	GraphFactory graphLinear = null;
	Node graphLinearOneNode = null;
	GraphFactory graphCondition = null;
	Node graphConditionOneNode = null;
	GraphFactory graphCycle = null;
	Node graphCycleOneNode = null;
	
	@Before
	public void setUp() throws Exception {
		Node n0,n1,n2,n3,n4,n5;
		
		graphLinear = new GraphFactory();
		n0 = graphLinear.makeInstruction("n0");
		n1 = graphLinear.makeInstruction("n1");
		n2 = graphLinear.makeInstruction("n2");
		n3 = graphLinear.makeInstruction("n3");
		n0.addArc(graphLinear.makeArc("n0->n1",n1));
		n1.addArc(graphLinear.makeArc("n0->n1",n2));
		n2.addArc(graphLinear.makeArc("n0->n1",n3));
		graphLinearOneNode = n2;
		
		
		graphCondition = new GraphFactory();
		n0 = graphCondition.makeInstruction("n0");
		n1 = graphCondition.makeInstruction("n1");
		n2 = graphCondition.makeInstruction("n2");
		n3 = graphCondition.makeInstruction("n3");
		n4 = graphCondition.makeInstruction("n4");
		n0.addArc(graphCondition.makeArc("n0->n1",n1));
		n1.addArc(graphCondition.makeArc("n1->n2",n2));
		n1.addArc(graphCondition.makeArc("n1->n3",n3));
		n2.addArc(graphCondition.makeArc("n2->n4",n4));
		n3.addArc(graphCondition.makeArc("n3->n4",n4));
		graphConditionOneNode = n2;
		
		
		graphCycle = new GraphFactory();
		n0 = graphCycle.makeInstruction("n0");
		n1 = graphCycle.makeInstruction("n1");
		n2 = graphCycle.makeInstruction("n2");
		n3 = graphCycle.makeInstruction("n3");
		n4 = graphCycle.makeInstruction("n4");
		n5 = graphCycle.makeInstruction("n5");
		n0.addArc(graphCycle.makeArc("n0->n1",n1));
		n1.addArc(graphCycle.makeArc("n1->n2",n2));
		n2.addArc(graphCycle.makeArc("n2->n3",n3));
		n3.addArc(graphCycle.makeArc("n3->n1",n1));
		n1.addArc(graphCycle.makeArc("n1->n4",n4));
		n4.addArc(graphCycle.makeArc("n4->n5",n5));
		graphCycleOneNode = n5;
	}
	
	@Test
	public void testFindNodeWithNull() throws IOException{
		Node n = graphLinear.findNode(null);
		assertNull(n);
	}
	
	@Test
	public void testFindNodeIdExists() throws IOException{
		Node n = graphLinear.findNode(graphLinearOneNode.getId());
		assertNotNull(n);
		assertEquals(graphLinearOneNode, n);
	}
	
	@Test
	public void testFindNodeIdNotExists() throws IOException{
		Node n = graphLinear.findNode((new Node("not exist"){}).getId());
		assertNull(n);
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
}