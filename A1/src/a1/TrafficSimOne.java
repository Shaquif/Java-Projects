package a1;

import java.util.concurrent.TimeUnit;

public class TrafficSimOne {

	public static String clear(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n < 1");
		}
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < n; i++) {
			b.append('\b');
		}
		return b.toString();
	}
	
	public static void main(String[] args) {
		
		int n = 80;
		double density = 0.20;
		final String CLR = clear(n);
		boolean[] arr = new boolean[n];
		
		Rule184.fill(arr, density);
		Rule184.randomFill(arr, density);
		
		/*
		final String CLR = clear(8);
		//boolean[] arr = {true, false, true, true, false, true, true, false};
		boolean[] arr = {true, true, true, true, false, false, false, false};
		*/
		while (true) {
			Rule184.printCells(arr);
			
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.print(CLR);
			System.out.print('\n');
			Rule184.updateAll(arr);
		}
	}

}

