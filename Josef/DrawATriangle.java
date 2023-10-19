import java.awt.*;
import javax.swing.*;

public class DrawATriangle extends JPanel {
    public void paintComponent(Graphics g) {
        int [] x = {25,50,0};
        int [] y = {0,50,50};
        //for(i = 0; i < 21; i++)
        //{}
            g.drawPolygon(x, y, 3);
        


        
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Triangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(600, 600);
      
        DrawATriangle panel = new DrawATriangle();
        frame.add(panel);
        frame.setVisible(true);
    }
}