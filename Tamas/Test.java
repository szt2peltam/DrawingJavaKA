package Tamas;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Test {
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
        int step = size / 14;


        graphics.setColor(Color.red);
        graphics.drawLine(size, y, x, y + size);

        graphics.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        graphics.fillRect((int) (Math.random() * (WIDTH - size)), (int) (Math.random() * (HEIGHT - size)), size, size);

        graphics.setColor(Color.green);
        graphics.drawOval(x, y, size, size);


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