package game.invader;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

import game.Shared;
import game.IPane;
import game.MovablePanel;
import game.space.SpacePanel;
import game.ShipWithImage;

/**
 * I am an invader.
 * I am a MovablePanel:
 *   * I move
 *   * I have a position (x,y)
 *   * I have a direction (x,y)
 *   * I have a speed (pixels in direction per move)
 *
 * I fly from the top of the space to the bottom.
 * I can create myself at a random column of the space.
 * I have the looks of an invader as well (with an Image).
 */
public class Invader extends MovablePanel {

    /**
     * Constant holding the relative path to the invader image
     */
    private static final String ICON = "invader.jpg";

    /**
     * Holding the Image instance of the invader.
     * It should be repainted on every paint (with paintComponent())
     * so it is always visible even if the invader moves.
     */
    private Image image;

    /**
     * Constructor to initialize the invader.
     *
     * Set the Image instance from the ICON.
     * Set the preferred size with Dimension based on the Shared constants.
     * Position at the top of the space at random column.
     * Make visible.
     */
    public Invader() {
        // Set an image
        ImageIcon icon = new ImageIcon(this.getClass().getResource(ICON));
        image = icon.getImage();

        // Invader defaults
        dimension = new Dimension(Shared.INVADER_WIDTH, Shared.INVADER_HEIGHT);
        setPreferredSize(dimension);

        x = getRandomColumn();
        y = 0;
        setVisible(true);
        setSpeed(Shared.INVADER_SPEED);
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
        if (y > Shared.SPACE_HEIGHT || (x > Shared.SPACE_WIDTH || (x - dimension.getWidth()) < 0)) {
            setVisible(false);
        }

        if (isVisible()) {
            SpacePanel parent = (SpacePanel) getParent();
            ShipWithImage ship = parent.getShip();

           if (checkCollision(ship)) {
               parent.getTimer().stop();
           }
        }
    }


    /**
     * Check if the invader collisions with something
     *
     * @param  IPane page the object to check collisions with
     * @return boolean
     */
    public boolean checkCollision(IPane pane) {
        Dimension paneDimension = pane.getDimension();
        int invaderWidth = (int) dimension.getWidth();
        int invaderHeight = (int) dimension.getHeight();
        int paneWidth = (int) paneDimension.getWidth();
        int paneHeight = (int) paneDimension.getHeight();

        return getX() < pane.getX() + paneWidth
            && getX() + invaderWidth > pane.getX()
            &&  getY() < pane.getY() + paneHeight
            && getY() + invaderHeight > pane.getY();
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

    /**
     * Get a random column in the space based on:
     *  - the space width
     *  - the invader width
     *  - God Random
     *
     * @return int a random positive integer in the bounds of the space
     */
    private int getRandomColumn() {
        Random rand = new Random();
        return rand.nextInt(Shared.SPACE_WIDTH - (int) dimension.getWidth());
    }
}
