package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int [] a = {7,2,9,8,6,3};

        list.addMany(a);

        System.out.println(list);
        System.out.println("Search (3): " + list.Search(3));
    }
}
