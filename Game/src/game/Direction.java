package game;

import java.awt.event.KeyEvent;

public enum Direction {

    UP (KeyEvent.VK_UP, 0, -1),
    
    DOWN (KeyEvent.VK_DOWN, 0, 1),
    
    LEFT (KeyEvent.VK_LEFT, -1, 0),
    
    RIGHT (KeyEvent.VK_RIGHT, 1, 0),

    SHOOT (KeyEvent.VK_SPACE, 0, 0);

    private int keyCode;

    private int xDirection;

    private int yDirection;

    private Direction(int keyCode, int xDirection, int yDirection) {
        this.keyCode = keyCode;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public int getXDirection() {
        return xDirection;
    }

    public int getYDirection() {
        return yDirection;
    }
}
