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

    public void setHead(Node head) {
        this.head = head;
    }

    // add a product into linked list
    void addFirst(Product product) {
        Node newNode = new Node(product);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    void addLast(Product product) {
        Node newNode = new Node(product);

        if (head == null) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }
        tail = newNode;
    }

    void getProductFromFile(String fileName, MyList list) {
        list.setHead(null);
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

    void writeListToFile(String fileName, MyList list) {

        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            String header = "Id, Name, Quantity, Price\n";
            bw.write(header);
            bw.write(list.toString().replaceAll("((?!\n+)\\s+)", "").replace("|", ", "));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully!");
    }

    void searchByID (String productID) {
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

    void deleteByID (String productID) {
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
        this.tail = findTail();
        System.out.println("Deleted!");
    }

    // function to sort a singly linked list using insertion sort recursively
    void recursiveInsertionSort(Node node) {
        if (node == null) {
            // Update head_ref to point to sorted linked list
            this.head = sorted;
            sorted = null;
            this.tail = findTail();
            return;
        }
        Node next = node.getNextNode();
        // insert current in sorted linked list
        sortedInsert(node);
        recursiveInsertionSort(next);
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

    void sortedInsert (Node newNode) {
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

    // function to traverse the linked list and find the tail
    Node findTail () {
        Node current = head;
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }
        tail = current;
        return tail;
    }

    int convertToBinary (int decimal) {
        if (decimal == 0) {
            return 0;
        }
        else {
            return (decimal % 2 + 10 * convertToBinary(decimal / 2));
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
