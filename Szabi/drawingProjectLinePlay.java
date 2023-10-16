package Rajzolos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class drawingProjectLinePlay extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        
        g.setColor(Color.GREEN);
        int d = 0;
        while (d < height) {
            g.drawLine(0, d, d, height);
            d += 30;
        }
        
        g.setColor(Color.MAGENTA);
        int u = width;
        while (u > 0) {
            g.drawLine(width, u, u, 0);
            u -= 30;
        }
    }

    public static void main(String[] args) {
        drawingProjectLinePlay panel = new drawingProjectLinePlay();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel); 
        application.setSize(500, 500); 
        application.setVisible(true); 
    }
}
