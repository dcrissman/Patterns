package pattern.node;

/**
 * Basic implementation of {@link Node}.
 * 
 * @author Dennis Crissman
 *
 * @param <T> target
 */
public class BasicNode<T> implements Node<T> {
	
	private T value;
	
	/**
	 * @see Node#getValue()
	 */
	@Override
	public T getValue() {
		return value;
	}
	
	/**
	 * Sets the target value.
	 * @param value - T
	 */
	public void setValue(T value){
		this.value = value;
	}

}
