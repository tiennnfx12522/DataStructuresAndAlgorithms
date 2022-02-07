package productmanagement;

public class Node {

    // declare variables of Node
    private Product product;
    private Node nextNode;

    // define constructors to create Node
    public Node(Product product) {
        this.product = product;
    }

    // getters & setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    // modify toString method to customize the string representation of the Node object
    @Override
    public String toString () {

        // return product associated with this Node
        return "" + this.product;
    }
}
