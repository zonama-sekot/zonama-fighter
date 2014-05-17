package game;

public interface IMovable {

    /**
     * Move to the left
     */
    public void moveLeft();
    
    /**
     * Move to the right
     */
    public void moveRight();
    
    /**
     * Move to the up
     */
    public void moveUp();
    
    /**
     * Move to the down
     */
    public void moveDown();

    /**
     * Get the moving speed
     *
     * @return int number of pixels per move
     */
    public int getSpeed();

    /**
     * Set the moving speed
     * @param int speed number of pixels per move
     */
    public void setSpeed(int speed);
}