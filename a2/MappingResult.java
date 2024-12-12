package a2;

/**
 * Stores the result of attempting to map a character or characters from a
 * Hawaiian word to its English pronunciation.
 * 
 * <p>
 * If the mapping exists, then the English pronunciation is stored in the field
 * {@code value} and the number of characters consumed from the word is stored
 * in {@code charsConsumed}.
 * 
 * <p>
 * If no mapping exists, then {@code value} may be set to {@code null} and
 * {@code charsConsumed} may be set to {@code 0}.
 */
public class MappingResult {
	/**
	 * The English pronunciation obtained by mapping a character or characters from
	 * a Hawaiian word.
	 */
	public String value;

	/**
	 * The number of characters consumed from the Hawaiian word to obtain the
	 * mapping.
	 */
	public int charsConsumed;

	/**
	 * Initializes a mapping result so that {@code value} is equal to {@code null}
	 * and {@code charsConsumed} is equal to {@code 0}.
	 */
	public MappingResult() {
		this.value = null;
		this.charsConsumed = 0;
	}
}
