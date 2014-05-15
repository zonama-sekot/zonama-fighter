import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Movement extends JPanel implements ActionListener, KeyListener{ // Implement two interfaces ActionListener and KeyListener.

   Timer tm = new Timer(5, this); //Timer object is used for animation. This is refer to ActionListener
    int x = 0, y = 0, velX = 0, velY = 0; // Position of the rectangle by default.
                                         // The rectangle will be into the top left corner from the window.
                                          // velX is the speed of rectangle horizontaly.
                                          // velY is the speed of rectangle by Y.
    public Movement() {
       tm.start();    // start the timer. Here we began the animation process.
        addKeyListener(this); // This refer to KeyListener interface.
        setFocusable(true); // Enable the KeyListener.
        setFocusTraversalKeysEnabled(false); // Used shift key.
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        g.setColor(Color.RED); // Set the color of rectangle to Red.
        g.fillRect(x, y, 50, 30); // The real size of the movement object. In our case this is rectangle.
    }
    
    //Here we start to use ActionListener interface.
    public void actionPerformed(ActionEvent e) {
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
    
    public void keyPressed(KeyEvent e) {
       int c = e.getKeyCode(); // Get the button from the keyboard.
       
       if (c == KeyEvent.VK_LEFT) { // for left key
        velX = -1;
        velY = 0;
       }
       
       if (c == KeyEvent.VK_UP) { // for up key
        velX = 0;
        velY = -1;
       }
       
       if (c == KeyEvent.VK_RIGHT) { // for right key
        velX = 1;
        velY = 0;
       }
       
       if (c == KeyEvent.VK_DOWN) { // for down key
        velX = 0;
        velY = 1;
       }
    }
    
    public void keyTyped(KeyEvent e) {
        //none
    }
    public void keyReleased(KeyEvent e) {
       velX = 0;
       velY = 0;
    }
    
    
    public static void main (String[] args) {
        Movement t = new Movement(); // Movement class is extended to the JPanel.
        //Created JFrame to the program.
        JFrame jf = new JFrame();
        jf.setTitle("Movement");
        jf.setSize(600, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);
        jf.setVisible(true);
    }
}
