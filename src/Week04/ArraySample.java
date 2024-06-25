package Week04;

public class ArraySample {

	public static void main(String[] args) {
		int[] numbers = {5, 8, 10, 2, 9};
		System.out.println("The size of the numbers array is " + numbers.length);
		printIntArray(numbers);
		
		int[] values = {0};
		System.out.println("The size of the values array is " + values.length);
		printIntArray(values);

		int[][] matrixA = { {2, 4}, {1, 5}, {7, 0} };
		print2DArray(matrixA);
	
	}

	public static void printIntArray(int[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void print2DArray(int[][] array) {
		for (int row = 0; row < array.length; ++row) {
			for (int column = 0; column < array[row].length; ++column) {
				System.out.print(array[row][column] + " ");
			}
			System.out.println();
		}
	}
}
