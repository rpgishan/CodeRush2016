
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gishan-mac
 */
public class DiamondDash {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), diamonds = 0;
        int ar[][] = new int[n][n];
        int path[][] = new int[n][n];
        for (int i = 0; i < ar.length; i++) {

            for (int j = 0; j < ar.length; j++) {
                ar[i][j] = s.nextInt();
            }
            int k = 0;
            for (int j = 0; j < ar.length; j++) {

                if (i == 0) {
                    if (ar[i][j] != 2) {
                        if (ar[i][j] == 1) {
                            diamonds++;
                        }

                    } else {
                        path[i][k] = j - 1;
                        k++;
                    }
                } else {
                    if (ar[i][j] != 2 && j <= path[i - 1][0]) {
                        if (ar[i][j] == 1) {
                            diamonds++;
                        }
                        
                    } else {
                        path[i][k] = j - 1;
                        k++;
                    }
                }
            }
        }
        System.out.println(diamonds);
    }
}
