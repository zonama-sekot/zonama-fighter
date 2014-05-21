package game.space;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import game.Shared;
import game.IPane;
import game.Missile;
import game.invader.Invader;

/**
 * I am the Space - the single JPanel living inside a frame.
 *
 * I accept KeyEvent and pass movements to the ship.
 * I could move invaders down and missiles up.
 */
public class Space extends JPanel implements IPane {

    /**
     * Initialize the Space:
     *  - setDoubleBuffered for better painting and no flickering
     *  - set background
     *  - set the size
     */
    public Space() {
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Shared.SPACE_WIDTH, Shared.SPACE_HEIGHT));
        setLayout(null);
    }

    /**
     * Move all invaders down.
     * The invader objects should
     * take care of their own hiding if they leave the space.
     */
    public void moveInvadersDown(ArrayList<Invader> invaders) {
        for (Invader invader : invaders) {
            invader.moveDown();
        }
    }

    public void moveMissilesUp(ArrayList<Missile> missiles) {
        for (Missile missile: missiles) {
            missile.moveUp();
        }
    }
}