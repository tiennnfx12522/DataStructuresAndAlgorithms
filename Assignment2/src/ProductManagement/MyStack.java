package ProductManagement;

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

    void getProductFromFile(String fileName, MyStack stack) {

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
            stack.push(product);
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
