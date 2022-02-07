package productmanagement;

/*
This program was created as part of an assignment for Data Structures and Algorithms courses at FUNIX.
The program enhances learner's ability to read/write file in Java, work with Linked List, implement
basic sort and search algorithms, apply recursion, and implement queue and stack using linked list.
*/
// import Scanner
import java.util.Scanner;

// main program
public class MainProgram {
    // create object Scanner
    public static Scanner sc = new Scanner(System.in);

    // create new linked list
    public static MyList list = new MyList();

    // create new stack
    public static MyStack stack = new MyStack();

    // create new queue
    public static MyQueue queue = new MyQueue();

    // main method to run program
    public static void main(String[] args) {

        // run the program via switchMenu method
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
        // initiate choice variable to start the do while loop
        int choice = 0;

        // run the code until the user decide to stop the program by choosing exit
        do {
            // print out menu and message to prompt user input
            menu();
            System.out.print("Your selection (0 -> 11): ");
            // try/catch exception to catch errors if the user enters invalid input
            try {

                // receive user input via scanner
                choice = sc.nextInt();

                // switch statement to select code blocks to be executed depending on user's choice
                switch (choice) {

                    // read file and add products to linked list
                    case 1:

                        // define path to input file
                        String fileName = "/Users/tiennguyen/Desktop/Funix/Java/Assignment2/INPUT.TXT";

                        // read the file and add products into the linked list
                        list.getProductFromFile(fileName, list);

                        // display the list
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(list);

                        // break from the code block
                        break;

                    // add a product to the end of the linked list
                    case 2:

                        // get information about new product from user's inputs
                        System.out.print("Input new product Id: ");
                        String productId = sc.next();
                        System.out.print("Input product name: ");
                        String productName = sc.next();
                        System.out.print("Input product quantity: ");
                        int productQuantity = sc.nextInt();
                        System.out.print("Input product price: ");
                        float productPrice = sc.nextFloat();

                        // create new product object from newly obtained information
                        Product p = new Product(productId, productName, productQuantity, productPrice);

                        // add the new product to the tail of the list
                        list.addLast(p);

                        // break from the code block
                        break;

                    // display the list
                    case 3:

                        // display the list
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(list);

                        // break from the code block
                        break;

                    // save information of products from the list to file
                    case 4:

                        // save information of products from the list to file
                        list.writeListToFile("INPUT.TXT", list);

                        // break from the code block
                        break;

                    // search product by product Id
                    case 5:

                        // receive product Id from user to perform search function
                        System.out.print("Input product Id: ");
                        productId = sc.next();

                        // search product in the list using product Id
                        list.searchByID(productId);

                        // break from the code block
                        break;

                    // delete product in the list using product Id
                    case 6:

                        // receive product Id from user to perform delete function
                        System.out.print("Input product Id: ");
                        productId = sc.next();

                        // delete product in the list using product Id
                        list.deleteByID(productId);

                        // break from the code block
                        break;

                    // sort products in the list using product Id
                    case 7:

                        // sort the list using recursive insertion sort
                        list.recursiveInsertionSort(list.getHead());

                        // display the list
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(list);

                        // break from the code block
                        break;

                    // convert the quantity of first product in the list from decimal to binary using recursion
                    case 8:

                        // get the quantity of the product at the head of the list and assign it to decimal variable
                        int decimal = list.getHead().getProduct().getQuantity();

                        // display quantity of first product in decimal
                        System.out.println("Quantity of first product in decimal: " + decimal);

                        // convert decimal to binary
                        int binary = list.convertToBinary(decimal);

                        // display quantity of first product in binary
                        System.out.println("Quantity of first product in binary: " + binary);

                        // break from the code block
                        break;

                    // read file and add products to stack
                    case 9:

                        // define path to input file
                        fileName = "/Users/tiennguyen/Desktop/Funix/Java/Assignment2/INPUT.TXT";

                        // read the file and add products to the stack
                        stack.getProductFromFile(fileName, stack);

                        // display the stack
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(stack);

                        // break from the code block
                        break;

                    // read file and add products to queue
                    case 10:
                        // define path to input file
                        fileName = "/Users/tiennguyen/Desktop/Funix/Java/Assignment2/INPUT.TXT";

                        // read file and add products to the queue
                        queue.getProductFromFile(fileName, queue);

                        // display the queue
                        System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println(queue);

                        // break from the code block
                        break;

                    // exit from the program
                    case 11:

                        // display exit message
                        System.out.println("Good bye, have a nice day!");

                        // break from the code block
                        break;
                    default:

                        // display warning message and prompt user to try again
                        System.out.println("**Invalid choice. Try again.**");
                }

            // catch exception and display warning messages
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid input! Please try again!");
                System.out.println("Please enter a number from 1 to 11 to select function");
            }
        // continue the loop until the user decides to exit the program
        } while (choice != 11);
    }
}
