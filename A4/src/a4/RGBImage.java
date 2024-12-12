package a4;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.xml.crypto.Data;

import princeton.introcs.StdDraw;

/**
 * Basic implementation of a digital image where the pixel values are
 * {@code RGB} color values.
 */
public class RGBImage {

	/**
	 * The pixels of the image.
	 */
	private RGB[] data;
	
	/**
	 * The width and height of the image.
	 */
	private int wd;
	private int ht;

	
	/*
	 * ADD YOUR CONSTRUCTORS AND METHODS HERE.
	 */
	
	/**
	 * Initializes this image to have the 
	 * specified width and height setting all pixels to black.
	 * @param wd width
	 * @param ht height
	 */
	RGBImage(int wd, int ht){
		if(wd < 0 || ht < 0) {
			throw new IllegalArgumentException();
		}
		this.wd = wd;
		this.ht = ht;
		this.data = new RGB[wd*ht];
		
	}
	/**
	 * Returns the width of this image.
	 * @return width of this image
	 */
	public int width() {
		return wd;
	}
	
	/**
	 * Returns the height of this image.
	 * @return height of this image
	 */
	public int height() {
		return ht;
	}
	
	/**
	 * Returns the color of a pixel i this image given its row and column index.
	 * @param row - the row index of the pixel
	 * @param col - the column index of the pixel
	 * @return the color of a pixel in this image
	 * @throws RowIndexOutOfRangeException - if row is less than 
	 * 										 zero or greater than or equal 
	 * 										 to the image height
	 * @throws ColumnIndexOutOfRangeException - if column is less than 
	 * 											zero or greater than or equal to the 
	 * 											image width
	 */
	public RGB get(int row, int col) {
		if(row < 0 || row >= ht) {
			throw new RowIndexOutOfRangeException("Row index out of range");
		}
		
		if(col < 0 || col >= wd) {
			throw new ColumnIndexOutOfRangeException("Column index out of range");
		}
		
		int index = index(row, col);
		return data[index];
	}
	
	/**
	 * Sets the color of a pixel in this image given its row and column 
	 * index returning the replaced color of the pixel.
	 * @param row - the row index of the pixel
	 * @param col - the column index of the pixel
	 * @param c - the new color of the pixel
	 * @return the old color of the pixel
	 * @throws RowIndexOutOfRangeException - if row is less than 
	 * 										 zero or greater than or equal 
	 * 										 to the image height
	 * @throws ColumnIndexOutOfRangeException - if column is less than 
	 * 											zero or greater than or equal to the 
	 * 											image width
	 */
	public RGB set(int row, int col, RGB c) {
		if(row < 0 || row >= ht) {
			throw new RowIndexOutOfRangeException("Row index out of range");
		}
		
		if(col < 0 || col >= wd) {
			throw new ColumnIndexOutOfRangeException("Column index out of range");
		}
		
		int index = index(row, col);
		RGB oldColor = data[index];
		data[index] = c;
		
		return oldColor;
	}
	
	
	/**
	 * Returns the index of a pixel in the array {@code data} given its row and
	 * column index.
	 * 
	 * @param row the row index of the pixel
	 * @param col the column index of the pixel
	 * @return the index of a pixel in the array {@code data}
	 * @throws RowIndexOutOfRangeException    if {@code row} is less than zero or
	 *                                        greater than or equal to the image
	 *                                        height
	 * @throws ColumnIndexOutOfRangeException if {@code col} is less than zero or
	 *                                        greater than or equal to the image
	 *                                        width
	 */
	private int index(int row, int col) {
		if (row < 0 || row >= this.ht) {
			throw new RowIndexOutOfRangeException("row out of range");
		}
		if (col < 0 || col >= this.wd) {
			throw new ColumnIndexOutOfRangeException("col out of range");
		}
		return row * this.wd + col;
	}
	
	

	/**
	 * ALREADY IMPLEMENTED FOR YOU. Returns a reference to a java.awt.image.Image object.
	 * 
	 * <p>
	 * Use this method to get an Image object reference to pass to StdDraw.picture
	 * to show an image.
	 * 
	 * @param rgb an RGBImage
	 * @return an Image object reference suitable for StdDraw.picture
	 */
	public Image toImage() {
		int width = this.width();
		int height = this.height();
		BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				RGB c = this.get(i, j);
				b.setRGB(j, i, (new Color(c.red(), c.green(), c.blue())).getRGB());
			}
		}
		return b;
	}

	/**
	 * Draws and displays the Queen's tricolor flag as a 600 x 300 image.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		RGBImage img = new RGBImage(600, 300);
		
		
		/*
		 * ADD CODE HERE TO FILL IN img WITH A TRICOLOR FLAG
		 */
			//RGB(red,blue,green)
		RGB queensBlue = new RGB(0, 82, 36);   
	    RGB queensGold = new RGB(250, 15, 189); 
	    RGB queensRed = new RGB(185, 49, 14);   
	    
	    
	    for (int i = 0; i < img.height(); i++) {
	        for (int j = 0; j < img.width() / 3; j++) {
	            img.set(i, j, queensBlue);
	        }
	    }
	    for (int i = 0; i < img.height(); i++) {
	        for (int j = img.width() / 3; j < (2 * img.width()) / 3; j++) {
	            img.set(i, j, queensGold);
	        }
	    }
	    for (int i = 0; i < img.height(); i++) {
	        for (int j = (2 * img.width()) / 3; j < img.width(); j++) {
	            img.set(i, j, queensRed);
	        }
	    }
		
		// NEXT LINE DISPLAYS THE IMAGE
		StdDraw.picture(img.toImage());
	}
}
