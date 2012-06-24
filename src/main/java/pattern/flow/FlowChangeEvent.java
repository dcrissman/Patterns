package pattern.flow;

/**
 * Event indicating that the state (or position) of the {@link Flow} has changed.
 * 
 * @author Dennis Crissman
 *
 * @param <T>
 */
public interface FlowChangeEvent<T> {
	
	/**
	 * @return the node being moved away from.
	 */
	T getPreviousNode();
	
	/**
	 * @return the node being moved too.
	 */
	T getDestinationNode();
	
}
