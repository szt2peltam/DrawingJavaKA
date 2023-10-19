import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class triangle {
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
        Point2D p1 = new Point(0, 400);
        Point2D p2 = new Point(20, 400);
        Point2D p3 = new Point(10, 380);

        Polygon trianle = MakeTriangle(p1, p2, p3);

        DrawPyramid(trianle, 10, graphics);
    }


    public static Polygon MakeTriangle(Point2D p1, Point2D p2, Point2D p3){
        int[] xPoints = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX()};
        int[] yPoints = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY()};

        Polygon triangle = new Polygon(xPoints, yPoints, xPoints.length);
        return triangle;
    }

public static void DrawRowOfPolygon(Polygon polygon, int sizeOfRow, Graphics graphics){
    graphics.drawPolygon(polygon);
    double distance = DistanceOfTwoPoints(new Point(polygon.xpoints[0], polygon.ypoints[0]),
                                         new Point(polygon.xpoints[1], polygon.ypoints[1]));
    
    Polygon TranslatedPolygon = polygon;
    for (int i = 1; i < sizeOfRow; i++) {

        for (int j = 0; j < TranslatedPolygon.npoints; j++) {
            TranslatedPolygon.xpoints[j] += distance;
            

        }

        graphics.drawPolygon(TranslatedPolygon);
    }
}

public static void DrawPyramid(Polygon polygon, int initialSizeOfRow, Graphics graphics ){
    Polygon TranslatedPolygon = polygon;
    int[] originalxPoints = new int[polygon.npoints];

    for (int i = 0; i < originalxPoints.length; i++) {
        originalxPoints[i] = polygon.xpoints[i];
    }

    Point2D midpoint = MidPointOfASide(new Point(polygon.xpoints[0], polygon.ypoints[0]),
                                         new Point(polygon.xpoints[1], polygon.ypoints[1]));
 
    double heightdistance = DistanceOfTwoPoints(midpoint, new Point(TranslatedPolygon.xpoints[2], TranslatedPolygon.ypoints[2]));
    double distance = DistanceOfTwoPoints(new Point(polygon.xpoints[0], polygon.ypoints[0]),
                                         new Point(polygon.xpoints[1], polygon.ypoints[1]));

    for (int i = 1; i < initialSizeOfRow; i++) {

        DrawRowOfPolygon(TranslatedPolygon, initialSizeOfRow-i, graphics);
        for (int j = 0; j < TranslatedPolygon.npoints; j++) {
                    TranslatedPolygon.ypoints[j] -= heightdistance;
                    TranslatedPolygon.xpoints[j] = (int)originalxPoints[j] +(int) (distance/2)*i ;


        }


    }


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
    static int WIDTH = 400;
    static int HEIGHT = 400;

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