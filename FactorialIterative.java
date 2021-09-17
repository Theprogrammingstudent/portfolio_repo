package Mulkerrins_Alex_3049679_PDS_WB08_Eclipse;

//Alex Mulkerrins - 3049679

import java.util.Scanner;

//This is the class for factorial iteration.
public class FactorialIterative {
	
	//Declare a long vriable result and initialise to 1.
	
	
	public static void main(String [] args) {
		
		/**Use scanner input to get the factorial number that will be calculated and the last index of the fibonacci sequence.
		 * userNumber is the variable declared.
		 * */
		Scanner input = new Scanner(System.in);
		System.out.println("What is the Factorial number to iterate through?");
		int userNumber = input.nextInt();
		
		//Invoke the factorial iterative method, passing in the userNumber as the parameter, print the result.
		System.out.println("This result for factorial iteration of " + userNumber + " is: " + factorialIterative(userNumber));
	
	}
	
	
	

	/**This is the method that is called when we conduct a factorial iteration of the number that user has entered.*/
	public static long factorialIterative(long n) {
		//Declare a long variable result and initialise to 1.
		long result = 1;
		
		/**Use a for loop to iterate through each number leading up to the specified user input passed into the parameters*/
		for (int i = 1; i <= n; i++) {
			
			/**for every iteration we take the result (starting at 1) and assign a new value which is the result * i
			 * that way we can multiply every number up to the specified number, giving us the factorial.
			 */
			result = result * i;
		}
		
		//Finally just return the long var result.
		return result;
		
	}
	
	
}
