package pattern.flow;

/**
 * Represents a set of Objects that need to be acted upon in a particular order.
 * 
 * @author Dennis Crissman
 *
 * @param <T>
 */
public interface Flow<T> {
	
	/**
	 * Move to the next node in the {@link Flow}.
	 * @return next node
	 * @throws FlowException - if you cannot move any further forwards.
	 */
	T next();
	
	/**
	 * Moves to the previous node in the {@link Flow}.
	 * @return previous node
	 * @throws FlowException - if you cannot move any further backwards.
	 */
	T previous();
	
	/**
	 * Jumps to a position within the {@link Flow}
	 * @param target - Node to jump too.
	 */
	void jump(T target);
	
	/**
	 * Indicates if the current position is the last position in the {@link Flow}
	 * @return <code>true</code> if last position, otherwise <code>false</code>.
	 */
	boolean isLast();
	
	/**
	 * Indicates if the current postiion is the first postiion in the {@link Flow}
	 * @return <code>true</code> if the first position, otherwise <code>false</code>.
	 */
	boolean isFirst();
	
	/**
	 * Jump to the first node in the {@link Flow}.
	 * @return first node.
	 */
	T first();
	
	/**
	 * Jump to the last node in the {@link Flow}
	 * @return last node.
	 */
	T last();
}
