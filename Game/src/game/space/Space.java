package game.space;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.AlphaComposite;
import java.awt.GraphicsConfiguration;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

import game.MovablePanel;
import game.Shared;
import game.IPane;
import game.Engine;
import game.Missile;
import game.Ship;
import game.Crash;
import game.invader.Invader;

public class Space extends JPanel implements KeyListener, IPane {

    private static final String BACKGROUND = "ezgif-save (8).gif";

    private Image image;

    public Space() {
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Shared.SPACE_WIDTH, Shared.SPACE_HEIGHT));

        // Set the bounds because of the null layout of the parent
        // setBounds(x, y, Shared.SPACE_WIDTH, Shared.SPACE_WIDTH);
        ImageIcon icon = new ImageIcon(this.getClass().getResource(BACKGROUND));
        BufferedImage bufferedImage = new BufferedImage(
            icon.getIconWidth(),
            icon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB
        );
        Graphics graphics = bufferedImage.createGraphics();
        graphics.setColor(new Color(0, 0, 0, 0));
        image = icon.getImage();
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // Set alpha transparency
        // Graphics2D graphics2D = (Graphics2D) graphics;
        // graphics2D.setComposite(AlphaComposite.Clear);
        // graphics2D.setComposite(AlphaComposite.Src);

        // this.setBackground(new Color(0,0,0,0));

        // AlphaComposite ac = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,1F);

        // graphics2D.setComposite(ac);

        // see javadoc for more info on the parameters
        graphics.drawImage(image, 0, 0, null);
    }

   
    public void moveInvadersDown(ArrayList<Invader> invaders) {
        for (Invader invader : invaders) {
            invader.moveDown();
        }
    }

    public void moveMissilesUp(ArrayList<Missile> missiles) {
        for (Missile missile: missiles) {
            missile.moveUp();
        }
    }

   
  //  @Override
    public void keyTyped(KeyEvent event) {

        
    }

  //  @Override
    public void keyPressed(KeyEvent event) {
        // Notify the panel of the event
        int keyCode = event.getKeyCode();
       Ship ship = Engine.getInstance().getShip();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                ship.moveLeft();
            break;

            case KeyEvent.VK_UP:
                ship.moveUp();
            break;

            case KeyEvent.VK_RIGHT:
                ship.moveRight();
            break;

            case KeyEvent.VK_DOWN:
                ship.moveDown();
            break;

            case KeyEvent.VK_SPACE:
                Engine.getInstance().addMissile(new Missile(
                    ship.getX() + (int) ship.getPreferredSize().getWidth() / 2,
                    ship.getY()
                ));
            break;
        }
        
        
    }

   // @Override
    public void keyReleased(KeyEvent event) {
        
    }

    public void addCrash(Crash newCrash){
        add(newCrash);
        revalidate();
        repaint();
    }
}