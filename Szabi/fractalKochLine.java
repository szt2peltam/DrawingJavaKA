package Szabi;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class fractalKochLine {
    public static void drawImage(Graphics graphics) {
        int size = WIDTH;

        int x1 = (WIDTH - size) / 2;
        int y1 = HEIGHT / 2;
        int x5 = x1 + size;
        int y5 = y1;

        fractalkochLine(x1, y1, x5, y5, graphics, 3); 
    }

    public static void fractalkochLine(int x1, int y1, int x5, int y5, Graphics graphics, int depth) {
        if (depth == 0) {
            graphics.drawLine(x1, y1, x5, y5);
        } else {
            int deltaX = (x5 - x1) / 3;
            int deltaY = (y5 - y1) / 3;

            int x2 = x1 + deltaX;
            int y2 = y1 + deltaY;
            int x3 = (int) (x2 + (deltaX * Math.cos(Math.PI / 3) + deltaY * Math.sin(Math.PI / 3)));
            int y3 = (int) (y2 - (deltaX * Math.sin(Math.PI / 3) - deltaY * Math.cos(Math.PI / 3)));
            int x4 = x1 + 2 * deltaX;
            int y4 = y1 + 2 * deltaY;

            fractalkochLine(x1, y1, x2, y2, graphics, depth - 1);
            fractalkochLine(x2, y2, x3, y3, graphics, depth - 1);
            fractalkochLine(x3, y3, x4, y4, graphics, depth - 1);
            fractalkochLine(x4, y4, x5, y5, graphics, depth - 1);
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
