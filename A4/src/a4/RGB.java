package a4;

import java.awt.Color;
import java.util.Objects;

import javax.lang.model.type.NullType;

/**
 * Basic implementation of a class that represents color values using a 24-bit
 * integer red-green-blue (RGB) representation.
 */
public class RGB implements Comparable<RGB> {
	/* 
	 * ADD YOUR NON-STATIC FIELDS HERE. THEY SHOULD ALL HAVE private ACCESS.
	 */
/**
 * Three color channels red,blue,green
 */
	private int blue;
	private int red;
	private int green;

	
	
	
	/* 
	 * ADD YOUR PUBLIC STATIC FIELDS HERE.
	 */
	
	/**
	 * Maximum color channel value
	 * Minimum color channel value
	 */
	static final int MAX_VALUE =255;
	static final int MIN_VALUE = 0;
	
	
	
	/**
	 * IMPLEMENTED FOR YOU.
	 * 
	 * Throws {@code ChannelValueOutOfRangeException} if {@code v} is out of range.
	 * 
	 * @param v a channel value to test
	 */
	private void testValue(int v) {
		if (v < MIN_VALUE) {
			throw new ChannelValueOutOfRangeException(v + " < " + MIN_VALUE);
		}
		if (v > MAX_VALUE) {
			throw new ChannelValueOutOfRangeException(v + " > " + MAX_VALUE);
		}
	}
	
	
	/*
	 * ADD YOUR CONSTRUCTORS HERE. THERE SHOULD BE 3 CONSTRUCTORS IN TOTAL.
	 */
	
	/**
	 * Initializes this color so that all channel values are zero.
	 */
	public RGB() {
		this.red = 0;
		this.green = 0;
		this.blue = 0;
		
	}
	
	/**
	 * Initializes this color to the specified red, green, and blue channel values.
	 * @param red
	 * @param blue
	 * @param green
	 * @throws ChannelValueOutOfRangeException - if any color channel value is out of 
	 * 											 range (less than RGB.MIN_VALUE or greater than RGB.MAX_VALUE
	 */
	
	public RGB(int red, int blue, int green) {
		if(red < MIN_VALUE || red > MAX_VALUE || blue < MIN_VALUE || blue > MAX_VALUE || green < MIN_VALUE || green > MAX_VALUE) {
			throw new ChannelValueOutOfRangeException("Colors out of bounds");
		}
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	/**
	 * Initializes this color by copying the color channel values from another color.
	 * @param other
	 */
	public RGB(RGB other) {
		this.red = other.red;
		this.green = other.green;
		this.blue = other.blue;
	}
	
	
	/*
	 * ADD YOUR METHODS HERE. THERE SHOULD BE 11 PUBLIC METHODS IN TOTAL.
	 */
	
	/**
	 * Returns the red channel value for this color.
	 * @return the red channel value for this color
	 */
	public int red() {
		return red;
	}
	
	/**
	 * Returns the green channel value for this color.
	 * @return the green channel value for this color
	 */
	public int green() {
		return green;
	}
	
	/**
	 * Returns the blue channel value for this color.
	 * @return the blue channel value for this color
	 */
	public int blue() {
		return blue;
	}
	
	/**
	 * Sets the red channel value for this color returning the previous value
	 * @param r - the new red channel value for this color
	 * @return the old red channel value for this color
	 */
	public int red(int r) {
		testValue(r);
		int previousRed = red;
		red = r;
		return previousRed;
	}
	
	/**
	 * Sets the green channel value for this color returning the previous value.
	 * @param g - the new green channel value for this color
	 * @return the old green channel value for this color
	 */
	public int green(int g) {
		testValue(g);
		int previousGreen = green;
		green = g;
		return previousGreen;
	}
	
	/**
	 * Sets the blue channel value for this color returning the previous value.
	 * @param b - the new blue channel value for this color
	 * @return the old blue channel value for this color
	 */
	public int blue(int b) {
		testValue(b);
		int previousBlue = blue;
		blue = b;
		return previousBlue;
	}
	
	/**
	 * Returns the approximate luminance of this color.
	 * @return the approximate luminance of this color
	 */
	public double luminance() {
		double r = Math.pow(red/255.0, 2.2);
		double g = Math.pow(green/255.0, 2.2);
		double b = Math.pow(blue/255.0,2.2);
		
		return (0.2126*r) + (0.7152*g) + (0.0722 *b);
	}
	
	/**
	 * Compares this color to another color by their luminance values.
	 * @return the value 0 if both colors have equal luminance values; a negative value if this color has a 
	 * lesser luminance value than the other color; a positive value if 
	 * this color has a greater luminance than the other color
	 * 
	 * @Override
	 */
	public int compareTo(RGB other) {
		double color = this.luminance();
		double otherColor = other.luminance();
		
		if(color == otherColor) {
			return 0;
		}
		
		else if(color < otherColor) {
			return -1;
		}
		
		else {
			return 1;
		}
	}
	
	/**
	 * Returns a hash code for this color.
	 * @return a hash code for this color
	 * 
	 * @Override
	 */
	public int hashCode() {
		return Objects.hash(red,green,blue);
	}
	
	/**
	 * Compares this color to another color for equality. 
	 * This color is equal to obj if and only if obj is an RGBColor 
	 * reference and both colors have equal red, green, and blue channel values.
	 * @param obj - an object to compare to this color
	 * @return true if this color is equal to obj, false otherwise.
	 * 
	 * @Override
	 */
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null) {
			return false;
		}
		
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		RGB other = (RGB) obj;
		return (this.red == other.red) && (this.green == other.green) && (this.blue == other.blue);
		

	}
	
	/**
	 * Returns a string representation of this color. The returned string has 
	 * the format: [r, g, b]
	 * where r, g, and b are the red, green, and blue channel values of this color.
	 * @return a string representation of this color
	 * 
	 * @Override
	 */
	public String toString() {
		return "[" + red + "," + green + "," + blue + "]";
	}
}