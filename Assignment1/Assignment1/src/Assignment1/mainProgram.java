package Assignment1;

import java.util.Scanner;

public class mainProgram {
    public static final Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        switchMenu();
    }

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
                    float[] input = createArray();
                    t.writeFile("INPUT.TXT", input);
                }
                case 2 -> {
                    float[] a = t.readFile("INPUT.TXT");
                    System.out.print("Array a: ");
                    t.printArray(a);
                }
                case 3 -> {
                    float[] b = t.readFile("INPUT.TXT");
                    t.bubbleSort(b);
                    t.writeFile("OUTPUT1.TXT", b);
                }
                case 4 -> {
                    float[] c = t.readFile("INPUT.TXT");
                    t.selectionSort(c);
                    t.writeFile("OUTPUT2.TXT", c);
                }
                case 5 -> {
                    float[] d = t.readFile("INPUT.TXT");
                    t.insertionSort(d);
                    t.writeFile("OUTPUT3.TXT", d);
                }
                case 6 -> {
                    System.out.print("Input value: ");
                    float value = sc.nextFloat();
                    float[] e = t.readFile("INPUT.TXT");
                    int[] output = t.search(e, value);
                    t.writeFile("OUTPUT4.TXT", output);
                }
                case 7 -> {
                    float[] f = t.readFile("INPUT.TXT");
                    float [] arr = t.insertionSort2(f);
                    System.out.print("Input value: ");
                    float inputValue = sc.nextFloat();
                    int result = t.binarySearch(arr, 0, arr.length - 1, inputValue);
                    System.out.println("Index of first element: " + result);
                    t.writeFile("OUTPUT5.TXT", result);
                }
                default -> System.out.println("**Invalid choice. Try again.**");
            }
        }
    }

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
