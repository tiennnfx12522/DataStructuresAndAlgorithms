package LinkedList;

public class Main {
    public static void main(String[] args) {

        // initiate linked list
        LinkedList list = new LinkedList();

        // add values into linked list
        int [] a = {7,2,9,8,6,3};
        list.addMany(a);

        // display the linked list
        System.out.println(list);

        /* execute the search function and
        display the index of the first element in the list that is greater than the input*/
        System.out.println("Search (8): " + list.Search(8));
    }
}
