package lambdabasics;

import java.math.*;

public class FunctionTest {
	
	/*
	 * This method takes as an argument an implementation of our FunctionalInterface, as well as
	 * an int arg. It calls the implementation's function() method passing the int arg to it
	 */
	public int invokeFunction(FunctionalInterface intf, int n) {
		return intf.function(n);
	}
	
	public static void main(String[] args) {
		FunctionTest functionTest = new FunctionTest();
		
		/*
		 * Prior to lambda expressions
		 *  - only way to do this was to create an instance of an implementation of 
		 * Create instance and pass this to the invokeFunction method
		 */
		FunctionalInterfaceImpl impl = new FunctionalInterfaceImpl();  
		System.out.print("Using implementation = ");
		System.out.println(functionTest.invokeFunction(impl, 4));
		
		/*
		 * Using lambdas 
		 * - create a lambda expression and pass it as an argument in place of 
		 * an implementation of the interface
		 */
		FunctionalInterface f1 = (int n) -> 3 * (n * n) + (2 * n) + 4;
		
		System.out.print("Using lambda f1 = ");
		System.out.println(functionTest.invokeFunction(f1, 4));	
		
		/*
		 * Can create additional lambdas just as we could create multiple implementations
		 * of the interface and pass these to the method expecting it
		 */
		FunctionalInterface f2 = (int n) -> (2 * (n * n * n)) + (4 * n * n) + (5 * n) + 3;
		System.out.print("Using lambda f2 = ");
		System.out.println(functionTest.invokeFunction(f2, 4));
		
		// Re-writing f2 using pow() instead
		FunctionalInterface f3 = (int n) -> (int)(2 * Math.pow((double)n, 3) +
				                            (int)(4 * Math.pow((double)n, 2))) +
				                            5 * n +
				                            3;
		System.out.print("Using lambda f3 = ");
		System.out.println(functionTest.invokeFunction(f3, 4));
								
	}

}
