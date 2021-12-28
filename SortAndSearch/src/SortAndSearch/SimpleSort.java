package SortAndSearch;

public class SimpleSort {
    int [] a;
    int n;

    SimpleSort(int [] b) {
        n = b.length;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // Swap element at position i with element at position k
    void swap(int i, int k) {
        int x;
        x = a[i];
        a[i] = a[k];
        a[k] = x;
    }
    void selectSort() {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            int minValue = a[i];
            for (int j = i; j < a.length; j++) {
                if (a[j] < minValue) {
                    minIndex = j;
                    minValue = a[j];
                }
            }
            if (minValue < a[i]) {
                swap(i, minIndex);
            }
        }
    }

    void insertSort() {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && key < a[j]) {
                swap(j, j + 1);
                j--;
            }
        }
    }

    int Search(int value){
        return 1;
    }
}
