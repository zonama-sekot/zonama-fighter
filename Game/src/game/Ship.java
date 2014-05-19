package game;

import java.awt.Graphics;
import java.awt.Dimension;

/**
 * I am a ship.
 * I am initially possitioned at the bottom center of the Space.
 * I move around, but I cannot leave the Space (extend MovablePanel)
 * I have the looks of a spacecraft with an Image.
 * I should shoot and kill invaders, *but not yet*.
 */
public class Ship extends MovablePanel {

    /**
     * Hold a relative path to the spaceship image.
     */
    private static final String ICON = "spaceship.gif";

    /**
     * Initialize the ship:
     *  - create and set the image from the path
     *  - set the size with a dimension
     *  - position at the bottom center of the space
     *  - set the initial speed
     */
    public Ship() {
        setPreferredSize(new Dimension(Shared.FIGHTER_WIDTH, Shared.FIGHTER_HEIGHT));

        // Default Position of the fighter - center bottom
        x = (Shared.SPACE_WIDTH - Shared.FIGHTER_WIDTH) / 2;
        y = Shared.SPACE_HEIGHT - Shared.FIGHTER_HEIGHT;
        speed = Shared.FIGHTER_SPEED;
        
        // Set the bounds because of the null layout of the parent
        setBounds(x, y, Shared.FIGHTER_WIDTH, Shared.FIGHTER_HEIGHT);
    }

    protected String getImagePath() {
        return ICON;
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
        int maxX = Shared.SPACE_WIDTH - (int) getPreferredSize().getWidth();
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
        int maxY = Shared.SPACE_HEIGHT - (int) getPreferredSize().getHeight();
        if (y >= maxY && directionY > 0) {
            directionY = 0;
            y = maxY;
        }

        super.performMove();
    }
}