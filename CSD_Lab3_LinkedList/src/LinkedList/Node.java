package LinkedList;

public class Node {

    // declare variables
    private int data;
    private Node nextNode;

    // setters & getters
    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    // modify toString method to customize the string representation of the Node
    @Override
    public String toString () {
        return "" + this.data;
    }
}
