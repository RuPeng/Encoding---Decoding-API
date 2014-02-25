package ie.gmit;

/**
 * The class includes the exceptions for path error test.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */

public class PathException extends Exception {

	private static final long serialVersionUID = 1L;

	public PathException() {
		super();
	}

	public PathException(String message, Throwable cause) {
		super(message, cause);
	}

	public PathException(String message) {
		super(message);
	}

}
