package productmanagement;

// import packages
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyQueue {

    // allocate new Nodes
    Node head;
    Node tail;

    // constructor to create an empty queue
    public MyQueue() {
        this.head = null;
        this.tail = null;
    }

    // method to add a product to the queue.
    void enqueue (Product product) {

        // create a temporary node containing the product
        Node temp = new Node(product);

        // If queue is empty, then new node is front and rear both
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.tail.setNextNode(temp);
        this.tail = temp;
    }

    // Method to remove a product from queue.
    void dequeue() {
        // If queue is empty, return nothing.
        if (this.head == null)
            return;

        // Store previous front and move front one node ahead
        Node temp = this.head;
        this.head = this.head.getNextNode();

        // If front becomes NULL, then change rear also as NULL
        if (this.head == null)
            this.tail = null;
    }
    // read products from a file and add to the queue
    void getProductFromFile(String fileName, MyQueue queue) {

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

            // add newly created product to queue using enqueue method
            queue.enqueue(product);
        }
    }

    // modify toString method to customize the string representation of the queue
    @Override
    public String toString () {

        // create a new StringBuilder
        StringBuilder result = new StringBuilder();

        // mark the head of the queue as current
        Node current = this.head;

        // traverse the queue and append the StringBuilder
        while (current != null) {
            result.append(current).append("\n");
            current = current.getNextNode();
        }

        // return the result string
        return result.toString();
    }
}
