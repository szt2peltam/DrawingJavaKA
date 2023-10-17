package Tamas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class fractalSpierpinskyCarpet {
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

        Point p1 = new Point(300,300);
        Point p2 = new Point(600,300);
        Point p3 = new Point(600,600);
        Point p4 = new Point(300,600);
        DrawSquare(graphics, p1, p2, p3, p4, 5);
    }



    public static void DrawSquare(Graphics graphics, Point2D p1, Point2D p2, Point2D p3, Point2D p4, int depth){
        if(depth == 0){

            int[] xPoints = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX(),(int)p4.getX()};
            int[] YPoints = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY(),(int)p4.getY()};

            graphics.fillPolygon(xPoints, YPoints, xPoints.length);


        }else{
            int[] xPoints = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX(),(int)p4.getX()};
            int[] YPoints = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY(),(int)p4.getY()};

            graphics.fillPolygon(xPoints, YPoints, xPoints.length);
            Point2D nullPoint = new Point(0, 0);
            Point2D topPoint = new Point(450, 0 );
            Point2D topRightPoint = new Point(900, 0);
            Point2D middreRightPoint = new Point(900, 450);
            Point2D bottomRightPoint = new Point(900, 900);
            Point2D bottomPoint = new Point(450, 900);
            Point2D bottomleftPoint = new Point(0, 900);
            Point2D middleLeftPoint = new Point(0, 450);

            DrawSquare(graphics, ThirdOfASide(nullPoint,p1), ThirdOfASide(nullPoint,p2), ThirdOfASide(nullPoint,p3), ThirdOfASide(nullPoint,p4), depth-1);
            DrawSquare(graphics, ThirdOfASide(topPoint,p1), ThirdOfASide(topPoint,p2), ThirdOfASide(topPoint,p3), ThirdOfASide(topPoint,p4), depth-1);
            DrawSquare(graphics, ThirdOfASide(topRightPoint,p1), ThirdOfASide(topRightPoint,p2), ThirdOfASide(topRightPoint,p3), ThirdOfASide(topRightPoint,p4), depth-1);
            DrawSquare(graphics, ThirdOfASide(middreRightPoint,p1), ThirdOfASide(middreRightPoint,p2), ThirdOfASide(middreRightPoint,p3), ThirdOfASide(middreRightPoint,p4), depth-1);
            DrawSquare(graphics, ThirdOfASide(bottomRightPoint,p1), ThirdOfASide(bottomRightPoint,p2), ThirdOfASide(bottomRightPoint,p3), ThirdOfASide(bottomRightPoint,p4), depth-1);
            DrawSquare(graphics, ThirdOfASide(bottomPoint,p1), ThirdOfASide(bottomPoint,p2), ThirdOfASide(bottomPoint,p3), ThirdOfASide(bottomPoint,p4), depth-1);
            DrawSquare(graphics, ThirdOfASide(bottomleftPoint,p1), ThirdOfASide(bottomleftPoint,p2), ThirdOfASide(bottomleftPoint,p3), ThirdOfASide(bottomleftPoint,p4), depth-1);
            DrawSquare(graphics, ThirdOfASide(middleLeftPoint,p1), ThirdOfASide(middleLeftPoint,p2), ThirdOfASide(middleLeftPoint,p3), ThirdOfASide(middleLeftPoint,p4), depth-1);

        }
        
    }

    public static Point2D ThirdOfASide(Point2D p1, Point2D p2){
        return new Point((int)(2*p1.getX() + p2.getX())/3,(int)(2*p1.getY() + p2.getY())/3 );
    }
    public static Point2D MidPointOfASide(Point2D p1, Point2D p2){
        return new Point((int)(p1.getX() + p2.getX())/ 2, (int)(p1.getY() + p2.getY()) / 2 );
    }

    public static double DistanceOfTwoPoints(Point2D p1, Point2D p2){
            double keplet1fele = Math.pow((p1.getX()-p2.getX()), 2);
            double keplet2fele = Math.pow((p1.getY()-p2.getY()), 2);

            return Math.sqrt(keplet1fele + keplet2fele);
    }

    // ezt a részt nem kell módosítani
    static int WIDTH = 900;
    static int HEIGHT = 900;

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

