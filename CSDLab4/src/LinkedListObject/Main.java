package LinkedListObject;

public class Main {
    public static void main(String[] args) {

        String [] a = {"HOA","HA","LAN","NOI","MUA","NAY"};
        int [] b = {25,17,26,19,23,21};

        MyList t = new MyList();
        t.addMany(a,b);

        System.out.println("Traverse: " + "\n");
        System.out.println(t);


        System.out.println("Sort by name:");
        t.insertionSort(t.getHead());
        t.printlist(t.getHead());
        System.out.println();
    }
}
