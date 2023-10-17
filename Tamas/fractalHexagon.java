package Tamas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class fractalHexagon {
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

        Point p1 = new Point(300 + 400/2, 100 + 400/2);
        Point p2 = new Point(300 + 400/2, 200 + 400/2);
        Point p3 = new Point(200 + 400/2, 250 + 400/2);
        Point p4 = new Point(100 + 400/2, 200 + 400/2);
        Point p5 = new Point(100 + 400/2, 100 + 400/2);
        Point p6 = new Point(200 + 400/2, 50 + 400/2); 
               DrawHexagon(graphics, p1, p2, p3, p4, p5, p6, 3);
    }



    public static void DrawHexagon(Graphics graphics, Point2D p1, Point2D p2, Point2D p3, Point2D p4, Point2D p5, Point2D p6, int depth){
        if(depth == 0){

            int[] xPoints = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX(),(int)p4.getX(),(int)p5.getX(),(int)p6.getX()};
            int[] YPoints = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY(),(int)p4.getY(),(int)p5.getY(),(int)p6.getY()};

            graphics.drawPolygon(xPoints, YPoints, xPoints.length);


        }else{

            int[] xPoints = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX(),(int)p4.getX(),(int)p5.getX(),(int)p6.getX()};
            int[] YPoints = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY(),(int)p4.getY(),(int)p5.getY(),(int)p6.getY()};

            graphics.drawPolygon(xPoints, YPoints, xPoints.length);

            DrawHexagon(graphics, ThirdOfASide(p6, p1), ThirdOfASide(p6,p2), ThirdOfASide(p6, p3), ThirdOfASide(p6,p4), ThirdOfASide(p6,p5), p6, depth-1);
            DrawHexagon(graphics, p1, ThirdOfASide(p1,p2), ThirdOfASide(p1, p3), ThirdOfASide(p1,p4), ThirdOfASide(p1,p5), ThirdOfASide(p1,p6), depth-1);
            DrawHexagon(graphics, ThirdOfASide(p2,p1), p2, ThirdOfASide(p2, p3), ThirdOfASide(p2,p4), ThirdOfASide(p2,p5), ThirdOfASide(p2,p6), depth-1);
            DrawHexagon(graphics, ThirdOfASide(p3,p1), ThirdOfASide(p3, p2), p3, ThirdOfASide(p3,p4), ThirdOfASide(p3,p5), ThirdOfASide(p3,p6), depth-1);
            DrawHexagon(graphics, ThirdOfASide(p4,p1), ThirdOfASide(p4, p2), ThirdOfASide(p4,p3), p4, ThirdOfASide(p4,p5), ThirdOfASide(p4,p6), depth-1);
            DrawHexagon(graphics, ThirdOfASide(p5,p1), ThirdOfASide(p5,p2), ThirdOfASide(p5, p3), ThirdOfASide(p5,p4), p5, ThirdOfASide(p5,p6), depth-1);



        }
        
    }

    public static Point2D ThirdOfASide(Point2D p1, Point2D p2){
        return new Point((int)(2*p1.getX() + p2.getX())/3,(int)(2*p1.getY() + p2.getY())/3 );
    }

    public static double DistanceOfTwoPoints(Point2D p1, Point2D p2){
            double keplet1fele = Math.pow((p1.getX()-p2.getX()), 2);
            double keplet2fele = Math.pow((p1.getY()-p2.getY()), 2);

            return Math.sqrt(keplet1fele + keplet2fele);
    }

    // ezt a részt nem kell módosítani
    static int WIDTH = 800;
    static int HEIGHT = 800;

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
