package a3.dictionary;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * A simple dictionary of 4-letter English words that appear in the official
 * list of Scrabble words. This dictionary allows the user to test if a word
 * exists in the dictionary and allows the user to retrieve a list of all of the
 * words that start with a given string (for example, find all of the words that
 * start with "TH").
 *
 */
public class Dictionary {

	/**
	 * The list of words in this dictionary in sorted alphabetic order.
	 */
	private ArrayList<String> words;

	/**
	 * The list of 26 indexes in this.words for the first word starting with A, B,
	 * C, ... That is:
	 *
	 * indexOfLetter.get(0) is the index of the first word starting with A
	 * indexOfLetter.get(1) is the index of the first word starting with B
	 * indexOfLetter.get(2) is the index of the first word starting with C and so on
	 */
	private ArrayList<Integer> indexOfLetter;

	/**
	 * Initializes this dictionary according to the description in the assignment
	 * document.
	 */
	public Dictionary() {
		// Do not change the next two lines...
		this.words = new ArrayList<>();
		this.readFile();
		// Complete this constructor...
		this.indexOfLetter = new ArrayList<Integer>(26);

		for (int i = 0; i < indexOfLetter.size(); i++) {
			String word = words.get(i);
			char firstLetter =  word.charAt(0);

			if(firstLetter >= 'a' && firstLetter <= 'z') {
				int position = firstLetter - 'a';


				if(indexOfLetter.get(position) == -1) {
					indexOfLetter.set(position, i);
				}
			}
		}

	}

	/**
	 * Reads the words of this dictionary from the file found in words/four.txt
	 *
	 * <p>
	 * The words in the file are already in sorted alphabetic order.
	 *
	 * <p>
	 * ALREADY IMPLEMENTED FOR YOU.
	 */
	void readFile() {
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(), "words", "four.txt");
		String path = filePath.toString();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			stream.forEach(this.words::add);
		} catch (IOException ex) {
			throw new RuntimeException("error reading dictionary file");
		}
	}


	/*
	 * Add the required methods after this comment.
	 */

	public boolean contains(String word) {
		String convertToLowerCase = word.toLowerCase();
		for(int i = 0; i < words.size();i++) {
			if (words.get(i).toLowerCase().equals(convertToLowerCase)) {
				return true;
			}
		}
		return false;
	}

	int indexOf(int c) {
		if(c < 'A') {
			return 0 ;
		}
		if(c > 'Z') {
			return words.size();
		}

		char cToCharacter = (char) c;
		return indexOfLetter.get(cToCharacter);


	}

	public ArrayList<String> startsWith(String prefix){
		if(prefix.isEmpty()) {
			return new ArrayList<>(words);
		}

		ArrayList<String> matchingWords = new ArrayList<>();

		for(String word: words) {
			if(word.toLowerCase().startsWith(prefix.toLowerCase())) {
				matchingWords.add(word);
			}
		}
		return matchingWords;
	}


	/**
	 * For testing purposes. Students are encouraged to modify this method to
	 * further test their code.
	 *
	 * @param args not used
	 */
	public static void main(String[] args) {
		Dictionary d = new Dictionary();
		System.out.println("Contains \"SORT\"? " + d.contains("Ears"));
		System.out.println(d.startsWith("Tree"));
		System.out.println(d.startsWith("pok"));
		System.out.println(d.startsWith("x"));
   
 

	}
}