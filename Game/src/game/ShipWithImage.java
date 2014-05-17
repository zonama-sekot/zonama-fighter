package game;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;

public class ShipWithImage extends MovablePanel implements IMovable {

    private static final String ICON = "spaceship.png";

    private Image image;
    private Dimension dim;

    public ShipWithImage() {

        // Default Position of the fighter - center bottom
        x = Shared.SPACE_WIDTH / 2;
        y = Shared.SPACE_HEIGHT - Shared.SPACE_HEIGHT;

        ImageIcon icon = new ImageIcon(this.getClass().getResource(ICON));
        image = icon.getImage();

        dim = new Dimension(Shared.FIGHTER_WIDTH, Shared.FIGHTER_HEIGHT);
        setPreferredSize(dim);
    }

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(image, 0, 0, null);
    }

    /**
     * Check if the fighter would stay in the area.
     * If yes perform the move from the super class.
     */
    @Override
    public void performMove() {
        // If the fighter on the left side of the screen
        if (x < 0) {
            directionX = 0;
            x = 0;
        }

        // If the fighter is on the right side of the screen
        int maxX = Shared.SPACE_WIDTH - (int) dim.getWidth();
        if (x > maxX) {
            directionX = 0;
            x = maxX;
        }

        // If the fighter is on the top side of the screen
        if (y < 0) {
            directionY = 0;
            y = 0;
        }

        // If the fighter is on the bottom side of the screen
        int maxY = Shared.SPACE_HEIGHT - (int) dim.getHeight();
        if (y > maxY) {
            directionY = 0;
            y = maxY;
        }

        super.performMove();

        repaint();
    }
}