
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
public class SumAll {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), totd = 0,  m = 0;
        long r, c, ad;
        int[][] ar = new int[n][n];
        long[][] re = new long[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = s.nextInt();
                if (i == j) {
                    totd += ar[i][j];
                }
            }
        }
        ad = totd;

        for (int i = 0; i < n; i++) {
            r = totd;
            c = totd;
            for (int j = 0; j < n; j++) {
                r -= ar[i][j];
                c -= ar[j][i];
            }
            ad -= ar[n - 1 - i][i];
            if (r != 0) {
                m++;
                re[i][0] = r;
            }
            if (c != 0) {
                m++;
                re[i][1] = c;
            }

        }
        if (ad != 0) {
            m++;
        }
        System.out.println(m);
        for (int i = 0; i < n; i++) {
            if (re[i][0] != 0) {
                System.out.println(i + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (re[i][1] != 0) {
                System.out.println("-" + (i + 1));
            }
        }
        if (ad != 0) {
            System.out.println(0);
        }
    }
}
