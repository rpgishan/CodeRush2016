
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
public class BacktoALclass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.nextLine();
        String[] array = string.split(" ");
        int V = 0;
        boolean Velocity = false;
        int S = 0;
        boolean Displacement = false;
        int a = 0;
        boolean Acceleration = false;
        int t = 0;
        boolean Time = false;
        int U = 0;

        for (int i = 0; i < array.length; i++) {
            try {
                int num = Integer.parseInt(array[i]);
                switch (array[i + 1]) {
                    case "'meters/second'":case "'meters/second'.":
                        V = num;
                        Velocity = true;
                        break;
                    case "'meters'":
                    case "'meters'.":
                        S = num;
                        Displacement = true;
                        break;
                    case "'meters/second-squared'":case "'meters/second-squared'.":
                        a = num;
                        Acceleration = true;
                        break;
                    case "'seconds'":case "'seconds'.":
                        t = num;
                        Time = true;
                        break;
                    default:
                        break;
                }

            } catch (NumberFormatException e) {

            }
        }
        int b = array[array.length - 1].length();
        array[array.length - 1] = array[array.length - 1].substring(0, b - 1);

        switch (array[array.length - 1]) {
            case "velocity":
            case "Velocity":
                if (Acceleration == true && Time == true) {
                    V = U + a * t;
                } else if (Acceleration == true && Displacement == true) {
                    V = (int) Math.sqrt((2 * a * S));
                } else if (Time == true && Displacement == true) {
                    V = 2 * S / t;
                }
                System.out.println(V);
                break;

            case "displacement":
            case "Displacement":
                if (Acceleration == true && Time == true) {
                    S = a * t * t / 2;
                } else if (Velocity == true && Time == true) {
                    S = V * t / 2;
                } else if (Velocity == true && Acceleration == true) {
                    S = ((V * V) - (U * U)) / (2 * a);
                }
                System.out.println(S);
                break;

            case "acceleration":
            case "Acceleration":
                if (Displacement == true && Time == true) {
                    a = 2 * S / (t * t);
                } else if (Velocity == true && Time == true) {
                    a = V / t;
                } else if (Velocity == true && Displacement == true) {
                    a = ((V * V) - (U * U)) / (2 * S);
                }
                System.out.println(a);
                break;

            case "time":
            case "Time":
                if (Displacement == true && Acceleration == true) {
                    t = (int) Math.sqrt((2 * S / a));
                } else if (Velocity == true && Acceleration == true) {
                    t = V / a;
                } else if (Velocity == true && Displacement == true) {
                    t = 2 * S / V;
                }

                System.out.println(t);
                break;
        }
    }
}
