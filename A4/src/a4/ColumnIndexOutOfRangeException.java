package a4;

/**
 * Exception thrown when a row index is out of range for a given {@code RGBImage}
 * (less than zero or greater than or equal to the image height).
 */
public class ColumnIndexOutOfRangeException extends RuntimeException {

	/**
	 * Initializes this exception with the specified detail message.
	 * 
	 * @param msg the detail message
	 */
	public ColumnIndexOutOfRangeException(String msg) {
		super(msg);
	}
}
