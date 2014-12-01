package fr.univnantes.controlflowgraph;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import org.junit.Before;

public class GraphFactoryTest {
	
	GraphFactory gf;
	GraphFactory graphLinear = null;
	Node graphLinearOneNode = null;
	GraphFactory graphCondition = null;
	Node graphConditionOneNode = null;
	GraphFactory graphCycle = null;
	Node graphCycleOneNode = null;
	
	@Before
	public void setUp() throws Exception {
		gf = new GraphFactory();
	}
		
	/* *** Constructor tests *** */
	
	@Test
	public void testConstructor() throws IOException{
		GraphFactory gf = new GraphFactory();
		assertNotNull(gf);
		assertNotNull(gf.arcSet);
		assertNotNull(gf.nodeSet);
	}
	
	/* *** gf.makeArc(*) tests *** */
	
	@Test
	public void testMakeArcIdNameNext() throws IOException{
		int sizeBefore = gf.arcSet.size();
		Arc a = gf.makeArc(1, "a", new Node(""){});
		assertNotNull(a);
		assertEquals(sizeBefore+1,gf.arcSet.size());
	}
	
	@Test
	public void testMakeArcNameNext() throws IOException{	
		int sizeBefore = gf.arcSet.size();
		Arc a = gf.makeArc("a", new Node(""){});
		assertNotNull(a);
		assertEquals(sizeBefore+1,gf.arcSet.size());
	}
	
	/* *** gf.makeCondition(*) test *** */
	
	@Test
	public void testMakeConditionIdName() throws IOException{
		int sizeBefore = gf.nodeSet.size();
		Condition n = gf.makeCondition(1,"");
		assertNotNull(n);
		assertEquals(sizeBefore+1,gf.nodeSet.size());
	}
	
	@Test
	public void testMakeConditionId() throws IOException{
		int sizeBefore = gf.nodeSet.size();
		Condition n = gf.makeCondition(1);
		assertNotNull(n);
		assertEquals(sizeBefore+1,gf.nodeSet.size());
	}
	
	@Test
	public void testMakeConditionName() throws IOException{
		int sizeBefore = gf.nodeSet.size();
		Condition n = gf.makeCondition("");
		assertNotNull(n);
		assertEquals(sizeBefore+1,gf.nodeSet.size());
	}
	
	@Test
	public void testMakeConditionEmpty() throws IOException{
		int sizeBefore = gf.nodeSet.size();
		Condition n = gf.makeCondition();
		assertNotNull(n);
		assertEquals(sizeBefore+1,gf.nodeSet.size());
	}
	
	/* *** gf.makeInstruction(*) tests *** */
	
	@Test
	public void testMakeInstructionIdNameValue() throws IOException{
		int sizeBefore = gf.nodeSet.size();
		Instruction n = gf.makeInstruction(1,"n","v");
		assertNotNull(n);
		assertEquals(sizeBefore+1,gf.nodeSet.size());
	}
	
	@Test
	public void testMakeInstructionNameValue() throws IOException{
		int sizeBefore = gf.nodeSet.size();
		Instruction n = gf.makeInstruction("n","v");
		assertNotNull(n);
		assertEquals(sizeBefore+1,gf.nodeSet.size());
	}
	
	@Test
	public void testMakeInstructionIdValue() throws IOException{
		int sizeBefore = gf.nodeSet.size();
		Instruction n = gf.makeInstruction(1,"v");
		assertNotNull(n);
		assertEquals(sizeBefore+1,gf.nodeSet.size());
	}
	
	@Test
	public void testMakeInstructionValue() throws IOException{
		int sizeBefore = gf.nodeSet.size();
		Instruction n = gf.makeInstruction("v");
		assertNotNull(n);
		assertEquals(sizeBefore+1,gf.nodeSet.size());
	}
	
	/* *** findNode(*) tests *** */

}