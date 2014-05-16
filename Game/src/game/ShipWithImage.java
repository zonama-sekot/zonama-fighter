package game;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;

public class ShipWithImage extends JPanel {

    int x = Shared.SPACE_WIDTH / 2, y = Shared.SPACE_HEIGHT - 64, velX = 0, velY = 0; // Position of the rectangle by default.
                                         // The rectangle will be into the top left corner from the window.
                                          // velX is the speed of rectangle horizontaly.
                                          // velY is the speed of rectangle by Y.
    String fileName = "spaceship.png";
    java.awt.Image img = getToolkit().getImage(fileName);
    
    public ShipWithImage() {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(fileName));
        img = icon.getImage();

        Dimension dim = new Dimension(64, 64);
        setPreferredSize(dim);
    }
    
    public void paintComponent(Graphics g) {

    	super.paintComponent(g);
//        g.setColor(Color.RED); // Set the color of rectangle to Red.
//        g.fillRect(x, y, 50, 30); // The real size of the movement object. In our case this is rectangle.
    	g.drawImage(img, 0, 0, null);
    	
    }

    public void moveLeft() {
      velX = -1;
      velY = 0;
      performMove();
    }

    public void moveRight() {
      velX = 1;
      velY = 0;
      performMove();
    }

    public void moveUp() {
      velX = 0;
      velY = -1;
      performMove();
    }

    public void moveDown() {
      velX = 0;
      velY = 1;
      performMove();
    }
    
    public void reset() {
      velX = 0;
      velY = 0;
    }

    //Here we start to use ActionListener interface.
    public void performMove() {
       // Restrictions for rectangle movement into to whole area.
       if (x < 0) {//if the rectangle on the left side on the screen and outside of the visible area.
         velX = 0;
         x = 0;
       }
       
       if (x > 530) { //if the rectangle is on the right side on the screen and outside of the visible area.
         velX = 0;
         x = 530;
       }
         
      if (y < 0) {
         velY = 0;
         y = 0;
       }
       
      if (y > 330) {
         velY = 0;
         y = 330;
       }
       
       
        x = x + velX; // This refer to the movement. Example: x = 1 + 0, then x = 1. See if cases before with define values.
        y = y + velY;
        
        repaint();
    }
}