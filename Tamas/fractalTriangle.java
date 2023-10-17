package Tamas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class fractalTriangle {
    public static void drawImage(Graphics graphics) {
        int size = WIDTH / 2;
        /*
        graphics.setColor(new Color(0, 49, 63));
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.setColor(Color.yellow);
        */
        drawSomething(0, 0, size, graphics);
    }

    public static void drawSomething(int x, int y ,int size, Graphics graphics) {

        Point2D X1 = new Point(10,10);
        Point2D X2 = new Point(310,10);
        Point2D X3 = new Point(155,310);

        DrawTriangle(graphics, X1, X2, X3, 5);

    }





    public static void DrawTriangle(Graphics graphics, Point2D p1, Point2D p2, Point2D p3 , int depth){
        if(depth == 0){
                    int[] xPoints = {(int) p1.getX(), (int) p2.getX(), (int) p3.getX()};
                    int[] yPoints = {(int) p1.getY(), (int) p2.getY(), (int) p3.getY()};
                    graphics.fillPolygon(xPoints, yPoints, xPoints.length);


        }
        else{
            Point2D midpoint1 = MidPointOfASide(p1, p2);
            Point2D midpoint2 = MidPointOfASide(p2, p3);
            Point2D midpoint3 = MidPointOfASide(p1, p3);

            DrawTriangle(graphics, p1, midpoint1, midpoint3, depth-1);
            DrawTriangle(graphics, midpoint1, p2, midpoint2, depth-1);
            DrawTriangle(graphics, midpoint2, midpoint3, p3, depth-1);
        }
    }

    public static Point2D MidPointOfASide(Point2D p1, Point2D p2){
        return new Point((int)(p1.getX() + p2.getX())/ 2, (int)(p1.getY() + p2.getY()) / 2 );
    }

    // ezt a részt nem kell módosítani
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }



    
    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawImage(graphics);
        }
    }
}