package game;

import java.awt.Dimension;
import java.util.ArrayList;

import game.Shared;
import game.MovablePanel;
import game.space.Space;
import game.invader.Invader;


public class Missile extends MovablePanel {

   
    private static final String ICON = "TShip_bomb.gif";

   
    public Missile(int x, int y) {
        setPreferredSize(new Dimension(Shared.MISSILE_WIDTH, Shared.MISSILE_HEIGHT));
        setImageFromPath(getImagePath());

        // Default position of the missile should
        // take into consideration its own width and height
        this.x = x - Shared.MISSILE_WIDTH/2 ;
        this.y = y - Shared.MISSILE_HEIGHT/2;

        setVisible(true);
        setSpeed(Shared.MISSILE_SPEED);
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

        
        
        if (y < Shared.MISSILE_HEIGHT) {
            setVisible(false);
        } else {

            Engine engine = Engine.getInstance();
            ArrayList<Invader> invaders = engine.getInvaders();

            for (Invader invader : invaders) {
                if (invader.isVisible() && invader.checkCollision(this)) {
                    invader.setVisible(false);
                    setVisible(false);
                    engine.getPlayer().increasePoints();
                    
                    Engine.getInstance().addCrash(new Crash( this.x, this.y));
                    
                }
            }
        }
    }
}
