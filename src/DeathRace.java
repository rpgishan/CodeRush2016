
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
public class DeathRace {
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in); 
        
        int n = in.nextInt();
        int[] array = new int[n+1];
        long total = 0;
        
        if (n < 100000){
            for (int i=1; i<n+1; i++){
                array[i] = in.nextInt();
            }
        }
        
        for (int a=1; a<n+1; a++){
            for (int b=a+1; b<n+1; b++){
                int q = b-a;
                boolean prime = Prime(q);
                if ((prime) && q != 1){
                    total += (array[b]-array[a]);
                }
            }
        }
        
        System.out.println(total);
    }
    
        public static boolean Prime(int value) {
        for(int i = 2; i < value; i++) {
            if(value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
