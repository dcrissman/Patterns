package pattern.flow;

/**
 * {@link FlowListener}s can be added to implementations of {@link DefaultFlow} to be notified when
 * the state (or position) of the {@link Flow} changes.
 * 
 * @author Dennis Crissman
 *
 * @param <T>
 */
public interface FlowListener<T> {
	
	/**
	 * Notification that the state of the {@link Flow} has changed.
	 * @param event - {@link FlowChangeEvent}
	 */
	public void onFlowChange(FlowChangeEvent<T> event);
	
}
