
import java.math.BigInteger;
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
public class helphim2 {
    
   public static void main(String[] args) {
        Scanner in = new Scanner (System.in); 
        
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        long n = in.nextLong();
        long x = in.nextLong();
        long y = in.nextLong();
        
       
        
        for (long i=0; i<x; i++){
            sb.append(n);
        }
        
        for (long j=0; j<y; j++){
            sb2.append(n);
        }
        
        BigInteger a = new BigInteger(sb.toString());
        BigInteger b = new BigInteger(sb2.toString());
        
        System.out.println(LCM(a, b));
    }
        
    
    public static BigInteger LCM(BigInteger x,BigInteger y){
        return x.multiply(y.divide(x.gcd(y)));
    }
}
