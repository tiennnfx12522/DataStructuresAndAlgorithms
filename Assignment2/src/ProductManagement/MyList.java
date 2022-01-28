package ProductManagement;

import java.io.*;
import java.util.Scanner;

public class MyList {

    private Product product;
    private Node head;
    private Node tail;
    private Node current;
    private Node sorted;

    public Node getHead() {
        return head;
    }

    public Node getSorted() {
        return sorted;
    }

    public void setSorted(Node sorted) {
        this.sorted = sorted;
    }

    // add a product into linked list
    public void addFirst(Product x) {
        Node newNode = new Node(x);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public void getProductFromFile(String fileName, MyList list) {

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
            list.addLast(product);
        }
    }

    public void writeListToFile(String fileName, MyList list) {

        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(list.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addLast(Product product) {
        Node newNode = new Node(product);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }

    }

    // traverse linked list
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


    // function to sort a singly linked list using insertion sort
    void insertionSort(Node head) {
        // Initialize sorted linked list
        sorted = null;
        Node current = head;
        // Traverse the given linked list and insert every node to sorted
        while (current != null) {
            // Store next for next iteration
            Node next = current.getNextNode();
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        this.head = sorted;
    }

    /*
     * function to insert a new_node in a list. Note that
     * this function expects a pointer to head_ref as this
     * can modify the head of the input linked list
     * (similar to push())
     */
    public void sortedInsert (Node newNode) {
        /* Special case for the head end */
        if (sorted == null || sorted.getProduct().getProductId().compareTo(newNode.getProduct().getProductId()) >= 0) {
            newNode.setNextNode(sorted);
            sorted = newNode;
        } else {
            Node current = sorted;
            /* Locate the node before the point of insertion */
            while (current.getNextNode() != null &&
                    current.getNextNode().getProduct().getProductId().compareTo(newNode.getProduct().getProductId()) < 0) {
                current = current.getNextNode();
            }
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        }
    }

    /* Function to print linked list */
    public void printlist(Node head)
    {
        while (head != null)
        {
            System.out.println(head);
            head = head.getNextNode();
        }
    }

}
