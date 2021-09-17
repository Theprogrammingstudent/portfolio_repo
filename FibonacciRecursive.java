package Mulkerrins_Alex_3049679_PDS_WB08_Eclipse;

//Alex Mulkerrins - 3049679

import java.util.Scanner;

/**This is the fibonacci recursion class*/
public class FibonacciRecursive {
	
	
	
	public static void main(String [] args) {
		
		/**Use scanner input to get the Fibonacci recursion number that will be calculated.
		 * userNumber is the variable declared.
		 * */
		Scanner input = new Scanner(System.in);
		System.out.println("What is the Fibonacci recursion number to use?");
		int userNumber = input.nextInt();
		
		/**This is the fibonacci recusion sequence*/
		/**Invoke the fibonacci recursion method & print the result*/
		System.out.println("\nThe result of " + userNumber + " in the fibonacci recursion sequnce is " + fibonaccirecursion(userNumber));
		
	}

	/**This is the fibonacci recursion method, it is invoked when called by the fibonacci recursion instance object.*/
	public static long fibonaccirecursion(long n) {
		
		/**Base Case - Here we need two base cases because fibonacci adds the two previous integers to get the next answer.*/
		if (n == 0) {		
			return 0;
		}
		
		else if (n == 1) {
			return 1;
		}
		
		/**If n is neither 1 or 0, start the recursion, in this recursive method we have two recursive calls 
		 * this is to do with the fibonacci sum itself. */
		else {
		return fibonaccirecursion(n-1) + fibonaccirecursion(n-2);
		}
	}
	
}
