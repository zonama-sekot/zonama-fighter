package game;

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

/**
 * I am a MovablePanel:
 *  - I move
 *  - I have a position (x,y)
 *  - I have a direction (x,y)
 *  - I have a speed (pixels in direction per move)
 *
 * If you need my move behavior
 * you could ovveride my protected `performMove()` method.
 */
public abstract class MovablePanel extends JPanel implements IMovable, IPane {

    protected int directionX;
    
    protected int directionY;
    
    protected int x;
    
    protected int y;
    
    protected int speed;

    protected Image image;

    /**
     * {@inheritDoc}
     */
    public void moveLeft() {
        directionX = -1;
        directionY = 0;
        performMove();
    }
    
    /**
     * {@inheritDoc}
     */
    public void moveRight() {
        directionX = 1;
        directionY = 0;
        performMove();
    }
    
    /**
     * {@inheritDoc}
     */
    public void moveUp() {
        directionX = 0;
        directionY = -1;
        performMove();
    }
    
    /**
     * {@inheritDoc}
     */
    public void moveDown() {
        directionX = 0;
        directionY = 1;
        performMove();
    }

    /**
     * Perform the actual move
     */
    protected void performMove() {
        x += directionX * speed;
        y += directionY * speed;
    }

    /**
     * Get X coordinate
     *
     * @return int x
     */
    public int getX() {
        return x;
    }

    /**
     * Get Y coordinate
     *
     * @return int y
     */
    public int getY() {
        return y;
    }

    /**
     * Get X direction
     *
     * @return int directionX
     */
    public int getDirectionX() {
        return x;
    }

    /**
     * Get Y direction
     *
     * @return int directionY
     */
    public int getDirectionY() {
        return y;
    }

    /**
     * Get the moving speed
     *
     * @return int number of pixels per move
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set the moving speed
     * @param int speed number of pixels per move
     */
    public void setSpeed(int speed) {
        this.speed = speed;
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
     * Set the image instance.
     *
     * @return Image
     */
    protected void setImage(Image image) {
        this.image = image;
    }

    public void setImageFromPath(String path) {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(path));
        setImage(icon.getImage());
    }

    /**
     * Set BufferedImage with transparency on
     *
     * @param String path - local path to the image file
     */
    public void setBufferedImageFromPath(String path) {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(path));
        BufferedImage bufferedImage = new BufferedImage(
            icon.getIconWidth(),
            icon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB
        );
        Graphics graphics = bufferedImage.createGraphics();
        graphics.setColor(new Color(0, 0, 0, 0));
        setImage(icon.getImage());
    }

    protected abstract String getImagePath();

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

        // Set alpha transparency
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setComposite(AlphaComposite.Clear);
        graphics2D.setComposite(AlphaComposite.Src);

        // see javadoc for more info on the parameters
        graphics.drawImage(getImage(), 0, 0, null);
    }

    /**
     * Check if the panel collisions with something
     *
     * @param  IPane page the object to check collisions with
     * @return boolean
     */
    public boolean checkCollision(IPane pane) {
        int invaderWidth = (int) getPreferredSize().getWidth();
        int invaderHeight = (int) getPreferredSize().getHeight();
        int paneWidth = (int) pane.getPreferredSize().getWidth();
        int paneHeight = (int) pane.getPreferredSize().getHeight();

        return getX() < pane.getX() + paneWidth
            && getX() + invaderWidth > pane.getX()
            &&  getY() < pane.getY() + paneHeight
            && getY() + invaderHeight > pane.getY();
    }
}