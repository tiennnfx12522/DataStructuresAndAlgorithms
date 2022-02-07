package productmanagement;

// import package
import java.io.*;
import java.util.Scanner;

public class MyList {

    // declare variables of MyList
    private Node head;
    private Node tail;
    private Node sorted;

    // getters & setters
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    // add a product to the head of the linked list
    void addFirst(Product product) {

        // create a newNode containing new product
        Node newNode = new Node(product);

        // set the head of the list as the next node of the newNode
        newNode.setNextNode(this.head);

        // update the new head of the list
        this.head = newNode;
    }

    // add a product to the tail of the linked list
    void addLast(Product product) {

        // create a newNode containing new product
        Node newNode = new Node(product);

        // if the list is empty, the newNode will become the head of the list
        if (head == null) {
            head = newNode;
        } else {
            // if the list is not empty, set the newNode as the next node of
            // the tail of the list
            tail.setNextNode(newNode);
        }

        // update the new tail of the list
        tail = newNode;
    }

    // read products from a file and add to the linked list
    void getProductFromFile(String fileName, MyList list) {

        // reset the list before reading the file
        // this is done to avoid adding the data from the same file multiple times
        list.setHead(null);

        // create a new file object with the input fileName
        File file = new File(fileName);

        // initiate a scanner
        Scanner sc = null;

        // try/catch block to catch FileNotFoundException when scanning the file
        try {
            sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        // clear the header of the file
        String headerLine = sc.nextLine();

        // scan through the file till the last line
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

            // add newly created product to the end of the list
            list.addLast(product);
        }
    }

    // save information of products from the list to file
    void writeListToFile(String fileName, MyList list) {

        // create a new file object with the input fileName
        File file = new File(fileName);

        // try/catch block to catch IOException when writing the file
        try {

            // create new FileWriter object
            FileWriter fw = new FileWriter(file);

            // create new BufferedWriter object
            BufferedWriter bw = new BufferedWriter(fw);

            // define and write the header into file
            String header = "Id, Name, Quantity, Price\n";
            bw.write(header);

            // remove the string formatting and separate the information with comma
            bw.write(list.toString().replaceAll("((?!\n+)\\s+)", "").replace("|", ", "));

            // close the BufferWriter
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display notification that the file was written successfully
        System.out.println("Successfully!");
    }

    // search product in the list using product Id
    void searchByID (String productID) {

        // mark the head of the list as current
        Node current = this.head;

        // initiate variable found to track if search product is in the list or not
        boolean found = false;

        // traverse the list using while loop
        while (current != null) {

            // check if the Id of the product in the current Node match with user's input product Id
            if (current.getProduct().getProductId().equalsIgnoreCase(productID)) {

                // change the value of found variable to true indicating that product has been found in the list
                found = true; //data found

                // display the product in the current node
                System.out.printf("%-15s| %-15s| %-15s|  %s\n", "Product Id", "Product Name", "Quantity", "Unit Price");
                System.out.println("-------------------------------------------------------------------");
                System.out.println(current.getProduct());

                // break from the loop
                break;
            } else {
                // advance to the next Node
                current = current.getNextNode();
            }
        }

        // if no product is found, display -1
        if (!found) {
            System.out.println(-1);
        }
    }

    // delete product in the list using product Id
    void deleteByID (String productID) {

        // mark the head of the list as current
        Node current = this.head;

        // create an empty Node to keep track of the previous Node
        // as we need to change the pointer to remove current node if it holds the key to be deleted
        Node prev = null;

        // If head node itself holds the key to be deleted
        if (current != null && current.getProduct().getProductId().equalsIgnoreCase(productID)) {
            head = current.getNextNode(); // Changed head to remove the current head
            return;
        }

        // while the current node is not null, and it does not hold the key to be deleted save the current node and
        // advance to the next node
        while (current != null && (!current.getProduct().getProductId().equalsIgnoreCase(productID))) {

            // keep track of the current node
            prev = current;

            // advance to the next node
            current = current.getNextNode();
        }

        // once the node holds the key to be deleted has been found and the while loop stops
        // unlink the current node from linked list
        prev.setNextNode(current.getNextNode());

        // traverse the new list to ensure the correct tail in case tail has been deleted
        this.tail = findTail();
        System.out.println("Deleted!");

        // If key was not present in linked list do nothing
        if (current == null)
            return;
    }

    // sort a singly linked list using insertion sort recursively
    // traverse the list and add each element in the correct place in the sorted list
    // then update the head to obtain the sorted list
    void recursiveInsertionSort(Node node) {

        // base case when the end of the list is reached
        if (node == null) {

            // Update head_ref to point to sorted linked list
            this.head = sorted;

            // reset sorted Node to use the method multiple times
            sorted = null;

            // traverse the new list to ensure the correct tail
            this.tail = findTail();
            return;
        }

        // initiate nextNode
        Node next = node.getNextNode();

        // insert current in sorted linked list
        sortedInsert(node);

        // recursively called the method on the nextNode
        recursiveInsertionSort(next);
    }

    void sortedInsert (Node newNode) {

        // if the sorted list is empty or the new node should be added in front of the sorted node
        if (sorted == null || sorted.getProduct().getProductId().compareTo(newNode.getProduct().getProductId()) >= 0) {

            // add the newNode to the front of the sorted node
            newNode.setNextNode(sorted);

            // make the newNode the sorted node
            sorted = newNode;
        } else {

            // Locate the node before the point of insertion
            Node current = sorted;

            // if the end of the list has not been reached and the new node should be added behind the current node
            while (current.getNextNode() != null &&
                    current.getNextNode().getProduct().getProductId().compareTo(newNode.getProduct().getProductId()) < 0) {

                // advance to the next node until the condition of the while loop is not true
                current = current.getNextNode();
            }

            // insert the newNod between the current node and the current's next node
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        }
    }

    // function to sort a singly linked list using insertion sort iteratively
    void insertionSort() {

        // mark the head of the list as current
        Node current = this.head;

        // Initialize sorted linked list
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
        // Update head to point to sorted linked list
        this.head = sorted;
    }

    // function to traverse the linked list and find the tail
    Node findTail () {

        // mark the head of the list as current
        Node current = head;

        // traverse till the end of the linked list
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }

        // update the tail of the linked list and return the new tail
        tail = current;
        return tail;
    }

    // convert an int from decimal to binary using recursion
    int convertToBinary (int decimal) {

        // base case
        if (decimal == 0) {
            return 0;
        }

        // keep diving decimal to 2 and concatenate remainders in bottom-up manner
        else {
            return (decimal % 2 + 10 * convertToBinary(decimal / 2));
        }
    }

    // modify toString method to customize the string representation of the list
    @Override
    public String toString () {

        // create a new StringBuilder
        StringBuilder result = new StringBuilder();

        // mark the head of the list as current
        Node current = this.head;

        // traverse the list and append the StringBuilder
        while (current != null) {
            result.append(current).append("\n");
            current = current.getNextNode();
        }
        
        return result.toString();
    }

}
