package pattern.node;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import pattern.dummy.Banana;

/**
 * Simple tests for {@link MultiNode}. No sense testing {@link List}.
 * 
 * @author Dennis Crissman
 */
public class TestMultiNode {
	
	@Test
	public void TestChildren(){
		MultiNode<Banana> bMultiNode = new MultiNode<Banana>();
		
		assertNotNull(bMultiNode.getChildren());
		assertTrue(bMultiNode.getChildren().isEmpty());
	}
	
}
