package a2;

import java.util.Random;

public class Waltz {
	
	/**
	 * The number of precomposed musical fragments making up a minuet
	 * sequence.
	 */
	public static final int MINUET_SEQUENCE_LENGTH = 16;

	/**
	 * The number of precomposed musical fragments making up a trio
	 * sequence.
	 */
	public static final int TRIO_SEQUENCE_LENGTH = 16;
	
	/**
	 * The available instrument recordings. 
	 */
	public static final String[] INSTRUMENTS = {
			"clarinet",
			"flute-harp",
			"mbira",
			"piano",
	};

	/**
	 * The random number generator used by this class.
	 */
	public static final Random RNG = new Random();

	/**
	 * Returns the full pathname for the musical fragment specified by
	 * {@code filename}.
	 * 
	 * <p>
	 * For minuets, {@code filename} is assumed to have the form
	 * <i>instrument</i>{@code /minuet}<i>i</i>{@code -}<i>s</i> where
	 * <i>instrument</i> is the name of an instrument found in {@code INSTRUMENTS},
	 * <i>i</i> is the position of the fragment in the sequence, and <i>s</i> is the
	 * sum obtained by rolling two standard 6-sided dice.
	 * 
	 * <p>
	 * For trios, {@code filename} is assumed to have the form
	 * <i>instrument</i>{@code /trio}<i>i</i>{@code -}<i>v</i> where
	 * <i>instrument</i> is the name of an instrument found in {@code INSTRUMENTS},
	 * <i>i</i> is the position of the fragment in the trio and <i>v</i> is the
	 * value obtained by rolling one standard 6-sided dice.
	 * 
	 * @param filename the name of a minuet or trio fragment as specified above
	 * @return the full pathname to the audio file for the fragment
	 */
	public static String toPathname(String filename) {
		return System.getProperty("user.dir") + "/mozart/" + filename + ".wav";
	}


	
	public static int roll(int n) {
		// ...
		if (n<=0) {
			return 0;
		}
		return RNG.nextInt(6) + 1;
		
		
	}
	

	public static boolean hasInstrument(String instrument) {
		//...
		for( int i = 0; i < INSTRUMENTS.length;i++) {
			if(INSTRUMENTS[i] == instrument) {
				return true;
			}
		}
		return false;

	}


	public static String[] makeMinuet(String instrument) {
		// ...
		if(!hasInstrument(instrument)) {
			throw new IllegalArgumentException("Instrument not in list");
		}
		
		String[] minuet = new String[MINUET_SEQUENCE_LENGTH];
		
		for(int i = 0; i < minuet.length;i++) {
			int sum = roll(1) + roll(1);
			String fragment = instrument + "/minuet" + (i+1) + "-" + sum;
			minuet[i] = fragment;
		}
		return minuet;
	}
	

	public static String[] makeTrio(String instrument) {
		// ...
		if(!hasInstrument(instrument)) {
			throw new IllegalArgumentException("Instrument not in list");
		}
		
		String[] trio = new String[TRIO_SEQUENCE_LENGTH];
		
		for(int i = 0; i < trio.length;i++) {
			int sum = roll(1);
			String fragment = instrument + "/trio" + (i+1) + "-" + sum;
			trio[i] = fragment;
		}
		return trio;
	}
	
	
	

	public static String[] makeRandomMinuet() {
		// ...
		int randomIndex = RNG.nextInt(INSTRUMENTS.length);
		String randomInstrument = INSTRUMENTS[randomIndex];
		
		String[] randomMinuet = new String[MINUET_SEQUENCE_LENGTH];
		
		for(int i = 0; i < randomMinuet.length;i++) {
			int sum = roll(1) + roll(1);
			String fragment = randomInstrument + "/minuet" + (i+1) + "-" + sum;
			randomMinuet[i] = fragment;
		}
		return randomMinuet;
	}


	public static String[] makeRandomTrio() {
		// ...
		int randomIndex = RNG.nextInt(INSTRUMENTS.length);
		String randomInstrument = INSTRUMENTS[randomIndex];
		
		String[] randomTrio = new String[TRIO_SEQUENCE_LENGTH];
		
		for(int i = 0; i < randomTrio.length;i++) {
			int sum = roll(1);
			String fragment = randomInstrument + "/trio" + (i+1) + "-" + sum;
			randomTrio[i] = fragment;
		}
		return randomTrio;
	}


	/**
	 * Plays a waltz on a piano.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		String[] minuet = Waltz.makeMinuet("mbira");
		String[] trio = Waltz.makeTrio("mbira");
		String[] randomMinuet = Waltz.makeRandomMinuet();
		String[] randomTrio = Waltz.makeRandomTrio();
		
		/*for (String f : minuet) {
			StdAudio.play(toPathname(f));
		}
		for (String f : trio) {
			StdAudio.play(toPathname(f));
		}*/
		
		for (String f : randomMinuet) {
			StdAudio.play(toPathname(f));
		}
	}

}
