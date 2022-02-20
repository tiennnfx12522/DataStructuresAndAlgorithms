package LinkedList;

public class LinkedList {
    private Node head;

    // add an element to the head of the linked list
    public void insertAtHead (int data) {

        // initiate a new node
        Node newNode = new Node (data);

        // set the next Node of the new node to the current head
        newNode.setNextNode(this.head);

        // update the new head
        this.head = newNode;
    }

    // add multiple elements from an array into the linked list
    public void addMany (int [] array) {

        // iterate through the array with for loop
        for (int i = array.length - 1; i >= 0; i--) {

            // initiate a new node with array's elements
            Node newNode = new Node (array[i]);

            // set the next Node of the new node to the current head
            newNode.setNextNode(this.head);

            // update the new head
            this.head = newNode;
        }
    }

    // search for index of the first element that is greater than the search input
    public int Search(int x) {

        // initiate variable result with the first index 0
        int result = 0;

        // assign the head to the current node
        Node current = this.head;

        // traverse the linked list with while loop
        while (current != null) {

            // if the data in current node is greater than the search input, return the result
            if (current.getData() > x) {
                return result;
            }
            // else increment the result
            result++;

            // update the current node and continue the loop
            current = current.getNextNode();
        }

        // if there is no element in the list greater than the search input, return -1
        return -1;
    }

    // modify toString method to customize the string representation of the linked list
    @Override
    public String toString () {

        // initiate the result string
        String result = "Traverse: ";

        // assign the head to current node
        Node current = this.head;

        // traverse the list with while loop
        while (current != null) {

            // update the result string with current Node
            result += current.toString() + " ";

            // update the current node and continue the loop
            current = current.getNextNode();
        }

        // return the result string
        return result;
    }
}
