
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
public class HelpHim {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String x = s.next(), ks = "", ls = "";
        int a = s.nextInt(), b = s.nextInt();
        for (int i = 0; i < a; i++) {
            ks += x + "";
        }
        for (int i = 0; i < b; i++) {
            ls += x + "";
        }
        long k = Long.parseLong(ks), l = Long.parseLong(ls);
        
        System.out.println(LCM(k, l));
    }

    public static long GCD(long x, long y) {
        while (y > 0) {
            long value;
            value = y;
            y = x % y;
            x = value;
        }
        return x;
    }

    public static long LCM(long x, long y) {

        return x * (y / GCD(x, y));
    }
}
