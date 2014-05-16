package game;

import javax.swing.JPanel;

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
     * 
     */
    protected void performMove() {
        x += directionX * speed;
        y += directionY * speed;
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