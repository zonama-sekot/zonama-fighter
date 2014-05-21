package game.space;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.AlphaComposite;
import java.awt.GraphicsConfiguration;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

import game.Shared;
import game.IPane;
import game.Missile;
import game.Crash;
import game.invader.Invader;

/**
 * I am the Space - the single JPanel living inside a frame.
 *
 * I accept KeyEvent and pass movements to the ship.
 * I could move invaders down and missiles up.
 */
public class Space extends JPanel implements IPane {

    private static final String BACKGROUND = "ezgif-save (8).gif";

    private Image image;

    public Space() {
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Shared.SPACE_WIDTH, Shared.SPACE_HEIGHT));
		setLayout(null);

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

	public void addCrash(Crash newCrash){
        add(newCrash);
        revalidate();
        repaint();
    }
}