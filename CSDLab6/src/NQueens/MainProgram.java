package NQueens;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        NQueens t = new NQueens();
        System.out.print("Size of the chess board (n): ");
        int n = sc.nextInt();
        List<List<Integer>> result = t.nQueen(n);
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + " " + result.get(i));
        }
    }
}


