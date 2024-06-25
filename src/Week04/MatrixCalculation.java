package Week04;

public class MatrixCalculation {

    // Method to add two matrices
    public static int[][] add(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        int[][] result = new int[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        
        return result;
    }

    // Method to print a 2D array
    public static void print2DArray(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the above methods
    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };
        
        int[][] matrixB = {
            {2, 4, 6},
            {8, 10, 12},
            {14, 16, 18}
        };

        // Testing the add method
        System.out.println("Addition of matrixA and matrixB:");
        int[][] additionResult = add(matrixA, matrixB);
        print2DArray(additionResult);

        // Testing the multiply method
        System.out.println("\nMultiplication of matrixA and matrixB:");
        int[][] multiplicationResult = multiply(matrixA, matrixB);
        print2DArray(multiplicationResult);
    }
}
