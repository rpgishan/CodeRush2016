
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
public class ChooseaBatchRepresentative {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int result[] = new int[t];
        int ar[][]=new int[t][3];
        for (int i = 0; i < t; i++) {
            int n = s.nextInt(), m = s.nextInt(), id = s.nextInt();

            int temp = (m%n)+id;
            if(temp>n){
                id=temp-n-1;
            }else{
                id=temp;
            }
            
            result[i] = id;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                System.out.println(result[i]);
            }
        }

    }
}
