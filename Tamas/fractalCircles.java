package Tamas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class fractalCircles {
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
        int width = 300;
        int height = 300;
        int radius = height / 2;
        Point2D p1 = new Point((900/2)-radius, (900/2)-radius);
        DrawCircles(graphics, p1, width, height,radius,2);
    } 


    public static void DrawCircles(Graphics graphics, Point2D p1, int width, int height,int radius,  int depth){
        if(depth == 0){

            graphics.drawOval((int)p1.getX(),(int) p1.getY(), width, height);

        }else{
            graphics.drawOval((int)p1.getX(),(int) p1.getY(), width, height);
            Point2D topmid = new Point(450, 0);
            Point2D bottomRight = new Point(0, 900);
            // Point2D p2 = CenterPointOfNewCircle(p1, radius / 2 );
            Point2D p2 = MidPointOfASide(topmid,p1);
            p2 = TranslatePointDown(p2, (int)p2.getY());
            // p2 = MidPointOfASide()
            Point2D p3 = MidPointOfASide(bottomRight,p1);
            p3 = TranslatePointRightUp(p3, (int)p3.getX());
            Point2D p4 = CenterPointOfNewCircle(p1, radius / 2 );
            p4 = TranslatePointRight(p4, radius);
            DrawCircles(graphics, p2, radius, radius,radius / 2, depth - 1);
            DrawCircles(graphics, p3, radius, radius,radius / 2, depth - 1);
            // DrawCircles(graphics, p4, radius, radius,radius / 2,depth-1);

        }
        
    }
    
    public static Point2D  CenterPointOfNewCircle(Point2D p1,int radius){
        return new Point(450 - radius, 450-radius);
    }
    public static Point2D TranslatePointDown(Point2D p1, int radius){
        return new Point((int)(p1.getX()) ,(int) (p1.getY() + radius));
    }
    public static Point2D TranslatePointRightUp(Point2D p1, int radius){
        return new Point((int)(p1.getX()+radius) ,(int) ((p1.getY()-radius)));
    }
    public static Point2D TranslatePointRight(Point2D p1, int radius){
        return new Point((int)(p1.getX()+radius/2) ,(int) ((p1.getY())));
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

