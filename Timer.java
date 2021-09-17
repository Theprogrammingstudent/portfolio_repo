package Mulkerrins_Alex_3049679_PDS_WB08_Eclipse;

//Alex Mulkerrins - 3049679

/**
 * factorial & fibonacci
 * 
 * As recursion scales it gets slower and slower compared to loop iteration because it has to push more methods on the stack
 * the deeper it goes leading to more and more processing power being used O(n!).
 * 
 * Comparing this to loop iteration which becomes a much more efficient algorithm as scale increases, this is because it has no overheads
 * of frames on the stack, just the one frame allocated to it on the stack in memory.
 * */

public class Timer {

	public static void main(String [] args) {		
		
		
		/**	***This is the factorial iteration for loop section*** */
		System.out.println("This is the factorial iteraton loop");
		
		/**Create a long variable for startTime. Use System.nanoTime();*/
		long fIstartTime = System.nanoTime();	
		//create a for loop as in the question, after 11 we reach stackOverflow.
			for (int i = 0; i <= 20; i++) {
				//Invoke the factorial iterative method, passing in the userNumber as the parameter.
				System.out.println("This result for factorial iteration of " + i + " is: " + FactorialIterative.factorialIterative(i));
			}//endFor
		//Create a long variable stopTime to catch the finish.
		long fIendTime = System.nanoTime();
		//Find out the duration by taking start away from end.
		long fILduration = (fIendTime - fIstartTime);
		//Print the results of the Factorial iteration process.
		System.out.println("The time for factorial iteration in Nano Seconds is: " + fILduration);
		
		
		
		/**	***This is the factorial recursion for loop section*** */
		System.out.println("\n\nThis is the factorial recursion loop");
		
		/**Create a long variable for startTime - fRStartTime.*/
		long fRStartTime = System.nanoTime();
			//Create a for loop as in the question.
			for (int i = 0; i <= 20; i++) {
				//Invoke the factorial recursive method.
				System.out.println("This result for factorial recursion of " + i + " is: " + FactorialRecursive.factorialRecursive(i));
			}//endFor
		//Create a long variable stopTime to catch the finish - fRendTime.
		long fRendTime = System.nanoTime();
		//Find out the duration by taking start away from end.
		long fRduration = (fRendTime - fRStartTime);
		//Print the results of the Factorial iteration process.
		System.out.println("The time for factorial recursion in Nano Seconds is: " + fRduration);
		
		
		
		
		/**	***This is the fibonacci iteration for loop section*** */
		System.out.println("\n\nThis is the fibonacci iteraton loop");
		
		/**Create a long of startTime named fibItstartTime*/
		long fibItStartTime = System.nanoTime();
			for (int i = 0; i <=30; i++) {
				/**Invoke the Fibonacci iterative method and print the result.*/
				System.out.println("The result of " + i + " in the fibonacci iteration sequnce is " + FibbonacciIterative.fibonacciIterative(i));
			}//endFor
		//Create a long stopTime to catch the finish.
		long fibItEndTime = System.nanoTime();
		//Find out the duration by taking start away from end.
		long fibItduration = (fibItEndTime - fibItStartTime);
		//Print the results of the Factorial iteration process.
		System.out.println("The time for the fibonacci iteration in Nano Seconds is: " + fibItduration);
		
		
		
		
		/**	***This is the fibonacci recursion for loop section*** */
		System.out.println("\n\nThis is the fibonacci recursion loop");	
		
		/**Create a long of startTime named fibRstartTime*/
		long fibRstartTime = System.nanoTime();
			for (int i = 0; i <= 30; i++) {
				/**Invoke the fibonacci recursion method*/
				System.out.println("The result of " + i + " in the fibonacci recursion sequnce is " + FibonacciRecursive.fibonaccirecursion(i));
			}//endFor
		//Create a long stopTime to catch the finish, named fibREndTime
		long fibREndTime = System.nanoTime();
		//Find out the duration by taking start away from end.
		long fibRduration = (fibREndTime - fibRstartTime);
		//Print the results of the Factorial iteration process.
		System.out.println("The time for the fibonacci recursion in Nano Seconds is: " + fibRduration);
		
	}
}