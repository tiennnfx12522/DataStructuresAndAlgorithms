package LinkedListObject;

class MyList {
    private Node head;
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

    // add a person into linked list
    public void add(Person x) {
        Node newNode = new Node(x);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    // add multiple persons into linked list
    void addMany(String [] a, int [] b) {
        for (int i = a.length - 1; i >= 0; i--) {
            add(new Person(a[i], b[i]));
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
        if (sorted == null || sorted.getPerson().getName().compareTo(newNode.getPerson().getName()) >= 0) {
            newNode.setNextNode(sorted);
            sorted = newNode;
        } else {
            Node current = sorted;
            /* Locate the node before the point of insertion */
            while (current.getNextNode() != null &&
                    current.getNextNode().getPerson().getName().compareTo(newNode.getPerson().getName()) < 0) {
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

