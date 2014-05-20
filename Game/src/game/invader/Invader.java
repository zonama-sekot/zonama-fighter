package game.invader;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import game.Crash;
import game.Missile;
import game.Shared;
import game.IPane;
import game.Engine;
import game.MovablePanel;
import game.space.Space;
import game.Ship;

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
    private static final String ICON = "TInvader_lazur.gif";

    /**
     * Constructor to initialize the invader.
     *
     * Set the Image instance from the ICON.
     * Set the size with Dimension based on the Shared constants.
     * Position at the top of the space at random column.
     * Make visible.
     */
    public Invader() {
        setImageFromPath(getImagePath());
        setPreferredSize(new Dimension(Shared.INVADER_WIDTH, Shared.INVADER_HEIGHT));
        x = getRandomColumn();
        y = -40;
        setVisible(true);
        setSpeed(Shared.INVADER_SPEED);
    }

    public String getImagePath() {
        return ICON;
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
        if (y > Shared.SPACE_HEIGHT || (x > Shared.SPACE_WIDTH || (x - getPreferredSize().getWidth()) < 0)) {
            setVisible(false);
        }

        if (isVisible()) {
            Ship ship = Engine.getInstance().getShip();
      //     ArrayList<Invader> invader = Engine.getInstance().getInvaders();
            
           if (checkCollision(ship)) {
               Engine.getInstance().getPlayer().decreaseLives();
               setVisible(false);
               
              
          //   Engine.getInstance().addMissile(new Missile(150,150));
               
               
             Engine.getInstance().addCrash(new Crash( this.x, this.y));
               
               
               
           }
        }
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

        // Adding one because random.nextInt(100) is in [1..99] range in Java
        return rand.nextInt(Shared.SPACE_WIDTH + 1 - (int) getPreferredSize().getWidth());
    }
}
