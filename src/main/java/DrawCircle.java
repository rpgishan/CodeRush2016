
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gishan
 */
public class DrawCircle {

    static int noOfCircles, width, height;
    static List<Cir> mListCir;

    public DrawCircle(int width, int height, int n, List<Cir> lCir) {
        DrawCircle.width = width;
        DrawCircle.height = height;
        noOfCircles = n;
        mListCir = lCir;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new MyPanel(width, height, noOfCircles, mListCir));
        frame.pack();
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel {

    int noOfCircles;
    List<Cir> mListCir;

    MyPanel(int width, int height, int n, List<Cir> lCir) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
        noOfCircles = n;
        mListCir = lCir;
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        for (Cir cir : mListCir) {
            drawCircle(page, cir.x, cir.y, (int) cir.radius);
        }
    }

    private void drawCircle(int x, int y, int radius) {
        getGraphics().fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    private void drawCircle(Graphics g, int x, int y, int radius) {
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
