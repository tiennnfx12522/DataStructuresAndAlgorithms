package productmanagement;

// import packages
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyStack {

    // allocate a new Node
    Node head;

    // constructor to create an empty stack
    public void myStack() {
        this.head = null;
    }

    // utility function to check if stack is empty
    public boolean isEmpty() {
        return (head == null);
    }

    // utility function to push a product into stack
    public void push (Product product) {

        // allocate a new Node & set data in the allocated Node
        Node newNode = new Node(product);

        // set the next pointer of the new node to point to the current
        // head node of the list
        newNode.setNextNode(head);

        // update head pointer
        head = newNode;
    }

    // utility function to return the top element of the stack without removing it
    public Product peek () {

        // check for an empty stack
        if (isEmpty()) {
            System.out.println("The stack is empty");
            System.exit(-1);
        }

        return head.getProduct();
    }

    // utility function to remove an element from the top of the stack
    public Product pop () {

        // check for stack underflow
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }

        // check the head node's data
        Product head = peek();

        // update the top pointer to point to the next node
        this.head = (this.head).getNextNode();

        return head;
    }


    // read products from a file and add to the stack
    void getProductFromFile(String fileName, MyStack stack) {

        // create a file object
        File file = new File(fileName);

        // initiate a scanner
        Scanner sc = null;

        // try/catch block to catch FileNotFoundException
        try {
            // scan the file
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // skip the header line
        String headerLine = sc.nextLine();

        // scan till the last line of the file using while loop
        while (sc.hasNextLine()) {

            // assign line in the file into variable line
            String line = sc.nextLine();

            // split line into multiple strings using split method
            String [] records = line.split(", ");

            // get information about the product from the records
            String productId = records[0];
            String productName = records[1];

            //convert string to int using parseInt method
            int quantity = Integer.parseInt(records[2]);

            // convert string to double using parseDouble method
            double unitPrice = Double.parseDouble(records[3]);

            // create new product using constructor
            Product product = new Product(productId, productName, quantity, unitPrice);

            // add newly created product to stack using push method
            stack.push(product);
        }
    }

    // modify toString method to customize the string representation of the stack
    @Override
    public String toString () {

        // create a new StringBuilder
        StringBuilder result = new StringBuilder();

        // mark the head of the queue as current
        Node current = this.head;

        // traverse the stack and append the StringBuilder
        while (current != null) {
            result.append(current).append("\n");
            current = current.getNextNode();
        }

        // return the result string
        return result.toString();
    }
}
