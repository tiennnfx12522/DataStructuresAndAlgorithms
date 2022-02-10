package binarysearchtree;

import java.util.Scanner;

public class MainProgram {

    public static void main (String [] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);

        System.out.print("Array length (n): ");
        int n = sc.nextInt();
        int [] a = new int [n];
        for (int i = 0; i <= n - 1; i++) {
            System.out.print("Element at index " + i + ": ");
            a[i] = sc.nextInt();
        }

        tree.insertMany(a);
        tree.traverseInOrder();
        tree.traversePreOrder(tree.getRoot());

        System.out.print("Find all elements in tree greater than: ");
        int input = sc.nextInt();
        System.out.print("Result: ");
        tree.findGreater(input);
        /*
        System.out.println("\nPre-order traverse:");
        tree.preOrder(tree.root);
        System.out.println("\nIn-order traverse:");
        tree.inOrder(tree.root);

        System.out.println("\nSearch:");

        tree.search(root, 10);

        */
    }
}
