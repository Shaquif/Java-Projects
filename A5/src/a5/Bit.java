package a5;

import java.util.Objects;

/**
 * A mutable bit.
 */
public class Bit implements Comparable<Bit> {
	private int value;

	/**
	 * Initializes this bit to 0.
	 */
	public Bit() {
		this.value = 0;
	}

	/**
	 * Initializes this bit to 0 if {@code value == 0}, otherwise initializes this
	 * bit to 1.
	 * 
	 * @param value the value of this bit
	 */
	public Bit(int value) {
		if (value == 0) {
			this.value = 0;
		} else {
			this.value = 1;
		}
	}

	/**
	 * Initializes this bit by copying the value of another bit.
	 * 
	 * @param other the bit to copy
	 */
	public Bit(Bit other) {
		this.value = other.value;
	}

	/**
	 * Returns a new {@code Bit} equal to 0.
	 * 
	 * @return a new {@code Bit} equal to 0
	 */
	public static Bit zero() {
		return new Bit();
	}

	/**
	 * Returns a new {@code Bit} equal to 1.
	 * 
	 * @return a new {@code Bit} equal to 1
	 */
	public static Bit one() {
		return new Bit(1);
	}

	/**
	 * Returns the value of this bit (0 or 1).
	 * 
	 * @return the value of this bit (0 or 1)
	 */
	public int value() {
		return this.value;
	}

	/**
	 * Flips the value of this bit.
	 */
	public void not() {
		if (this.value == 0) {
			this.value = 1;
		} else {
			this.value = 0;
		}
	}

	/**
	 * Sets the value of this bit to the logical AND of this bit with another bit.
	 * 
	 * @param other another bit
	 */
	public void and(Bit other) {
		if (this.value == 1 && other.value == 0) {
			this.value = 0;
		}
	}

	/**
	 * Sets the value of this bit to the logical OR of this bit with another bit.
	 * 
	 * @param other another bit
	 */
	public void or(Bit other) {
		if (this.value == 0 && other.value == 1) {
			this.value = 1;
		}
	}

	/**
	 * Returns a hash code for this bit.
	 * 
	 * @return a hash code for this bit
	 */
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	/**
	 * Compares this bit with an object for equality. This bit is equal to
	 * {@code obj} if and only if {@code obj} is a {@code Bit} having the same value
	 * as this bit.
	 * 
	 * @param obj an object to compare for equality
	 * @return {@code true} if this bit is equal to {@code obj}, {@code false}
	 *         otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Bit other = (Bit) obj;
		return value == other.value;
	}

	/**
	 * Returns {@code "0"} if this bit value is equal to 0 or {@code "1"} otherwise.
	 * 
	 * @return {@code "0"} if this bit value is equal to 0 or {@code "1"} otherwise
	 */
	@Override
	public String toString() {
		return "" + value;
	}

	/**
	 * Returns the difference between this bit's value and another bit's value.
	 * 
	 * @param other an object to compare for order
	 * @return the difference between this bit's value and another bit's value
	 */
	@Override
	public int compareTo(Bit other) {
		return this.value - other.value;
	}

}
