package LinkedListObject;

public class Main {
    public static void main(String[] args) {

        // initiate an array of string containing name
        String [] a = {"HOA","HA","LAN","NOI","MUA","NAY"};

        // initiate an array of integer containing age
        int [] b = {25,17,26,19,23,21};

        // create a new list using constructor
        MyList t = new MyList();

        // add name and age to the list using addMany function
        t.addMany(a,b);

        // display the list
        System.out.println("Traverse: ");
        System.out.println(t);

        // display the sorted list
        System.out.println("Sort by name:");

        // sort the list using insertion sort, starting from the head of the list
        t.insertionSort(t.getHead());

        // print out the sorted list
        System.out.println(t);
    }
}
