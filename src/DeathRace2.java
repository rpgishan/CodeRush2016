
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
public class DeathRace2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long ent = 0;
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
           a[i]=s.nextInt();
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i+2; j < n; j++) {
                if (primes((j - i),(j-i-1))) {
                    ent += (a[j] - a[i]);
                }
            }
        }
        System.out.println(ent);
       
    }


    static boolean primes(int x, int i) {
        if (i == 1||i==0) {
            return true;
        }
        if (x % i == 0) {
            return false;
        } else {
            return primes(x, i - 1);
        }
    }
}
