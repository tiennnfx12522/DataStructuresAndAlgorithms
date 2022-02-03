package ProductManagement;

import java.io.*;
import java.util.Scanner;

public class MyList {

    private Node head;
    private Node tail;
    private Node sorted;

    public Node getHead() {
        return head;
    }

    // add a product into linked list
    public void addFirst(Product product) {
        Node newNode = new Node(product);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public void addLast(Product product) {
        Node newNode = new Node(product);

        if (head == null) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }
        tail = newNode;
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
            String header = "Product Id, Product Name, Quantity, Unit Price\n";
            bw.write(header);
            bw.write(list.toString().replaceAll("((?!\n+)\\s+)", "").replace("|", ", "));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchByID (String productID) {
        Node current = this.head;
        boolean found = false;
        while (current != null) {
            if (current.getProduct().getProductId().equalsIgnoreCase(productID)) {
                found = true; //data found
                System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                System.out.println("-------------------------------------------------------------------");
                System.out.println(current.getProduct());
                break;
            } else {
                current = current.getNextNode();
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }

    public void deleteByID (String productID) {
        Node current = this.head;
        Node prev = null;
        // If head node itself holds the key to be deleted
        if (current != null && current.getProduct().getProductId().equalsIgnoreCase(productID)) {
            head = current.getNextNode(); // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (current != null && (!current.getProduct().getProductId().equalsIgnoreCase(productID))) {
            prev = current;
            current = current.getNextNode();
        }

        // If key was not present in linked list
        if (current == null)
            return;

        // Unlink the node from linked list
        prev.setNextNode(current.getNextNode());
    }

    public int listSize() {
        Node current = this.head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getNextNode();
        }
        return size;
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

    // function to sort a singly linked list using insertion sort recursively
    void recursiveInsertionSort(Node node) {
        Node current = node;
        if (current == null) {
            // Update head_ref to point to sorted linked list
            this.head = sorted;
            sorted = null;
            this.tail = findTail();
            return;
        }
        Node next = current.getNextNode();
        // insert current in sorted linked list
        sortedInsert(current);
        recursiveInsertionSort(next);
        // Update current
        current = next;
    }

    // function to sort a singly linked list using insertion sort iteratively
    void insertionSort() {
        // Initialize sorted linked list
        Node current = this.head;
        sorted = null;
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

    // function to traverse the linked list and find the tail
    Node findTail () {
        Node current = head;
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }
        if (current.getNextNode() == null) {
            tail = current;
        }
        return tail;
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
    public void printList(Node head) {
        while (head != null)
        {
            System.out.println(head);
            head = head.getNextNode();
        }
    }

}