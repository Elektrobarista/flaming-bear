//package exerciseSheet04.exercise01;

/**
 * Exception as wished by the exercise sheet. Constructors as usual for exceptions
 * @author Chrisi#
 *
 */
public class InvalidPolygonException extends RuntimeException {
	
	public InvalidPolygonException() {
		super();
	}
	
	public InvalidPolygonException(String message) {
		super(message);
	}
	
	public InvalidPolygonException(String message, Throwable cause) {
		super(message, cause);
	}

}
