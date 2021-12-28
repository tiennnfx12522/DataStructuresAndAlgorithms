/*
 This program was developed to create a simple sorting program using bubble sort algorithm.
 The program will prompt user for input to create an array.
 Then bubble sort algorithm is utilized to sort the items in the array in ascending order and print out the result of each step
*/
import java.util.Scanner;
public class BubbleSort {
    // create scanner object
    public static final Scanner sc = new Scanner(System.in);
    //main method
    public static void main(String[] args) {
        int [] array = createArray();
        System.out.println("");
        System.out.println("Initial array: ");
        printArray(array);
        System.out.println("");
        System.out.println("");
        System.out.println("Sorting array using bubble sort algorithm: ");
        bubbleSort(array);
    }

    // method to create array from user's input
    public static int[] createArray () {
        int n;
        do {
            System.out.print("Number of items in the array: ");
            n = sc.nextInt();
        } while (n <= 0);

        // array initialization
        int [] array = new int[n];
        System.out.println("Input values for items in array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Item at index " + i + ": ");
            array [i] = sc.nextInt();
        }
        return array;
    }

    // method to sort items in array using bubble sort algorithm
    public static void bubbleSort (int [] array) {
        boolean swappedSomething;
        do {
            swappedSomething = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swappedSomething = true;
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            printArray(array);
            System.out.println("");
        } while (swappedSomething);
    }

    // method to print out items in array
    public static void printArray (int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
    }
}


