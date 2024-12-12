package a1;
import a1.Rule184;

public class TrafficSim {

	public static void sim(int n, double density, boolean isRandom, int iter) {
		boolean[] arr = new boolean[n];
		if (isRandom) {
			Rule184.randomFill(arr,density);
		}
		else {
			Rule184.randomFill(arr,density);
			for (int i = 0; i < iter; i++) {
				Rule184.printCells(arr);
				System.out.println();
				Rule184.updateAll(arr);
			}
		}
	}

	public static void main(String[] args) {
		// Primitive type variables that are meant to be constant
		// should have names written in all caps and be declared
		// final. For example:
		
		final int N = 20;
		final int ITER = 10;
		final double LO = 0.2;
		final double HALF = 0.5;
		final double HI = 0.8;
		
		// low density, cars all start at the beginning of the automaton
		System.out.println("LOW DENSITY");
		sim(N,LO,false,ITER);
		
		// 50% density, cars all start at the beginning of the automaton
		System.out.println();
		System.out.println("50% DENSITY");
		sim(N,LO,false,ITER);
		
		// hi density, cars all start at the beginning of the automaton
		System.out.println();
		System.out.println("HI DENSITY");
		sim(N,HI,false,ITER);
		
		// low density, random car starting position
		System.out.println();
		System.out.println("LOW DENSITY");
		sim(N,LO,false,ITER);
		
		// 50% density, random car starting position
		System.out.println();
		System.out.println("50% DENSITY");
		sim(N,HALF,false,ITER);
		
		// hi density, random car starting position
		System.out.println();
		System.out.println("HI DENSITY");
		sim(N,HI,false,ITER);
	}

}
