package game;

import java.awt.Dimension;
import java.util.ArrayList;

import game.Shared;
import game.MovablePanel;
import game.space.Space;
import game.invader.Invader;

/**
 * I am a missile.
 * I am a MovablePanel:
 *   * I move
 *   * I have a position (x,y)
 *   * I have a direction (x,y)
 *   * I have a speed (pixels in direction per move)
 *
 * I have the looks of a missile as well (with an Image).
 */
public class Missile extends MovablePanel {

    /**
     * Constant holding the relative path to the missile image
     */
    private static final String ICON = "missile.png";

    /**
     * Constructor to initialize the missile.
     *
     * Set the Image instance from the ICON.
     * Set the preferred size with Dimension based on the Shared constants.
     * Position at the top of the space at random column.
     * Make visible.
     */
    public Missile(int x, int y) {
        setPreferredSize(new Dimension(Shared.MISSILE_WIDTH, Shared.MISSILE_HEIGHT));
        setImageFromPath(getImagePath());

        // Default position of the missile should
        // take into consideration its own width and height
        this.x = x - Shared.MISSILE_WIDTH / 2;
        this.y = y - Shared.MISSILE_HEIGHT / 2;

        setVisible(true);
        setSpeed(Shared.MISSILE_SPEED);
    }

    public String getImagePath() {
        return ICON;
    }

    /**
     * Overriden method from MovablePanel.
     * The missile should move only it is visible - no need to move it after
     * it left the space or hit an invader
     *
     * This will hide the missile if it left the space after super.performMove()
     *
     * It will also check if it hit an invader.
     * If it did it will kill the invader (hide it) and it will hide itself
     */
    @Override
    protected void performMove() {
        if (!isVisible()) {
            return;
        }

        super.performMove();

        // If below bottom side or completely after the side edges -
        // hide the invader
        //
        // **NOTE**: Not checking the top side at the moment for simplicity
        // The invader should not go up and it's actually coming from the top
        // side and it should be visible initially
        if (y < Shared.MISSILE_HEIGHT) {
            setVisible(false);
        } else {

            ArrayList<Invader> invaders = Engine.getInstance().getInvaders();

            for (Invader invader : invaders) {
                if (invader.isVisible()
                    && invader.checkCollision(this)) {
                    invader.setVisible(false);
                    setVisible(false);
                }
            }
        }
    }
}
