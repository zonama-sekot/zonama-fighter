package game;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

import game.Shared;
import game.MovablePanel;
import game.space.SpacePanel;
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
     * Holding the Image instance of the missile.
     * It should be repainted on every paint (with paintComponent())
     * so it is always visible even if the missile moves.
     */
    private Image image;

    /**
     * Constructor to initialize the missile.
     *
     * Set the Image instance from the ICON.
     * Set the preferred size with Dimension based on the Shared constants.
     * Position at the top of the space at random column.
     * Make visible.
     */
    public Missile(int x, int y) {
        // Set an image
        ImageIcon icon = new ImageIcon(this.getClass().getResource(ICON));
        image = icon.getImage();

        // Invader defaults
        dimension = new Dimension(Shared.MISSILE_WIDTH, Shared.MISSILE_HEIGHT);
        setPreferredSize(dimension);

        this.x = x - Shared.MISSILE_WIDTH / 2;
        this.y = y - Shared.MISSILE_HEIGHT / 2;
        setVisible(true);
        setSpeed(Shared.MISSILE_SPEED);
    }

    /**
     * Get the image instance.
     *
     * @return Image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Overriden method from MovablePanel.
     * The invader should move only it is visible - no need to move it after
     * it left the space.
     *
     * This will hide the invader if it left the space after super.performMove()
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

            SpacePanel parent = (SpacePanel) getParent();
            ArrayList<Invader> invaders = parent.getInvaders();

            for (Invader invader : invaders) {
                if (invader.isVisible()
                    && invader.checkCollision(this)) {
                    invader.setVisible(false);
                    setVisible(false);
                }
            }
        }
    }

    /**
     * Perform additional paint operations on every JPanel repaint()
     * This is automatically called from the super class
     * when a repain should happen.
     *
     * It repaints the image so it is always visible.
     *
     * @param Graphics graphics
     */
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // see javadoc for more info on the parameters
        graphics.drawImage(image, 0, 0, null);
    }
}
