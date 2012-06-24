package pattern.extension;

/**
 * <p>Interface for Objects that can be extended.</p>
 * 
 * <p><b>NOTE:</b> An {@link Extensionable} can only be extended by {@link Extension}s that are specifically for
 * the {@link Extensionable}.</p>
 * 
 * @author Dennis Crissman
 *
 * @param <E>
 */
public interface Extensionable<E extends Extension<?>> {
	
	/**
	 * Adds an {@link Extension} to this {@link Extensionable}
	 * @param key - Object key to identify the {@link Extension}. This is useful when multiple implementations of a given 
	 * extension exist, but only should exist on the {@link Extensionable} at a time.
	 * @param extension - {@link Extension}
	 */
	void addExtension(Object key, E extension);
	
	/**
	 * Removes an {@link Extension} by Object key.
	 * @param key - Object
	 */
	void removeExtension(Object key);
	
	/**
	 * Returns a boolean indicating if an {@link Extension} exists on this {@link Extensionable} with the given Object key.
	 * @param key - Object key to look for.
	 * @return <code>true</code> if an {@link Extension} exists with the given Object key, otherwise <code>false</code>.
	 */
	boolean hasExtension(Object key);
	
	/**
	 * Returns a boolean indicating if the passed in {@link Extension} exists on this {@link Extensionable}.
	 * @param extension - {@link Extensionable} in question.
	 * @return <code>true</code> if the {@link Extension} exists, otherwise <code>false</code>.
	 */
	boolean hasExtension(E extension);
	
	/**
	 * Removes all {@link Extension}s from this {@link Extensionable}.
	 */
	void clearExtensions();
	
}
