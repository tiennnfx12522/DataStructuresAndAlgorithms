package ProductManagement;


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
        // If queue is empty, return NULL.
        if (this.head == null)
            return;

        // Store previous front and move front one node ahead
        Node temp = this.head;
        this.head = this.head.getNextNode();

        // If front becomes NULL, then change rear also as NULL
        if (this.head == null)
            this.tail = null;
    }

    void getProductFromFile(String fileName, MyQueue queue) {

        File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String headerLine = sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String [] records = line.split(", ");
            String productId = records[0];
            String productName = records[1];
            int quantity = Integer.parseInt(records[2]);
            double unitPrice = Double.parseDouble(records[3]);
            Product product = new Product(productId, productName, quantity, unitPrice);
            queue.enqueue(product);
        }
    }

    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();
        Node current = this.head;

        while (current != null) {
            result.append(current).append("\n");
            current = current.getNextNode();
        }
        return result.toString();
    }
}
