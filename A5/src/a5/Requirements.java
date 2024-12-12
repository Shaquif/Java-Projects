package a5;

import java.util.ArrayList;
import java.util.List;

public class Requirements {

	/**
	 * A method using the required features of the UBinary class.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		// 10-bit binary number with all zeros
		UBinary b = new UBinary(10);
		System.out.println("b                    : " + b.toString());
		System.out.println("b.numberOfBits()     : " + b.numberOfBits());
		System.out.println("b.getLeftMostBit()   : " + b.getLeftMostBit());
		System.out.println("b.getRightMostBit()  : " + b.getRightMostBit());
		System.out.println("b.toDecimal()        : " + b.toDecimal());
		System.out.println();

		// change the bit returned by getLeftMostBit
		Bit z = b.getLeftMostBit();
		System.out.println("Bit z = b.getLeftMostBit();");
		System.out.println("z                    : " + z);
		z.not();
		System.out.println("z after z.not()      : " + z);
		System.out.println("Is b unchanged after modifying z?");
		System.out.println("b                    : " + b.toString());
		System.out.println();

		// change the bit returned by getRightMostBit
		z = b.getRightMostBit();
		System.out.println("z = b.getRightMostBit();");
		System.out.println("z                    : " + z);
		z.not();
		System.out.println("z after z.not()      : " + z);
		System.out.println("Is b unchanged after modifying z?");
		System.out.println("b                    : " + b.toString());
		System.out.println();

		List<Bit> bits = new ArrayList<>();
		bits.add(Bit.one());
		bits.add(Bit.one());
		bits.add(Bit.one());
		bits.add(Bit.zero());

		UBinary b1 = new UBinary(bits);
		System.out.println("b1                   : " + b1.toString());
		System.out.println("b1.numberOfBits()    : " + b1.numberOfBits());
		System.out.println("b1.toDecimal()       : " + b1.toDecimal());
		System.out.println();
		
		UBinary not1 = b1.not();
		System.out.println("b1                   : " + b1.toString());
		System.out.println("not1                 : " + not1.toString());
		System.out.println("not1.toDecimal()     : " + not1.toDecimal());
		System.out.println();

		UBinary shift1 = b1.shiftRight();
		System.out.println("b1                   : " + b1.toString());
		System.out.println("shift1               : " + shift1.toString());
		System.out.println("shift1.toDecimal()   : " + shift1.toDecimal());
		System.out.println();

		UBinary b2 = new UBinary(b1);
		System.out.println("b2 copy of b1       : " + b2.toString());
		System.out.println("b2.equals(b1)       : " + b2.equals(b1));
		System.out.println("b2.compareTo(b1)    : " + b2.compareTo(b1));
		System.out.println();

		List<Bit> bits3 = new ArrayList<>();
		bits3.add(Bit.zero());
		bits3.add(Bit.zero());
		bits3.add(Bit.zero());
		bits3.add(Bit.zero());
		bits3.add(Bit.one());
		bits3.add(Bit.one());
		bits3.add(Bit.one());
		UBinary b3 = new UBinary(bits3);
		System.out.println("b3                  : " + b3.toString());
		System.out.println("b3.equals(b2)       : " + b3.equals(b2));
		System.out.println("b2.compareTo(b1)    : " + b3.compareTo(b2));
		List<Bit> t = b3.getBits();
		System.out.println("t = b3.getBits()    : " + t);
		t.clear();
		System.out.println("t.clear(); t=       : " + t);
		System.out.println("b3                  : " + b3.toString());
		System.out.println();

		UBinary b4 = new UBinary(b3);
		System.out.println("b4 copy of b3       : " + b4.toString());
		b4.not();
		System.out.println("b4.not()            : " + b4.toString());
		System.out.println("b4.equals(b3)       : " + b4.equals(b3));
		System.out.println("b4.compareTo(b3)    : " + b4.compareTo(b3));
		System.out.println("b3.compareTo(b4)    : " + b3.compareTo(b4));
		System.out.println();

		try {
			// make a binary number having zero bits
			new UBinary(0);
		} catch (Exception x) {
			System.out.println(x);
		}
		try {
			// make a binary number having zero bits from a list
			new UBinary(new ArrayList<Bit>());
		} catch (Exception x) {
			System.out.println(x);
		}
		System.out.println();

		// binary numbers with lots of bits
		List<Bit> manyBits = new ArrayList<>();
		// 31 1s
		for (int i = 0; i < 31; i++) {
			manyBits.add(Bit.one());
		}

		// b5 is the binary representation of Integer.MAX_VALUE
		UBinary b5 = new UBinary(manyBits);
		System.out.println("b5                  : " + b5.toString());
		System.out.println("b5.toDecimal()      : " + b5.toDecimal());
		System.out.println("Integer.MAX_VALUE   : " + Integer.MAX_VALUE);
		System.out.println();

		// adding 1 to b5 produces the binary number made up of
		// 1 followed by 31 0s
		manyBits.clear();
		manyBits.add(Bit.one());
		for (int i = 0; i < 31; i++) {
			manyBits.add(Bit.zero());
		}
		UBinary b6 = new UBinary(manyBits);
		System.out.println("b6                  : " + b6.toString());
		// b6.toDecimal overflows, return -1 instead
		System.out.println("b6.toDecimal()      : " + b6.toDecimal());
		System.out.println();

		// binary number equal to b6 but having more bits
		manyBits.add(0, Bit.zero());
		manyBits.add(0, Bit.zero());
		manyBits.add(0, Bit.zero());
		UBinary b7 = new UBinary(manyBits);
		System.out.println("b7                  : " + b7.toString());
		System.out.println("b7.equals(b6)       : " + b7.equals(b6));
		System.out.println("b7.compareTo(b6)    : " + b7.compareTo(b6));
		System.out.println();

		// binary number not equal to b7
		manyBits.set(10, Bit.one());
		UBinary b8 = new UBinary(manyBits);
		System.out.println("b8                  : " + b8.toString());
		System.out.println("b8.equals(b7)       : " + b8.equals(b7));
		System.out.println("b8.compareTo(b7)    : " + b8.compareTo(b7));
		System.out.println();
	}
}
