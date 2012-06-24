package pattern.flow;

/**
 * Exception that occurs when a problem arises during a {@link Flow}.
 * 
 * @author Dennis Crissman
 */
public class FlowException extends RuntimeException {

	private static final long serialVersionUID = 8075820557732570165L;

	public FlowException(String message) {
		super(message);
	}

	public FlowException(Throwable cause) {
		super(cause);
	}

	public FlowException(String message, Throwable cause) {
		super(message, cause);
	}

}
