package pattern.node;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pattern.dummy.Banana;

public class TestBasicNode {
	
	@Test
	public void testValue(){
		BasicNode<Banana> bNode = new BasicNode<Banana>();
		Banana b = new Banana();
		
		bNode.setValue(b);
		
		assertEquals(b, bNode.getValue());
	}
	
}
