package binarysearchtree;

public class TreeNode {
    private Integer data;
    private TreeNode leftChild, rightChild;

    // constructor
    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode find (int data) {

        // if the treeNode contain the data, return the treeNode, this is the base case
        if (this.data == data) {
            return this;
        }

        // if the data contains in the treeNode less than the search data, and the rightChild is not null
        // recursively search the rightChild
        if (this.data < data && rightChild != null) {
            return rightChild.find(data);
        }

        // if the data contains in the treeNode greater than the search data, and the leftChild is not null
        // recursively search the leftChild
        if (this.data > data && leftChild != null) {
            return leftChild.find(data);
        }

        // return if no TreeNode contains the data
        return null;
    }

    public void findGreater (int data) {
        if (this == null) {
            return;
        } else {
            if (this.data > data) {
                System.out.print(this + " ");
            }
            if (leftChild != null) {
                leftChild.findGreater(data);
            }
            if (rightChild != null) {
                rightChild.findGreater(data);
            }
        }



    }

    public void insert (int data) {

        if (data >= this.data) {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(data);
            } else {
                this.rightChild.insert(data);
            }
        } else {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(data);
            } else {
                this.leftChild.insert(data);
            }
        }
    }

    public void traverseInOrder () {
        if (this.leftChild != null) {
            this.leftChild.traverseInOrder();
        }
        System.out.print(this + " ");
        if (this.rightChild != null) {
            this.rightChild.traverseInOrder();
        }
    }

    public void traversePreOrder () {
        System.out.print(this.getData() + " ");
        if (this.leftChild != null) {
            this.leftChild.traversePreOrder();
        }

        if (this.rightChild != null) {
            this.rightChild.traversePreOrder();
        }
    }

    // getters & setters
    public int getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}
