package LinkedListObject;

class MyList {

    // declare variables
    private Node head;
    private Node sorted;

    // getters & setters
    public Node getHead() {
        return head;
    }

    public Node getSorted() {
        return sorted;
    }

    public void setSorted(Node sorted) {
        this.sorted = sorted;
    }

    // add a person to linked list
    public void add(Person x) {

        // create a new Node using constructor
        Node newNode = new Node(x);

        // set the head of the list the next Node of the new Node
        newNode.setNextNode(this.head);

        // update the new head
        this.head = newNode;
    }

    // add multiple persons into linked list
    void addMany(String [] a, int [] b) {

        // iterate through the name and age array using for loop
        for (int i = a.length - 1; i >= 0; i--) {

            // add new person to the linked list
            add(new Person(a[i], b[i]));
        }
    }

    // function to sort a singly linked list using insertion sort
    void insertionSort(Node head) {

        // Initialize sorted linked list
        sorted = null;

        // assign the head to the current Node
        Node current = head;

        // Traverse the given linked list and insert every node to sorted
        while (current != null) {

            // store next for next iteration
            Node next = current.getNextNode();

            // sorted insert current in sorted linked list
            sortedInsert(current);

            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        this.head = sorted;
    }

    // function to insert a new_node in a list in a sorted manner

    public void sortedInsert (Node newNode) {

        /* Special case for the head end
        * if the current sorted list is empty or the newNode need to be added in front of the head
        */
        if (sorted == null || sorted.getPerson().getName().compareTo(newNode.getPerson().getName()) >= 0) {

            // make the sorted Node the next Node of the new Node
            newNode.setNextNode(sorted);

            // update the sorted Node
            sorted = newNode;
        } else {

            // assign the sorted Node to the current Node
            Node current = sorted;

            // Locate the node before the point of insertion
            while (current.getNextNode() != null &&
                    current.getNextNode().getPerson().getName().compareTo(newNode.getPerson().getName()) < 0) {

                //update the current Node
                current = current.getNextNode();
            }

            // insert the new Node to the middle of the current Node and its nextNode
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        }
    }

    // modify the toString function to customize the string representation of the linked list
    @Override
    public String toString () {

        // create new StringBuilder object
        StringBuilder result = new StringBuilder();

        // assign the head of the list to the current Node
        Node current = this.head;

        // traverse the linked list with while loop
        while (current != null) {

            // append the StringBuilder object with current Node
            result.append(current).append("\n");

            // advance to the next Node
            current = current.getNextNode();
        }

        // use the toString method to obtain the result from StringBuilder and return the result
        return result.toString();
    }
}

