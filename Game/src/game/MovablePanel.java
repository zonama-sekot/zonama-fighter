package game;

import javax.swing.JPanel;

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
public abstract class MovablePanel extends JPanel implements IMovable {

    protected int directionX;
    
    protected int directionY;
    
    protected int x;
    
    protected int y;
    
    protected int speed;

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

}