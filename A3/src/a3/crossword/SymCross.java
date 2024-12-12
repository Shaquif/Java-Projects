package a3.crossword;

import java.util.ArrayList;

import javax.script.CompiledScript;

import a3.dictionary.Dictionary;

/**
 * A class for creating 4x4 symmetric crossword puzzles. A symmetric crossword
 * is a crossword where the word in row i is equal to the word in column i where
 * i = 0, 1, 2, 3 are the indexes of the rows and columns. Words of the puzzle
 * are always in uppercase.
 * 
 * <p>
 * To use this class, one creates a new {@code SymCross} object using the
 * no-argument constructor which initializes the crossword so that all of the
 * words are {@code XXXX}. This creates a symmetric crossword, but not a
 * complete crossword. A complete crossword is a symmetric crossword where all
 * of the words are 4-letter English words contained in a {@code Dictionary}
 * object.
 * 
 * <p>
 * To create a complete crossword, one adds words to the crossword using the
 * {@code setWord} method until the crossword is complete. {@code setWord} does
 * not enforce the symmetry property of the crossword; it is the responsibility
 * of the user to confirm that the crossword is symmetric and complete (perhaps
 * with the help of the {@code isSymmetric} and {@code isComplete} methods).
 * 
 * <p>
 * Alternatively, one may ask the class to create a crossword by specifying the
 * first word of the crossword (the word in the first row) using the static
 * method {@code makeCrossword}. This method searches a {@code Dictionary} for
 * words that satisfy the symmetry property of the crossword. Some starting
 * words do not lead to a complete crossword.
 *
 */
public class SymCross {

	/**
	 * A static dictionary used by all instances of the class.
	 */
	private static Dictionary dict = new Dictionary();

	/**
	 * The list of words in this puzzle stored in row order (word in the first row
	 * of the puzzle is the first in the list).
	 */
	private  ArrayList<String> words;

	private String[] crossword;

	/**
	 * Initializes this crossword so that all four words are "XXXX".
	 */
	public SymCross() {
		crossword = new String[4];
		for(int i = 0; i < crossword.length;i++){
				crossword[i] = "XXXX";
			}
		
	}

	/*
	 * Add the required constructors and methods after this comment.
	 */

	public SymCross(SymCross other) {
		crossword = new String[other.crossword.length];
		for(int i = 0; i < other.crossword.length; i++) {
			crossword[i] = other.crossword[i];
			}
	}
	
	public void setWord(int row,String word) {
		if(row < 0 || row > 3) {
			throw new IllegalArgumentException("Row index not valid");
		}
		if(word.length() != 4) {
			throw new IllegalArgumentException("Word lenght not 4");
		}
		
		word = word.toUpperCase();
		crossword[row] = word;
	}
	
	public String getRow(int row) {
		if(row < 0 || row > 3) {
			throw new IllegalArgumentException("Row index not valid");
		}
		String word = crossword[row];
		return word;
	}
	
	public String getColumn(int col) {
		if(col < 0 || col > 3) {
			throw new IllegalArgumentException("Column index not valid");
		}
		String word = "";
		for(int i = 0; i < 4; i++) {
			word += crossword[i].charAt(col);
		}
		return word;
	}
	
	public boolean isSymmetric() {
		for(int i = 0; i < crossword.length;i++) {
			String wordRow = crossword[i];
			String wordCol = "";
			for(int j = 0; j < crossword.length;j++) {
				wordCol += crossword[j].charAt(i);
			}
			if(!wordRow.equals(wordCol)) {
				return false;
			}
		
		}
		return true;
	}
	
	public boolean isComplete() {
		if(!isSymmetric()) {
			return false;
		}
		for(int i = 0; i < crossword.length;i++) {
			String word = crossword[i];
			if(!dict.contains(word)) {
				return false;
				
			}
		}
		return true;
	}
	
		public static SymCross makeCrossword(String first) {
	    SymCross crossword = new SymCross();
	    crossword.setWord(0, first);

	    for (String second : dict.startsWith(String.valueOf(first.charAt(1)))) {
	        if (second.charAt(0) == first.charAt(1)) {
	            crossword.setWord(1, second);

	            for (String third : dict.startsWith(String.valueOf(first.charAt(2)))) {
	                if (third.charAt(0) == first.charAt(2) && third.charAt(1) == second.charAt(2)) {
	                    crossword.setWord(2, third);

	                    for (String fourth : dict.startsWith(String.valueOf(first.charAt(3)))) {
	                        if (fourth.charAt(0) == first.charAt(3) && fourth.charAt(1) == second.charAt(3) && fourth.charAt(2) == third.charAt(3)) {
	                            crossword.setWord(3, fourth);

	                            if (crossword.isComplete() && crossword.isSymmetric()) {
	                                return crossword;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }

	    
	    return crossword;
		}

	
	public String toString() {
		String result = "";
		for(int i = 0; i < crossword.length;i++) {
			result += crossword[i];
			if(i<crossword.length) {
				result = "\n";
			}
		}
		return result;
	}


	/**
	 * For testing purposes. Students are encouraged to modify this method to
	 * further test their code.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		String first = "blue";
		SymCross cw = SymCross.makeCrossword(first.toUpperCase());
		if (cw.isComplete()) {
			for (int i = 0; i < 4; i++) {
				System.out.println(cw.getRow(i));
			}
		} else {
			System.out.println("no crossword starting with " + first + " exists");
		}

	}

}




