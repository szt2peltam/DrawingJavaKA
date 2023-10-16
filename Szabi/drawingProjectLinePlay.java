package Szabi;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class drawingProjectLinePlay {
    public static void drawImage(Graphics graphics) {
        int size = WIDTH / 2;
        /*
        graphics.setColor(new Color(0, 49, 63));
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.setColor(Color.yellow);
        */
        drawingprojectLinePlay(0, 0, size, graphics);
    }

    public static void drawingprojectLinePlay(int x, int y ,int size, Graphics graphics) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 320;
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 16; i++) {
            graphics.drawLine(x1, y1, x2, y2);
            y1 += 20;
            x2 += 20;
        }

        int x1f = 320;
        int y1f = 320;
        int x2f = 320;
        int y2f = 0;
        graphics.setColor(Color.MAGENTA);
        for (int i = 0; i < 16; i++) {
            graphics.drawLine(x1f, y1f, x2f, y2f);
            y1f -= 20;
            x2f -= 20;
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
