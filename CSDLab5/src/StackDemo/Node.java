package StackDemo;

public class Node {

    // declare variables
    int value;
    Node next;

    // constructor
    public void Node(int  x, Node p) {
        value = x;
        next = p;
    }

    // getters & setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

