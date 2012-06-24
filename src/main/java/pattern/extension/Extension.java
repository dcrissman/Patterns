package pattern.extension;

/**
 * <p>An Extension is simply a class that extends the functionality of another.</p>
 * 
 * @author Dennis Crissman
 *
 * @param <T> - {@link Extensionable} class that this {@link Extension} extends.
 */
public interface Extension<T extends Extensionable<?>> {
	
	/**
	 * Returns the Key used to identify this {@link Extension} or this grouping of {@link Extension}s. There can
	 * only ever be one {@link Extension} with a given key.
	 * @return Object key
	 */
	Object getKey();
	
	/**
	 * Returns the target {@link Extensionable} instance that this {@link Extension} acts upon.
	 * @return {@link Extensionable}
	 */
	T getTarget();
	
}
