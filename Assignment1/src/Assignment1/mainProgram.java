package Assignment1;

/*
This program was created as part of an assignment for Data Structures and Algorithms courses at FUNIX.
The program enhances learner's ability to read/write file in Java, work with array, and implement
basic algorithms such as bubble sort, selection sort, insertion sort, linear search and binary search.
*/
// import Scanner
import java.util.Scanner;

public class mainProgram {
    // create object Scanner
    public static final Scanner sc = new Scanner(System.in);

    // main method to run program
    public static void main (String[] args) {
        switchMenu();
    }

    // method to show menu and initialize corresponding function
    public static void switchMenu () {
        Algorithms t = new Algorithms();
        while(true) {
            System.out.println("\n+-------------------Menu--------------------+");
            System.out.println("|      1.Input                              |");
            System.out.println("|      2.Out                                |");
            System.out.println("|      3.Bubble sort                        |");
            System.out.println("|      4.Selection sort                     |");
            System.out.println("|      5.Insertion sort                     |");
            System.out.println("|      6.Search > value                     |");
            System.out.println("|      7.Search = value                     |");
            System.out.println("|      0.Exit                               |");
            System.out.println("+-------------------------------------------+\n");
            System.out.print("Your selection (0 -> 7): ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Good bye, have a nice day!");
                break;
            }

            switch (choice) {
                case 1 -> {

                    // create array from user's input
                    float[] input = createArray();

                    // write newly created array into file INPUT.TXT
                    t.writeFile("INPUT.TXT", input);
                }
                case 2 -> {

                    // read data from file INPUT.TXT into an array
                    float[] a = t.readFile("INPUT.TXT");
                    System.out.print("Array a: ");

                    // display all items in array a
                    t.printArray(a);
                }
                case 3 -> {

                    // read data from file INPUT.TXT into an array
                    float[] b = t.readFile("INPUT.TXT");

                    // get the start time
                    long start = System.nanoTime();

                    // call the bubble sort method
                    t.bubbleSort(b);

                    // get the end time
                    long end = System.nanoTime();

                    // execution time
                    long execution = end - start;
                    System.out.println("Execution time: " + execution + " nanoseconds");

                    // write output into file OUTPUT1.txt
                    t.writeFile("OUTPUT1.TXT", b);
                }
                case 4 -> {

                    // read data from file INPUT.TXT into an array
                    float[] c = t.readFile("INPUT.TXT");

                    // get the start time
                    long start = System.nanoTime();

                    // call the selection sort method
                    t.selectionSort(c);

                    // get the end time
                    long end = System.nanoTime();

                    // execution time
                    long execution = end - start;
                    System.out.println("Execution time: " + execution + " nanoseconds");

                    // write output into file OUTPUT2.txt
                    t.writeFile("OUTPUT2.TXT", c);
                }
                case 5 -> {

                    // read data from file INPUT.TXT into an array
                    float[] d = t.readFile("INPUT.TXT");

                    // get the start time
                    long start = System.nanoTime();

                    // call the insertion sort method
                    t.insertionSort(d);

                    // get the end time
                    long end = System.nanoTime();

                    // execution time
                    long execution = end - start;
                    System.out.println("Execution time: " + execution + " nanoseconds");

                    // write output into file OUTPUT3.txt
                    t.writeFile("OUTPUT3.TXT", d);
                }
                case 6 -> {

                    // prompt user to enter search value
                    System.out.print("Input value: ");
                    float value = sc.nextFloat();

                    // read data from file INPUT.TXT into an array
                    float[] e = t.readFile("INPUT.TXT");

                    // call the search method
                    int[] output = t.search(e, value);

                    // write output into file OUTPUT4.TXT
                    t.writeFile("OUTPUT4.TXT", output);
                }
                case 7 -> {

                    // read data from file INPUT.TXT into an array
                    float[] f = t.readFile("INPUT.TXT");

                    // sort data using insertion sort
                    float [] arr = t.insertionSort2(f);

                    // prompt user to enter search value
                    System.out.print("Input value: ");
                    float inputValue = sc.nextFloat();

                    // call the binary search method
                    int result = t.binarySearch(arr, 0, arr.length - 1, inputValue);

                    // display search result
                    System.out.println("Index of first element: " + result);

                    // write output into file OUTPUT5.TXT
                    t.writeFile("OUTPUT5.TXT", result);
                }
                default -> System.out.println("**Invalid choice. Try again.**");
            }
        }
    }

    // method to create array from user's input
    public static float[] createArray () {
        int n;
        do {
            System.out.print("Number of items in the array: ");
            n = sc.nextInt();
        } while (n <= 0 || n > 20);

        // array initialization
        float[] array = new float[n];
        System.out.println("Input values for items in array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Item at index " + i + ": ");
            array[i] = sc.nextFloat();
        }
        return array;
    }
}
