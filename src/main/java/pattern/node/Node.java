package pattern.node;

/**
 * A Node contains some value T
 * 
 * @author Dennis Crissman
 *
 * @param <T> value
 */
public interface Node<T> {
	
	/**
	 * @return target value
	 */
	T getValue();
	
}
