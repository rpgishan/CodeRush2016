
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gishan
 */
public class MarsShield {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();//4;//
        int[][] ar = new int[2][n];
        double circum = 0;
        List<DistDetails> listDetailses = new LinkedList<DistDetails>();
        List<Cir> listCir = new LinkedList<Cir>();
//
//        ar[0][0] = 1;
//        ar[1][0] = 1;
//        ar[0][1] = 5;
//        ar[1][1] = 5;
//        ar[0][2] = 5;
//        ar[1][2] = 1;
//        ar[0][3] = 3;
//        ar[1][3] = 1;

        for (int i = 0; i < n; i++) {
            ar[0][i] = s.nextInt();
            ar[1][i] = s.nextInt();
            Cir c = new Cir();
            c.x = ar[0][i];
            c.y = ar[1][i];
            c.radius = 0;
            listCir.add(c);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                DistDetails details = getDetails(ar[0][i], ar[1][i], ar[0][j], ar[1][j]);
                listDetailses.add(details);
            }
        }

        listDetailses = orderedList(listDetailses);
        for (DistDetails distDetails : listDetailses) {
            int x1 = distDetails.getX1(), y1 = distDetails.getY1(), x2 = distDetails.getX2(), y2 = distDetails.getY2();
            double dist = distDetails.getDistance();
//            System.out.println("X1 = " + x1 + " Y1 = " + y1 + " X2 = " + x2 + " Y2 = " + y2 + " dist = " + dist);
            double r = isIn(x1, y1, dist / 2, listDetailses, listCir);
//            System.out.println("r1 = " + r);
            setRadius(x1, y1, r, listCir);

            double rr = dist - r;
//            System.out.println("r2 before = " + r);
            double rr2 = isIn(x2, y2, rr, listDetailses, listCir);
//            System.out.println("r2 after = " + r);
            setRadius(x2, y2, rr2, listCir);

            if (rr2 < rr) {
                r = isIn(x1, y1, r + rr - rr2, listDetailses, listCir);
//            System.out.println("r1 = " + r);
                setRadius(x1, y1, r, listCir);
            }

            //  listDetailses.remove(distDetails);
        }
//        System.out.println("");
        for (DistDetails listDetail : listDetailses) {
            System.out.println("X1 : " + listDetail.getX1() + " Y1 : " + listDetail.getY1() + " X2 : " + listDetail.getX2() + " Y2 : " + listDetail.getY2() + " Dist : " + listDetail.getDistance());
        }

        System.out.println("");
        for (Cir cir : listCir) {
            System.out.println("x = " + cir.x + " y = " + cir.y + " r = " + cir.radius);
            circum += circumference(cir.radius);
        }
        System.out.println("");
//        System.out.println("total circumference = "+circum);
        System.out.println(circum);

//        new DrawCircle(10000, 10000, n, listCir).main(args);
    }

    static double isIn(int x, int y, double r, List<DistDetails> ldd, List<Cir> lCir) {
        //  Iterator<DistDetails> iteratorDD = ldd.iterator();
        double minr = r;
        for (DistDetails dd : ldd) {
            //  if (iteratorDD.hasNext()) {
            //        DistDetails dd = iteratorDD.next();
            if (dd.x1 == x && dd.y1 == y) {
                double rad = getRadius(dd.x2, dd.y2, lCir);
                if ((dd.getDistance() - rad) < r) {
                    if (dd.getDistance() < minr) {
                        minr = dd.getDistance() - rad;
                    }
                }
            } else if (dd.x2 == x && dd.y2 == y) {
                double rad = getRadius(dd.x1, dd.y1, lCir);
                if ((dd.getDistance() - rad) < minr) {
                    minr = dd.getDistance() - rad;
                }
            }
            //  }
        }
        return minr;
    }

    static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }

    static DistDetails getDetails(int x1, int y1, int x2, int y2) {
        DistDetails details = new DistDetails();
        details.setX1(x1);
        details.setX2(x2);
        details.setY1(y1);
        details.setY2(y2);
        details.setDistance(Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1))));
        return details;
    }

    static double circumference(double r) {
        return 2 * Math.PI * r;
    }

    static void setRadius(int x, int y, double r, List<Cir> lCir) {
        for (Cir cir : lCir) {
            if (cir.x == x && cir.y == y && cir.radius == 0) {
                cir.radius = r;
                break;
            }
        }
    }

    static List<DistDetails> orderedList(List<DistDetails> listDetails) {
        List<DistDetails> listDistDetails = new LinkedList<DistDetails>();

        while (!listDetails.isEmpty()) {
            double max = 0;
            DistDetails maxDetails = null;
            Iterator<DistDetails> dit = listDetails.iterator();
            while (dit.hasNext()) {
                DistDetails dd = dit.next();
                double dist = dd.getDistance();
//                System.out.println("dist = " + dist+" max = "+max);
                if (max < dist) {
                    max = dist;
                    maxDetails = dd;
                }
            }
            listDistDetails.add(maxDetails);
            listDetails.remove(maxDetails);

        }

        return listDistDetails;
    }

    static double getRadius(int x, int y, List<Cir> lCir) {
        Iterator<Cir> iteratorCir = lCir.iterator();
        for (int i = 0; i < lCir.size(); i++) {
            if (iteratorCir.hasNext()) {
                Cir cir = iteratorCir.next();
                if (cir.x == x && cir.y == y) {
                    return cir.radius;
                }
            }
        }
        return -1;
    }

}

class Cir {

    public int x, y;
    public double radius;
}

class DistDetails {

    public int x1, x2, y1, y2;
    public double distance;

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public double getDistance() {
        return distance;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
