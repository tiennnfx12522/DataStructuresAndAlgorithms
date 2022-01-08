package Assignment1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class mainProgram {
    public static final Scanner sc = new Scanner(System.in);
    public static void main (String[] args) throws IOException {
        switchMenu();
    }

    public static void switchMenu () throws IOException {
        Algorithms t = new Algorithms();
        while(true) {
            System.out.println("\nChoose your option:");
            System.out.println("1. Input");
            System.out.println("2. Output");
            System.out.println("3. Bubble sort");
            System.out.println("4. Selection sort");
            System.out.println("5. Insertion sort");
            System.out.println("6. Search > value");
            System.out.println("7. Search = value");
            System.out.println("0. Exit\n");
            System.out.print("Your selection (0 -> 7): ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Good bye, have a nice day!");
                break;
            }

            switch(choice) {
                case 1:
                    float [] a = createArray();
                    t.writeFile("INPUT.TXT", a);
                    break;
                case 2:
                    t.readFile("INPUT.TXT");
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                default:
                    System.out.println("**Invalid choice. Try again.**");
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
