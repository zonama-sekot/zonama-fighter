package game;

import java.awt.Dimension;
import java.util.Random;

import game.Shared;
import game.IPane;
import game.Engine;
import game.MovablePanel;
import game.space.Space;
import game.Ship;

public class Explosion extends MovablePanel {

    private static final String ICON = "explosion.gif";
    int xCoo, yCoo;
    
    public Explosion(int x, int y) {
        setImageFromPath(getImagePath());
        setPreferredSize(new Dimension(Shared.EXPLOSION_WIDTH, Shared.EXPLOSION_HEIGHT));
        xCoo = x;
        yCoo = y;
        //setSpeed(Shared.INVADER_SPEED);

        // Set the bounds because of the null layout of the parent
        setBounds(xCoo, yCoo, Shared.EXPLOSION_WIDTH, Shared.EXPLOSION_HEIGHT);
        setVisible(true);
    }

    public String getImagePath() {
        return ICON;
    }

    @Override
    protected void performMove() {
        if (!isVisible()) {
            return;
        }

        super.performMove();
        
            setVisible(false);
        

        if (!isVisible()) {
            Ship ship = Engine.getInstance().getShip();

           if (checkCollision(ship)) {
               setVisible(true);
           }
        }
    }
}
