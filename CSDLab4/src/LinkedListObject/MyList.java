package LinkedListObject;

class MyList {
    private Node head;
    private Node sorted;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    // Hàm thêm 1 người vào đuôi danh sách móc nối
    public void add(Person x) {
        Node newNode = new Node(x);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    // Hàm thêm nhiều người vào danh sách móc nối, thông tin (tên và tuổi) của mọi người
    // được lưu trong 2 mảng a và b
    void addMany(String [] a, int [] b) {
        for (int i = a.length - 1; i >= 0; i--) {
            add(new Person(a[i], b[i]));
        }
    }

    // Hàm duyệt danh sách móc nối
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

    // Hàm sắp xếp theo tên
    public void sortByName() {

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
        head = sorted;
    }

    /*
     * function to insert a new_node in a list. Note that
     * this function expects a pointer to head_ref as this
     * can modify the head of the input linked list
     * (similar to push())
     */
    void sortedInsert(Node newNode) {
        /* Special case for the head end */
        if (sorted == null || sorted.getPerson().getName().charAt(0) >= newNode.getPerson().getName().charAt(0)) {
            newNode.setNextNode(sorted);
            sorted = newNode;
        } else {
            Node current = sorted;
            /* Locate the node before the point of insertion */
            while (current.getNextNode() != null && current.getPerson().getName().charAt(0) < newNode.getPerson().getName().charAt(0)) {
                current = current.getNextNode();
            }
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        }
    }
}

