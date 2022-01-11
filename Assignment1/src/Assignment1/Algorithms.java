package Assignment1;

// import relevant built-in packages
import java.io.*;
import java.util.ArrayList;

public class Algorithms {

    // method to write array into file
    public void writeFile(String fileName, float [] arr) {
        try {


            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            for (float v : arr) {
                dos.writeFloat(v);
            }
            dos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // method to write array into file
    public void writeFile(String fileName, int [] arr) {
        try {
            // create new file object
            File file = new File(fileName);

            // write the data using DataOutputStream
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int v : arr) {
                dos.writeFloat(v);
            }

            // close the stream
            dos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // method to write an integer into file, this will be used to save position index later
    public void writeFile(String fileName, int value) {
        try {

            // create mew file object
            File file = new File(fileName);

            // write the data using DataOutputStream
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(value);

            // close the stream
            dos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // method to read the data from a file into an array
    float[] readFile(String fileName) {

        // create temporary array list to hold data
        ArrayList<Float> list = new ArrayList<>();

        // read data using DataInputStream and add data into array list
        try {

            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                list.add(dis.readFloat());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // create array from array list
        float [] arr = new float [list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        // return array
        return arr;
    }

    // bubble sort algorithm
    void bubbleSort(float [] b) {
        boolean swappedSomething;
        do {
            swappedSomething = false;
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i] > b[i + 1]) {
                    swappedSomething = true;
                    swap(b, i, i + 1);
                }
            }
            printArray(b);
            System.out.println(" ");
        } while (swappedSomething);
    }

    // selection sort algorithm
    void selectionSort(float [] b) {
        for (int i = 0; i < b.length - 1; i++) {
            int minIndex = i;
            float minValue = b[i];
            for (int j = i; j < b.length; j++) {
                if (b[j] < minValue) {
                    minIndex = j;
                    minValue = b[j];
                }
            }
            if (minValue < b[i]) {
                swap(b, i, minIndex);
            }
            printArray(b);
            System.out.println(" ");
        }
    }

    // insertion sort algorithm
    void insertionSort(float [] b) {
        for (int i = 1; i < b.length; i++) {
            float key = b[i];
            int j = i - 1;
            while (j >= 0 && key < b[j]) {
                swap(b, j, j + 1);
                j--;
            }
            printArray(b);
            System.out.println(" ");
        }
    }

    // sorting algorithm that return array for binary search
    float [] insertionSort2(float [] b) {
        for (int i = 1; i < b.length; i++) {
            float key = b[i];
            int j = i - 1;
            while (j >= 0 && key < b[j]) {
                swap(b, j, j + 1);
                j--;
            }
        }
        return b;
    }

    // linear search algorithm to find the index position of all items in the array
    // greater than a value enter by user
    int [] search(float [] b, float value) {

        // create a temporary list to hold outputs
        ArrayList<Integer> list = new ArrayList<>();

        // iterate array to check for items greater than user's value
        // display index position of such items if found and add index number into the temporary list
        System.out.print("Index: ");
        for (int i = 0; i < b.length; i++) {
            if (b[i] > value) {
                System.out.print(i + " ");
                list.add(i);
            }
        }

        // create an array of output from the list
        int [] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }

        // return output to be saved in file
        return output;
    }

    // binary search algorithm to find the index position of a value enter by user
    int binarySearch(float [] arr, int left, int right, float value) {
        {
            // calculate middle value
            if (right >= left) {
                int mid = left + (right - left) / 2;

                // If the element is present at the middle itself
                if (arr[mid] == value)
                    return mid;

                // If element is smaller than mid, then
                // it can only be present in left sub-array
                if (arr[mid] > value)
                    return binarySearch(arr, left, mid - 1, value);

                // Else the element can only be present in right sub-array
                return binarySearch(arr, mid + 1, right, value);
            }

            // We reach here when element is not present in array
            return -1;
        }
    }

    // display all element in array
    void printArray (float [] array) {
        for (float i: array) {
            System.out.print(i + " ");
        }
    }

    // Swap element at position i with element at position k
    void swap(float[] a, int i, int k) {
        float x;
        x = a[i];
        a[i] = a[k];
        a[k] = x;
    }
}