package pattern.extension;

/**
 * Common logic that all {@link Extension}s will need.
 * 
 * @author Dennis Crissman
 *
 * @param <T> - {@link Extensionable} class that this {@link Extension} extends.
 */
public abstract class AbstractExtension<T extends Extensionable<?>> implements Extension<T>{
	
	private T target;
	
	/**
	 * @see Extension#getTarget()
	 */
	@Override
	public T getTarget() {
		return target;
	}
	
	/**
	 * Returns the targeted {@link Extensionable} instance.
	 * @param target - {@link Extensionable}
	 */
	public void setTarget(T target){
		this.target = target;
	}
	
	public AbstractExtension(){}
	
	public AbstractExtension(T target){
		setTarget(target);
	}

}
