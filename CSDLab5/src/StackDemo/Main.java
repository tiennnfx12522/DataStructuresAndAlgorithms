package StackDemo;

public class Main {
    public static void main(String[] args) {

        // input value
        int x = 10;
        System.out.println("Input: " + x);

        // create new MyStack t
        MyStack t = new MyStack();

        // convert decimal to binary and display result
        System.out.println("Output: " + t.convertToBinary(x));
    }
}
