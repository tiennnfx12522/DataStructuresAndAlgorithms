package Assignment1;
import java.io.*;
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

    public void readFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);

            List<Float> list = new ArrayList<Float>();
            while (dis.available() > 0) {
                list.add(dis.readFloat());
            }
            Float [] arr = new Float [list.size()];
            arr = list.toArray(arr);
            for (Float v : arr) {
                System.out.print("Array a : " + v + "  ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}