package Assignment1;
import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorithms {

    public void writeFile(String fileName, float [] arr) throws IOException {
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

    public float[] readFile(String fileName) {
        List<Float> list = new ArrayList<Float>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                list.add(dis.readFloat());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            float [] arr = new float [list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            System.out.print("Array a : ");
            for (float v : arr) {
                System.out.print(v + "  ");
            }
            System.out.println(" ");
            return arr;
        }
    }

    public float[] bubbleSort(float [] b) {
        boolean swappedSomething;
        do {
            swappedSomething = false;
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i] > b[i + 1]) {
                    swappedSomething = true;
                    float temp = b[i];
                    b[i] = b[i + 1];
                    b[i + 1] = temp;
                }
            }
            printArray(b);
            System.out.println(" ");
        } while (swappedSomething);
        return b;
    }

    public static void printArray (float [] array) {
        for (float i: array) {
            System.out.print(i + " ");
        }
    }
}