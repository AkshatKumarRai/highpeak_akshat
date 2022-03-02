package highpeak;

// importing java library files
import java.util.Arrays;
import java.util.Scanner;

public class GoodieDilemma {

	//limiting loop at 3 
	final static int chances = 3;
	
	//initializing parameter from N to M in array and assigning it to minDiff and return type is integer
	static int minDiff(int array[], int N, int M) {
		int result = Integer.MAX_VALUE;
		
		//sorting array
		Arrays.sort(array);
		for (int i = 0; i <= N - M; i++)
			result = Math.min(result, array[i + M - 1] - array[i]);
		return result;
	}

	static int findelements(int res, int array[], int N, int M) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= N; i++) {
			result = Math.min(result, array[i + M - 1] - array[i]);
			if (res == result)
				return i;
		}
		return 0;
	}

	//main function
	public static void main(String[] args) {

		//integer array
		int array[] = { 7980, 22349, 999, 2799, 229900, 11101, 9999, 2195, 9800, 4999 };
		//string array
		String items[] = { "MI Band: 999", "Sandwich Toaster: 2195", "Cult Pass: 2799", "Scale: 4999",
				"Fitbit Plus: 7980", "Microwave Oven: 9800", "Alexa: 9999", "Digital Camera: 11101", "IPods: 22349",
				"Macbook Pro: 229900" };
		//length of array
		int N = array.length;
		
		//set loop from 1 to chances 
		int j = 1;
		while (j <= chances) {
			
			System.out.println("Test case:" +j);

			System.out.println("Enter the number of employees");

			//scanner to scan input from keyboard
			Scanner s = new Scanner(System.in);
			
			//taking input from keyboard
			int M = s.nextInt();
			int result = minDiff(array, N, M);
			System.out.println("Number of the employees:" + M);
			int startindex = findelements(result, array, N, M);
			System.out.println("Here the goodies that are selected for distribution are:");
			for (int i = startindex; i < startindex + M; i++)
				System.out.println(items[i]);
			//System.out.println("\n");
			System.out.println("And the difference between the chosen goodies with highest price and the lowest price is:"
							+ result);
			System.out.println("\n");

			++j;
		}
	}
}
