package LinkedListObject;

public class Node {

    // declare variables
    private Person person;
    private Node nextNode;

    // constructors
    public Node(Person person) {
        this.person = person;
    }

    // getters & setters
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        return "" + this.person;
    }
}
