package pattern.flow;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of {@link Flow}.<br>
 * <br>
 * Additionally {@link FlowListener}s can be added to be notified when the position of the {@link Flow} changes.
 * 
 * @author Dennis Crissman
 *
 * @param <T>
 */
public class DefaultFlow<T> implements Flow<T> {

	/** Initial position of the flow, before it actually begins. */
	private final static int INITIAL_POSITION = -1;
	
	private final List<T> nodes = new ArrayList<T>();
	/** Current position within the flow */
	private int currentPosition = INITIAL_POSITION;
	private final List<FlowListener<T>> listeners = new ArrayList<FlowListener<T>>();
	
	/**
	 * Adds a node to this {@link Flow}
	 * @param node
	 */
	public void addNode(T node){
		nodes.add(node);
	}
	
	/**
	 * Removes a node from this {@link Flow}
	 * @param node
	 */
	public void removeNode(T node){
		nodes.remove(node);
	}
	
	/**
	 * @see Flow#next()
	 */
	@Override
	public T next() {
		int nextPosition = currentPosition + 1;
		
		if(nextPosition > lastNodePosition()){
			throw new FlowException("Already at last position in Flow.");
		}
		
		T node = nodes.get(nextPosition);
		jump(node);
		return node;
	}

	/**
	 * @see Flow#previous()
	 */
	@Override
	public T previous() {
		int previousPosition = currentPosition - 1;
		
		if(previousPosition < 0){
			throw new FlowException("Already at first position in Flow.");
		}
		
		T node = nodes.get(previousPosition);
		jump(node);
		return node;
	}

	/**
	 * @see Flow#jump(Object)
	 */
	@Override
	public void jump(T target) {
		T currentNode = null;
		if(currentPosition <= INITIAL_POSITION){
			currentPosition = 0;
		}
		else{
			currentNode = nodes.get(currentPosition);
		}
		
		currentPosition = nodes.indexOf(target);
		
		fireFlowChangeEvent(currentNode, target);
	}
	
	/**
	 * @see Flow#first()
	 */
	@Override
	public T first(){
		T node = nodes.get(0);
		jump(node);
		return node;
	}
	
	/**
	 * @see Flow#last()
	 */
	@Override
	public T last(){
		T node = nodes.get(lastNodePosition());
		jump(node);
		return node;
	}
	
	/**
	 * Indicates if the flow has started yet (or is it still positioned before the first position).
	 * @return <code>true</code> if the flow has started, otherwise <code>false</code>.
	 */
	public boolean hasStarted(){
		if(currentPosition == INITIAL_POSITION){
			return false;
		}
		return true;
	}
	
	/**
	 * @see Flow#isLast()
	 */
	@Override
	public boolean isLast() {
		if(currentPosition == lastNodePosition()){
			return true;
		}
		return false;
	}

	/**
	 * @see Flow#isFirst()
	 */
	@Override
	public boolean isFirst() {
		if(currentPosition == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Calculates the last position number for the current node set.
	 * @return current position
	 */
	private int lastNodePosition() {
		return nodes.size() - 1;
	}
	
	/**
	 * Adds a {@link FlowListener}
	 * @param listener - {@link FlowListener}
	 */
	public void addFlowListener(FlowListener<T> listener){
		listeners.add(listener);
	}
	
	/**
	 * Removes a {@link FlowListener}
	 * @param listener - {@link FlowListener}
	 */
	public void removeFlowListener(FlowListener<T> listener){
		listeners.remove(listener);
	}
	
	/**
	 * Fires {@link FlowChangeEvent}s.
	 * @param previousNode - Node being moved away from.
	 * @param destinationNode - Node being moved too.
	 */
	private void fireFlowChangeEvent(T previousNode, T destinationNode){
		for(FlowListener<T> listener : listeners){
			listener.onFlowChange(new FlowChangeEventImpl(previousNode, destinationNode));
		}
	}
	
	/**
	 * Basic implementation of {@link FlowChangeEvent}.
	 * 
	 * @author Dennis Crissman
	 */
	private class FlowChangeEventImpl implements FlowChangeEvent<T>{

		private T previousNode;
		private T destinationNode;
		
		public FlowChangeEventImpl(T previousNode, T destinationNode){
			this.previousNode = previousNode;
			this.destinationNode = destinationNode;
		}
		
		/**
		 * @see FlowChangeEvent#getPreviousNode()
		 */
		@Override
		public T getPreviousNode() {
			return previousNode;
		}
		
		/**
		 * @see FlowChangeEvent#getDestinationNode()
		 */
		@Override
		public T getDestinationNode() {
			return destinationNode;
		}
		
	}

}
