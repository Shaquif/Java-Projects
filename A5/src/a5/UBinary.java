package a5;

import java.util.List;
import java.util.Objects;

import javax.print.attribute.standard.MediaSize.Other;

import java.util.ArrayList;

/**
 * A class that represents an immutable binary number having no specified limits
 * on the number of bits.
 *
 */
public class UBinary {

	/**
	 * The bits of this binary number.
	 */
	private List<Bit> bits;
	
	/*
	 * SOME METHODS ALREADY PROVIDED FOR YOU:
	 */
	/**
	 * Returns a hash code for this binary number.
	 * 
	 * @return a hash code for this binary number
	 */
	
	@Override
	public int hashCode() {
		// this is incorrect, can you see why?
		// you don't need to fix this for the assignment
		return Objects.hash(this.bits);
	}

	/**
	 * Returns the decimal (base 10) value of this binary number as an
	 * <code>int</code> value, or -1 if the decimal value of this binary number
	 * cannot be represented using an <code>int</code>.
	 * 
	 * @return the decimal (base 10) value of this binary number, or -1 if the
	 *         decimal value of this binary number cannot be represented using an
	 *         int
	 */
	public int toDecimal() {
		long val = 0;
		for (int i = 0; i < this.bits.size(); i++) {
			int y = this.bits.size() - 1 - i;
			val += this.bits.get(i).value() * Math.pow(2, y);
			if (val > Integer.MAX_VALUE) {
				val = -1;
				break;
			}
		}
		return (int) val;
	}

	/**
	 * Returns a string representation of this binary number. The returned string is
	 * made up of the bit values (0 or 1) of the number from the left-most bit to
	 * the right-most bit.
	 * 
	 * @return a string representation of this binary number
	 */
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		for (Bit bit : this.bits) {
			b.append(bit.toString());
		}
		return b.toString();
	}
	
	
	/*
	 * YOUR CONSTRUCTORS AND METHODS SHOULD APPEAR AFTER THIS COMMENT. 
	 */
	
	public UBinary(int size) {
		if(size <= 0){
			throw new IllegalArgumentException("Binary number must have at least 1 bit");	
			}
		this.bits = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			this.bits.add(Bit.zero());
		}
	}
	
	public UBinary(UBinary other) {
		this.bits = new ArrayList<>();
		for(int i = 0; i < other.bits.size(); i++) {
			this.bits.add(new Bit(other.bits.get(i)));
		}
	}
	
	public UBinary(List<Bit> bits) {
		if(bits.isEmpty()) {
			throw new IllegalArgumentException("Binary number must have at least 1 bit");
		}
		
		this.bits = new ArrayList<>();
		for(int i = 0; i < bits.size(); i++) {
			Bit bit = bits.get(i);
			this.bits.add(new Bit(bit));
		}
	}
	
	public int numberOfBits() {
		if(bits.isEmpty()) {
			throw new IllegalArgumentException("Binary number must have at least 1 bit");
		}
		return bits.size();
	}
	
	public Bit getLeftMostBit() {
		if (bits.isEmpty()) {
			throw new IllegalArgumentException("Binary number must have at least 1 bit");
		}
		return new Bit(bits.get(0));
	}
	
	public Bit getRightMostBit() {
		if (bits.isEmpty()) {
			throw new IllegalArgumentException("Binary number must have at least 1 bit");
			}
		return new Bit(bits.get(bits.size()-1));
	}
	
	public ArrayList<Bit> getBits(){
		if(bits.isEmpty()) {
			throw new IllegalArgumentException("Binary number must have at least 1 bit");
		}
		return new ArrayList<>(bits);
	}
	
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
		UBinary other = (UBinary) obj;
		
		int indexBit1 = 0;
		for(int i = 0; i <this.bits.size();i++) {
			if(this.bits.get(i).value()!=0) {
				indexBit1 = i;
				break;
			}
		}
		
		int indexBit2 = 0;
		for(int i = 0; i < other.bits.size();i++) {
			if(other.bits.get(i).value() != 0) {
				indexBit2 = i;
				break;
			}
		}
		
		int newLenghth1 = this.bits.size() - indexBit1;
		int newLenght2 = other.bits.size() - indexBit2;
		
		if(newLenghth1 != newLenght2) {
			return false;
		}
		
		for(int i = 0; i < newLenghth1; i++) {
			if (!this.bits.get(indexBit1 + i).equals(other.bits.get(indexBit2 + i))) {
				return false;
			}
		}
		return true;
	}
	
	public int compareTo(UBinary other) {
		int decimal = this.toDecimal();
		int otherDecimal = other.toDecimal();
		
		if(decimal == otherDecimal) {
			return 0;
		}
		else if (decimal < otherDecimal) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	public UBinary not() {
		List<Bit> notBits = new ArrayList<>();
		for (Bit bit : bits) {
			Bit newBit = new Bit(bit);
			newBit.not();
			notBits.add(newBit);
		}
		return new UBinary(notBits);
	}
	
	public UBinary shiftRight() {
		List<Bit> shiftedRightBits = new ArrayList<>();
		shiftedRightBits.add(Bit.zero());
		for(int i = 0; i < bits.size() -1; i++) {
			shiftedRightBits.add(bits.get(i));
		}
		return new UBinary(shiftedRightBits);
	}
	
}
