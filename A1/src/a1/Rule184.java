package a1;

import java.util.Random;


public class Rule184 {

	public static void printCells(boolean[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]) {
				System.out.print("C");
				
			}
			else {
				System.out.print("-");
			}
		}
		
		
		
	}

	// ADD AND COMPLETE THE REMAINING METHODS AFTER THIS COMMENT
	
	public static void fill(boolean[] arr, double density) {
		if(density < 0.0) {
			throw new IllegalArgumentException("density < 0.0");
		}
		if(density > 1.0) {
			throw new IllegalArgumentException("density > 1.0");
		}
		int nTrue = (int) Math.round(density * arr.length);
		
		for (int i = 0; i < nTrue; i++) {
			arr[i] = true;
		}
		
		for (int i = nTrue; i < arr.length; i++) {
			arr[i] = false;
		}
	}
	
	
	public static void randomFill(boolean[] arr) {
		Random rng = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rng.nextBoolean();
		}
	}
	
	public static void shuffle(boolean[] arr) {
		Random random = new Random();
		for (int i = arr.length-1; i > 0; i--) {
			int j = random.nextInt(i+1);
			boolean temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
		
	}
	
	public static void randomFill(boolean arr[],double density) {
		fill(arr,density);
		shuffle(arr);
	}
	
	public static boolean[] neighborhood(boolean arr[],int loc) {
		int n = arr.length;
		if (n<3) {
			throw new IllegalArgumentException("arr.length < 3");
		}
		boolean[] nHood = new boolean[3];
		nHood[0] = arr[(loc -1 + n)%n ];
		nHood[1] = arr[loc];
		nHood[2] = arr[(loc + 1) % n];
		return nHood;
	}
	
	public static boolean newCenterState(boolean nHood[]){
		int n = nHood.length;
		if (n < 3) {
			throw new IllegalArgumentException("nHood.length < 3");
		}
		return (nHood[0] && !nHood[1] || (nHood[1] && nHood[2]));
	}
	
	public static void updateAll(boolean arr[]) {
		int n = arr.length;
		if (n<3) {
			throw new IllegalArgumentException("arr.length < 3");
		}
		boolean [] old = arr.clone();
		boolean[] nHood = new boolean[3];
		for (int i = 0; i< old.length; i++) {
			nHood = neighborhood(old,i);
			arr[i] = newCenterState(nHood);
		}
	}
}

