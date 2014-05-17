package game;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class ShipWithImage extends MovablePanel implements IMovable {

    private static final String ICON = "spaceship.png";

    private Image image;
    private Dimension dim;

    public ShipWithImage() {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(ICON));
        image = icon.getImage();

        dim = new Dimension(Shared.FIGHTER_WIDTH, Shared.FIGHTER_HEIGHT);
        setPreferredSize(dim);

        // Default Position of the fighter - center bottom
        x = (Shared.SPACE_WIDTH - Shared.FIGHTER_WIDTH) / 2;
        y = Shared.SPACE_HEIGHT - Shared.FIGHTER_HEIGHT;
        speed = Shared.FIGHTER_SPEED;
    }

    public void paintComponent(Graphics graphics) {
    	super.paintComponent(graphics);
    	graphics.drawImage(image, 0, 0, null);
    }

    /**
     * Check if the fighter would stay in the area.
     * If yes perform the move from the super class.
     */
    @Override
    protected void performMove() {
        // If the fighter on the left side of the screen
        if (x <= 0 && directionX < 0) {
            directionX = 0;
            x = 0;
        }

        // If the fighter is on the right side of the screen
        int maxX = Shared.SPACE_WIDTH - (int) dim.getWidth();
        if (x >= maxX && directionX > 0) {
            directionX = 0;
            x = maxX;
        }

        // If the fighter is on the top side of the screen
        if (y <= 0 && directionY < 0) {
            directionY = 0;
            y = 0;
        }

        // If the fighter is on the bottom side of the screen
        int maxY = Shared.SPACE_HEIGHT - (int) dim.getHeight();
        if (y >= maxY && directionY > 0) {
            directionY = 0;
            y = maxY;
        }

        super.performMove();
    }
}