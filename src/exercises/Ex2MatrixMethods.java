package exercises;

import java.util.Arrays;

import static java.lang.StrictMath.round;
import static java.lang.StrictMath.sqrt;
import static java.lang.System.out;
import static oracle.jrockit.jfr.events.Bits.intValue;

/*
 * Methods with array/matrix params and/or return value. Implement methods.
 *
 * See:
 * - Matrices
 */
public class Ex2MatrixMethods {

    public static void main(String[] args) {
        new Ex2MatrixMethods().program();
    }

    void program() {
        int[][] m = {           // Hard coded test data
                {-1, 0, -5, 3},
                {6, 7, -2, 0},
                {9, -2, -6, 8},
                {0, 0, 5, -6}
        };

        // TODO uncomment one at a time and implement

//         Return array with all negatives in m
        int[] negs = getNegatives(m);
        out.println(negs.length == 6);
        out.println(Arrays.toString(negs).equals("[-1, -5, -2, -2, -6, -6]")); // Possibly other ordering!

        // Mark all negatives with a 1, others as 0
        // (create matrix on the fly)
        int[][] marked = markNegatives(new int[][]{
                {1, -2, 3,},
                {-4, 5, -6,},
                {7, -8, 9,},
        });
        /* marked should be
        { {0, 1, 0},
          {1, 0, 1},
          {0, 1, 0} }
        */
        plot(marked);
        out.println(Arrays.toString(marked[0]).equals("[0, 1, 0]"));
        out.println(Arrays.toString(marked[1]).equals("[1, 0, 1]"));
        out.println(Arrays.toString(marked[2]).equals("[0, 1, 0]"));


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Create matrix from array
        int[][] matrix = toMatrix(arr);
        /* matrix should be
        { {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9} }
        */
        plot(matrix);  // If manual inspection
        out.println(Arrays.toString(matrix[0]).equals("[1, 2, 3]"));
        out.println(Arrays.toString(matrix[1]).equals("[4, 5, 6]"));
        out.println(Arrays.toString(matrix[2]).equals("[7, 8, 9]"));


        // Sum of all directly surrounding elements to some element in matrix (not counting the element itself)
        // NOTE: Should be possible to expand method to include more distant neighbours

        out.println(sumNeighbours(matrix, 0, 0) == 11);
        out.println(sumNeighbours(matrix, 1, 1) == 40);
        out.println(sumNeighbours(matrix, 1, 0) == 23);
        out.println(sumNeighbours(matrix, 2, 2) == 19);

    }

    // -------- Write methods below this -----------------------

    private int[] getNegatives(int[][] m) {
        int count = 0;
        // Counts the negative elements inside the arrays inside of m
        for (int[] a : m) {
            for (int b : a) {
                if (b < 0) {
                    count++;
                }
            }
        }
        // Creates the array with negative integers with the length of the amount of negative integers
        int[] arr = new int[count];
        count = 0;
        // Adds the negative elements to the newly made array arr
        for (int[] a : m) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    arr[count] = a[i];
                    count++;
                }
            }
        }
        return arr;
    }

    private int[][] markNegatives(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    private int[][] toMatrix(int[] arr) {
        int length = intValue(Math.sqrt(arr.length));
        int[][] matrix = new int[arr.length/length][length];
        int count = 0;
        for (int a = 0; a < arr.length/length; a++) {
            for (int b = 0; b < length; b++){
                matrix[a][b] = arr[count];
                count++;
            }
        }
        return matrix;
    }

    private int sumNeighbours(int[][] matrix, int row, int col){
        int sum = -(matrix[row][col]);
        for(int offsetY = -1; offsetY < 2;offsetY++){
            for(int offsetX = -1; offsetX < 2;offsetX++){
                sum += neighbours(matrix, offsetY, offsetX, row, col);
            }
        }
        return sum;
    }

    private int neighbours(int[][] matrix, int offsetY, int offsetX, int row, int col){
        if (row + offsetY >= 0 && row + offsetY < matrix.length){
            if (col + offsetX >= 0 && col + offsetX < matrix[offsetY+1].length){
                return matrix[row+offsetY][col+offsetX];
            }
        }
        return 0;
    }





    // Use if you like (during development)
    void plot(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }


}