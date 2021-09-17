package Mulkerrins_Alex_3049679_PDS_WB08_Eclipse;

//Alex Mulkerrins - 3049679

import java.util.Scanner;

//This is the class for factorial recursion.
public class FactorialRecursive {
	
	public static void main(String [] args) {
		
		/**Use scanner input to get the factorial recursion number that will be calculated.
		 * userNumber is the variable declared.
		 * */
		Scanner input = new Scanner(System.in);
		System.out.println("What is the Factorial recursion number to use?");
		int userNumber = input.nextInt();
				
		//Invoke the factorial recursive method. print the result.
		System.out.println("This result for factorial recursion of " + userNumber + "is: " + factorialRecursive(userNumber));

	}
	
	
	

	//This is the method called when we invoke an object instance of factorial recursion passing in the userNumber.
	public static long factorialRecursive (long n) {
		
		//First off set a base case, in this case it is n==0 this prevent stack overflow, return 1.
		if(n == 0) {
			return 1;
		}
		
		/**If n is not == 0 then multiply n by n-1. however, factorialRecursive(n-1) is the recursion part where it calls itself, it will keep multiplying n and invoking
		 * factorialRecursive(n-1) until it reaches the base case of n == 0. Then just return it.*/
		else {
			return n * factorialRecursive(n-1);
		}
	}
	
}
