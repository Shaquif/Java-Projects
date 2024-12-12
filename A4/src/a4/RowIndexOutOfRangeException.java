package a4;

/**
 * Exception thrown when a column index is out of range for a given {@code RGBImage}
 * (less than zero or greater than or equal to the image width).
 */
public class RowIndexOutOfRangeException extends RuntimeException {

	/**
	 * Initializes this exception with the specified detail message.
	 * 
	 * @param msg the detail message
	 */
	public RowIndexOutOfRangeException(String msg) {
		super(msg);
	}
}
