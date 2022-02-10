package binarysearchtree;

public class BinarySearchTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    // insert all element of an int array in the tree
    public void insertMany (int [] a) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    // insert an integer in the tree
    public void insert(int data) {
        if (root == null) {
            this.root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    // traverse in order
    public void traverseInOrder() {
        if (this.root != null)
            this.root.traverseInOrder();
        System.out.println();
    }

    // traverse pre order
    public void traversePreOrder(TreeNode node) {
        if (node != null)
            node.traversePreOrder();
        System.out.println();
    }

    // find an integer in the tree
    public TreeNode find (int data) {

        // recursively search the tree to find the data
        if (root != null) {
            return root.find(data);
        }

        // return null if nothing is found
        return null;
    }

    // find data greater than an integer in the tree
    public void findGreater (int data) {
        if (root != null) {
            root.findGreater(data);
        } else {
            System.out.println("No element in the list is greater than the input value");
        }
    }

    // delete an integer from the tree
    public void delete (int data) {
    }

}
