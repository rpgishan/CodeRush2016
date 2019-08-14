
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
public class LuckyMonthChecker {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), day = 5, sat = 0, sun = 0;
        for (int year = 2016; year < (2016 + n); year++) {
            for (int month = 1; month < 13; month++) {
                int ndays = 0, date = 0, extraDays;
                // System.out.println("start day = "+day);
                switch (day) {
                    case 6:
                        sat++;
                        break;
                    case 7:
                        sun++;
                        break;
                }
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        ndays = 31;
                        //       System.out.println("month = "+month+"   ndays = "+ndays);
                        break;
                    case 2:
                        if (isLeepYear(year)) {
                            ndays = 29;
                        } else {
                            ndays = 28;
                        }
                        //     System.out.println("month = "+month+"   ndays = "+ndays);
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        ndays = 30;
                        //     System.out.println("month = "+month+"   ndays = "+ndays);
                        break;
                }
                date += ndays;
                extraDays = date % 7;
                day += extraDays;
                if (day > 7) {
                    day -= 7;
                }
                //  System.out.println("end day = "+day);
            }
        }
        System.out.println(sat + " " + sun + " " + (sat + sun));
    }

    static boolean isLeepYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        }
        return year % 4 == 0;
    }
}
