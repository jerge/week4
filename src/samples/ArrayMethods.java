package samples;

import java.util.Arrays;

import static java.lang.System.*;

/*
 *   Methods taking array parameters and/or possibly return array types.
 */
public class ArrayMethods {


    public static void main(String[] args) {
        new ArrayMethods().program();
    }

    void program() {
        int[] arr = {1, 2, 3, 4, 5};

        out.println(sum(arr) == 15);  // Sum all elements

        out.println(find(arr, 4) == 3);  // Value 4 is at index 3
        out.println(find(arr, 99) == -1);  // Not found

        out.println(findMin(arr) == 1);  // Min value

        zeroIt(arr);
        out.println(Arrays.toString(arr).equals("[0, 0, 0, 0, 0]"));

        arr = getArr(4, 9);
        out.println(Arrays.toString(arr).equals("[9, 9, 9, 9]"));

    }

    // ---- Methods ---------------------
    int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i];
        }
        return s;
    }


    int find(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    void zeroIt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    int[] getArr(int size, int value) {
        int[] arr = new int[size];   // Create new array to return
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
        return arr;
    }
}
