
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
public class GlovePairs {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), pairs = 0;
        int[] done = new int[n];
        String ar[][] = new String[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                ar[i][j] = s.next();
            }
        }

        int d = 0;
        F1:
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < d; j++) {
                if (done[j] != 0) {
                    if (done[j] == i) {
                        continue F1;
                    }
                }else{
                        break;
                    }
            }
            F2:for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < d; k++) {
                    if (done[k] != 0) {
                        if (done[k] == j) {
                            continue F2;
                        }
                    }else{
                        break;
                    }
                }
                if (ar[i][0].equals(ar[j][0]) && ar[i][1].equals(ar[j][1]) && ar[i][2].equals(ar[j][2]) && !ar[i][3].equals(ar[j][3])) {
                    pairs++;
                    done[d] = j;
                    d++;
                    continue F1;
                }
            }

        }

        System.out.println(pairs);
    }
}
