package pattern.extension;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple implementation of {@link Extensionable}. The intention is that this class can either
 * be inherited from or used for composition.
 * 
 * @author Dennis Crissman
 *
 * @param <E>
 */
public class SimpleExtensionable<E extends Extension<?>> implements Extensionable<E> {
	
	private Map<Object, E> extensions = new HashMap<Object, E>();
	
	/**
	 * @see Extensionable#addExtension(Object, Extension)
	 */
	public void addExtension(Object key, E extension) {
		extensions.put(key, extension);
	}

	/**
	 * @see Extensionable#removeExtension(Object)
	 */
	public void removeExtension(Object key) {
		extensions.remove(key);
	}

	/**
	 * @see Extensionable#hasExtension(Object)
	 */
	public boolean hasExtension(Object key) {
		return extensions.containsKey(key);
	}
	
	/**
	 * @see Extensionable#hasExtension(Extension)
	 */
	public boolean hasExtension(E extension){
		return extensions.containsValue(extension);
	}

	/**
	 * @see Extensionable#clearExtensions()
	 */
	public void clearExtensions() {
		extensions.clear();
	}

}
