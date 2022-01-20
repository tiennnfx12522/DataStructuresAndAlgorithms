package StackDemo;

import java.util.EmptyStackException;

public class MyStack {

    // allocate a new Node
    Node head;

    // constructor to create an empty stack
    public void MyStack() {
        head = null;
    }

    // utility function to check if stack is empty
    public boolean isEmpty() {
        return (head == null);
    }

    // utility function to push an int into stack
    public void push (int x) {

        // allocate a new Node
        Node newNode = new Node();

        // set data in the allocated Node
        newNode.value = x;

        // set the .next pointer of the new node to point to the current
        // head node of the list
        newNode.next = head;

        // update head pointer
        head = newNode;

    }

    // utility function to return the top element of the stack without removing it
    public int peek () {

        // check for an empty stack
        if (isEmpty()) {
            System.out.println("The stack is empty");
            System.exit(-1);
        }

        return head.value;
    }

    // utility function to remove an element from the top of the stack
    public int pop () {

        // check for stack underflow
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }

        // check the head node's data
        int head = peek();

        // update the top pointer to point to the next node
        this.head = (this.head).next;

        return head;
    }

    // function to convert a decimal number to binary
    // by dividing such number by 2 and push the remainder into the stack
    // then empty the stack using pop function and append the removed values into a string

    public String convertToBinary (int x) {

        // create a StringBuilder
        StringBuilder binary = new StringBuilder();

        // if x equals 0 then the result is 0
        if (x == 0) {
            binary.append("0");
        } else {
            // if x does not equal 0, keep diving x by 2 until the quotient is zero
            // and push the remainder into the stack
            while (x != 0) {
                push(x % 2);
                x = x / 2;
            }
        }
        // empty the stack by using pop function and append values into binary string
        while (!isEmpty()) {
                binary.append(pop());
            }
        return binary.toString();

        // from here it is possible to use Integer.parseInt() to changes the string into int
    }
}
