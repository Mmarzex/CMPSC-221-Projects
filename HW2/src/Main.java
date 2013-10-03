import function.*;

/*
 * Homework 2: map function
 * Max Marze
 * Section 3
 */
public class Main {
	
	public static void main(String args[]) {
		
		/// Test One
		Integer[] someArray = { 1, 2, 3 };
		Function<Integer, Integer> successorFuction = new CalculateSuccessor();
		PrintArray(someArray);
 		PrintArray(map(successorFuction, someArray));
 		
 		/// Test Two
		Function<Integer, String> stringLengthFunction = new CalculateStringLength();
		String[] stringArray = { "test", "tests", "tester", "testers" };
		System.out.println();
		PrintArray(stringArray);
		PrintArray(map(stringLengthFunction, stringArray));
		
		/// Test Three
		Function<Double, Double> triplesFunction = new CalculateTriple();
		Double[] doubleArray = { 2.0, 3.0, 8.0, 24.0, 56.0, 1.0, 4.0 };
		System.out.println();
		PrintArray(doubleArray);
		PrintArray(map(triplesFunction, doubleArray));
	}
	
	/**
	 * Generic Map Function
	 * @param function with Generic Range and Domain
	 * @param array an array of Generic type D 
	 * @return an array of type-casted R created by having function mapped onto array
	 */
	public static <R, D> R[] map(Function<R, D> function, D[] array) {
		Object newArray[] = new Object[array.length];
		if(array.length > 0) {
			for(int i = 0; i < array.length; i++) {
				newArray[i] = function.apply(array[i]);
			}
			//R[] someArray = Arrays.copyOf(newArray, newArray.length, R[].class);
			return (R[]) newArray;
		}
		return null;
	}
	
	/**
	 *PrintArray function  
	 * @param array an array of type Object to be printed
	 */
	public static void PrintArray(Object[] array) {
		String outString = "{" + array[0];
		for(int i = 1; i < array.length; i++) {
			outString += (", " + array[i]);
		}
		outString += "}";
		System.out.println(outString);
	}

}