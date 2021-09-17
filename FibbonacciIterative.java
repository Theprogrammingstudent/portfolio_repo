package Mulkerrins_Alex_3049679_PDS_WB08_Eclipse;

//Alex Mulkerrins - 3049679

import java.util.Scanner;

/**This is the fibonacci iteration class*/
public class FibbonacciIterative {
	
	
	public static void main(String [] args) {
		
		/**Use scanner input to get the fibonacci iteration number that will be calculated.
		 * userNumber is the variable declared.
		 * */
		Scanner input = new Scanner(System.in);
		System.out.println("What is the fibonacci iteration number to iterate through?");
		int userNumber = input.nextInt();
		
		/**Invoke the Fibonacci iterative method and print the result.*/
		System.out.println("The result of " + userNumber + " in the fibonacci iteration sequnce is " + fibonacciIterative(userNumber) + ".");
	}
	
	

	/**This is the fibonacci iteration method that is invoke with the Fibbonacci Iteration instance object.
	 * here n is the last number in the fibonacci sequence.*/
	public static long fibonacciIterative(long n) {
		
		
		if (n<=1) {
			return n;
		}
		
		/**Declare three variables num1, num2 and fibNumber
		 * num1 = 0 (two behind fibNumber), num2 = 1 (one behind fibNumber) and fibNumber is the current fibonacci number of the sequence
		 * 
		 * The for loop itself starts at 2 and finishes while i is less than or equal to n
		 * Equate fibNumber = num1 + num2
		 * num1 = num2
		 * and num2 = fibnumber
		 * 
		 * these steps keep the progression of adding the previous one integers to get the newest fibNumber
		 * until the userNumber is reached.
		 * */
		long num1 = 0;
		long num2 = 1;
		long fibNumber = 0;
		
		
		for (int i = 2; i<=n; i++) {
			
			fibNumber = num1 + num2;
			num1 = num2;
			num2 = fibNumber;
		}
		
		return fibNumber;
	}
}
