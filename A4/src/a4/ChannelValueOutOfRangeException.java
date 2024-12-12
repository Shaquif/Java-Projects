package a4;

/**
 * Exception thrown when an {@code RGB} color channel value is out of range
 * (less than {@code RGB.MIN_VALUE} or greater than {@code RGB.MAX_VALUE}.
 */
public class ChannelValueOutOfRangeException extends RuntimeException {

	/**
	 * Initializes this exception with the specified detail message.
	 * 
	 * @param msg the detail message
	 */
	public ChannelValueOutOfRangeException(String msg) {
		super(msg);
	}
}
