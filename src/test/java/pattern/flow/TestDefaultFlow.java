package pattern.flow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pattern.dummy.Apple;
import pattern.dummy.Banana;
import pattern.dummy.Fruit;
import pattern.flow.mock.MockFlowListener;

public class TestDefaultFlow {
	
	private DefaultFlow<Fruit> flow;
	private Apple a = new Apple();
	private Banana b = new Banana();
	
	@Before
	public void init(){
		flow = new DefaultFlow<Fruit>();
		flow.addNode(a);
		flow.addNode(b);
	}
	
	@Test
	public void testNext(){
		assertEquals(a, flow.next());
		assertEquals(b, flow.next());
	}
	
	@Test(expected=FlowException.class)
	public void testNextTooFar(){
		assertEquals(a, flow.next());
		assertEquals(b, flow.next());
		flow.next();
	}
	
	@Test
	public void testIsFirst(){
		//Initial state is before the first position. See hasStarted();
		assertFalse(flow.isFirst());
		
		flow.next();
		
		assertTrue(flow.isFirst());
		
		flow.next();
		
		assertFalse(flow.isFirst());
	}
	
	@Test
	public void testIsLast(){
		assertFalse(flow.isLast());
		
		flow.last();
		
		assertTrue(flow.isLast());
	}
	
	@Test
	public void testHasStarted(){
		assertFalse(flow.hasStarted());
		flow.next();
		assertTrue(flow.hasStarted());
	}
	
	@Test
	public void testFirst(){
		flow.next();
		flow.next();
		assertFalse(flow.isFirst());
		
		assertEquals(a, flow.first());
	}
	
	@Test
	public void testLast(){
		assertEquals(b, flow.last());
	}
	
	@Test
	public void testPrevious(){
		flow.last();
		assertEquals(a, flow.previous());
	}
	
	@Test(expected = FlowException.class)
	public void testPreviousTooFar(){
		assertEquals(b, flow.last());
		assertEquals(a, flow.previous());
		flow.previous();
	}
	
	@Test
	public void testForFlowChangeEvent(){
		MockFlowListener listener = new MockFlowListener();
		flow.addFlowListener(listener);
		
		assertNull(listener.getEvent());
		
		flow.next();
		
		assertNotNull(listener.getEvent());
		assertNull(listener.getEvent().getPreviousNode());
		assertEquals(a, listener.getEvent().getDestinationNode());
		
		flow.next();
		assertNotNull(listener.getEvent());
		assertEquals(a, listener.getEvent().getPreviousNode());
		assertEquals(b, listener.getEvent().getDestinationNode());
	}
	
}
