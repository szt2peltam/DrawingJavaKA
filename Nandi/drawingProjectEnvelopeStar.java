package DrawingJavaKA.Nandi;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class drawingProjectEnvelopeStar {
    public static void drawImage(Graphics graphics) {
        int size = WIDTH / 2;
        
        drawSomething(0, 0, size, graphics);
    }

    public static void drawSomething(int x, int y ,int size, Graphics graphics) {
        int x1=160;
        int y1=0;
        int x2=160;
        int y2=160;
        for(int i=0;i<16;i++){ //első fele
            graphics.drawLine(x1, y1, x2, y2);
            y1+=10;
            x2+=10;

        }

        x1=160;
        y1=320;
        x2=160;
        y2=160;
        for(int i=0;i<16;i++){ //második fele
            graphics.drawLine(x1, y1, x2, y2);
            y1-=10;
            x2+=10;

        }

        x1=160;
        y1=320;
        x2=160;
        y2=160;
        for(int i=0;i<16;i++){ //harmadik fele
            graphics.drawLine(x1, y1, x2, y2);
            y1-=10;
            x2-=10;

        }

        x1=160;
        y1=0;
        x2=160;
        y2=160;
        for(int i=0;i<16;i++){ //negyedik fele
            graphics.drawLine(x1, y1, x2, y2);
            y1+=10;
            x2-=10;

        }


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