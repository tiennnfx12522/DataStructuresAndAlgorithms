package SortAndSearch;

import java.util.Scanner;

public class SortAndSearch {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    switchMenu();
    }

    public static void switchMenu () {
        int [] b = createArray();
        SimpleSort t = new SimpleSort(b);
        while(true)
        {System.out.println("\nChoose your option:");
            System.out.println("1. Display data");
            System.out.println("2. Selection sort");
            System.out.println("3. Insertion sort");
            System.out.println("4. Search");
            System.out.println("0. Exit\n");
            System.out.print("Your selection (0 -> 4): ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Good bye, have a nice day!");
                break;
            }

            switch(choice) {
                case 1:
                    t.display();
                    break;
                case 2:
                    t.selectSort();
                    t.display();
                    break;
                case 3:
                    t.insertSort();
                    t.display();
                    break;
                case 4:
                    System.out.println(t.Search(11)+" ");
                    break;
                default:
                    System.out.println("**Invalid choice. Try again.**");
            }
        }
    }

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

}
