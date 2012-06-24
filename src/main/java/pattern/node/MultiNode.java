package pattern.node;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple multiple node tree structure.
 * 
 * @author Dennis Crissman
 *
 * @param <T>
 */
public class MultiNode<T> extends BasicNode<T>{
	
	private List<MultiNode<T>> children = new ArrayList<MultiNode<T>>();
	
	public List<MultiNode<T>> getChildren(){
		return children;
	}
	
}
