package LinkedList;

public class LinkedList {
    private Node head;

    // Hàm thêm  một phần tử vào đầu danh sách
    public void insertAtHead (int data) {
        Node newNode = new Node (data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    // Hàm thêm nhiều phần tử vào đầu danh sách
    public void addMany (int [] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            Node newNode = new Node (array[i]);
            newNode.setNextNode(this.head);
            this.head = newNode;
        }
    }

    // Hàm tìm kiếm phần tử có giá trị lớn hơn x, nếu tìm thấy thì hiển thị chỉ số của phần tử ra màn hình,
    // giả sử phần tử đầu tiên có chỉ số là 0;
    public int Search(int x) {
        int result = 0;
        Node current = this.head;
        while (current != null) {
            if (current.getData() > x) {
                return result;
            }
            result++;
            current = current.getNextNode();
        }
        return -1;
    }

    // Hàm Duyệt danh sách
    @Override
    public String toString () {
        String result = "Traverse: ";
        Node current = this.head;

        while (current != null) {
            result += current.toString() + " ";
            current = current.getNextNode();
        }

        return result;
    }
}
