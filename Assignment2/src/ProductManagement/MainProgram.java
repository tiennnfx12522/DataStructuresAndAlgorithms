package ProductManagement;

/*
This program was created as part of an assignment for Data Structures and Algorithms courses at FUNIX.
The program enhances learner's ability to read/write file in Java, work with array, and implement
basic algorithms such as bubble sort, selection sort, insertion sort, linear search and binary search.
*/
// import Scanner
import java.util.Scanner;

public class MainProgram {
    // create object Scanner
    public static final Scanner sc = new Scanner(System.in);
    public static MyList l = new MyList();
    public static MyStack s = new MyStack();
    public static MyQueue q = new MyQueue();

    // main method to run program
    public static void main(String[] args) {
        switchMenu();
    }


    // method to show menu and initialize corresponding function
    public static void menu() {
        System.out.println("\n+-------------------Menu---------------------+");
        System.out.println("|      1. Load data from file and display    |");
        System.out.println("|      2. Input & add to the end             |");
        System.out.println("|      3. Display data                       |");
        System.out.println("|      4. Save product list to file.         |");
        System.out.println("|      5. Search by ID                       |");
        System.out.println("|      6. Delete by ID                       |");
        System.out.println("|      7. Sort by ID                         |");
        System.out.println("|      8. Convert to Binary                  |");
        System.out.println("|      9. Load to stack and display          |");
        System.out.println("|     10. Load to queue and display          |");
        System.out.println("|     11. Exit                               |");
        System.out.println("+--------------------------------------------+\n");
    }

    public static void switchMenu() {
        // initiate selectFunction variable to start the do while loop
        int choice = 0;

        // run the code until the user decide to stop the program by choosing exit
        do {
            // print out menu and message to prompt user input
            menu();
            System.out.print("Your selection (0 -> 11): ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        String fileName = "/Users/tiennguyen/Desktop/Funix/Java/Assignment2/INPUT.TXT";
                        l.getProductFromFile(fileName, l);
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(l);
                        break;
                    case 2:
                        System.out.print("Input new product Id: ");
                        String productID = sc.next();
                        System.out.print("Input product name: ");
                        String productName = sc.next();
                        System.out.print("Input product quantity: ");
                        int productQuantity = sc.nextInt();
                        System.out.print("Input product price: ");
                        float productPrice = sc.nextFloat();
                        Product p = new Product(productID, productName, productQuantity, productPrice);
                        l.addLast(p);
                        break;
                    case 3:
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(l);
                        break;
                    case 4:
                        l.writeListToFile("INPUT.TXT", l);
                        break;
                    case 5:
                        System.out.print("Input product Id: ");
                        productID = sc.next();
                        l.searchByID(productID);
                        break;
                    case 6:
                        System.out.print("Input product Id: ");
                        productID = sc.next();
                        l.deleteByID(productID);
                        break;
                    case 7:
                        l.recursiveInsertionSort(l.getHead());
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(l);
                        break;
                    case 8:
                        int decimal = l.getHead().getProduct().getQuantity();
                        System.out.println("Quantity of first product in decimal: " + decimal);
                        int binary = l.convertToBinary(decimal);
                        System.out.println("Quantity of first product in binary: " + binary);
                        break;
                    case 9:
                        fileName = "/Users/tiennguyen/Desktop/Funix/Java/Assignment2/INPUT.TXT";
                        s.getProductFromFile(fileName, s);
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(s);
                        break;
                    case 10:
                        fileName = "/Users/tiennguyen/Desktop/Funix/Java/Assignment2/INPUT.TXT";
                        q.getProductFromFile(fileName, q);
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(q);
                        break;
                    case 11:
                        System.out.println("Good bye, have a nice day!");
                        break;
                    default:
                        System.out.println("**Invalid choice. Try again.**");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid input! Please try again!");
                System.out.println("Please enter a number from 1 to 11 to select function");
            }
        } while (choice != 11);
    }
}
