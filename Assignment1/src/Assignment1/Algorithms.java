package Assignment1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Algorithms {
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

    public void writeFile(String fileName, int [] arr) {
        try {
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int v : arr) {
                dos.writeFloat(v);
            }
            dos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeFile(String fileName, int value) {
        try {
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(value);
            dos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    float[] readFile(String fileName) {
        List<Float> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                list.add(dis.readFloat());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        float [] arr = new float [list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

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

    int [] search(float [] b, float value) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        System.out.print("Index: ");
        for (int i = 0; i < b.length; i++) {
            if (b[i] > value) {
                System.out.print(i + " ");
                list.add(i);
            }
        }
        int [] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }

    int binarySearch(float arr[], int left, int right, float value) {
        {
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