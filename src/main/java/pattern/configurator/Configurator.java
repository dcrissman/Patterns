package pattern.configurator;

/**
 * Represents a class who's sole purpose is to configure another. This class should contain
 * full knowledge of how the target object should be configured.
 * 
 * @author Dennis Crissman
 *
 * @param <T> - Object that can be configured.
 */
public interface Configurator<T> {
	
	/**
	 * Returns a boolean value indicating if this {@link Configurator} handles
	 * the passed in Object type.
	 * @param obj - Object being tested
	 * @return <code>true</code> if {@link Configurator} handles the passed in Object,
	 * otherwises <code>false</code>.
	 */
	boolean handles(Object obj);
	
	/**
	 * Configures the passed in target
	 * @param target - target to configure
	 */
	void configure(T target);
	
}
