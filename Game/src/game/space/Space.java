package game.space;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;

import game.Shared;
import game.IPane;
import game.Engine;
import game.Missile;
import game.Ship;
import game.invader.Invader;

/**
 * I am the Space - the single JPanel living inside a frame.
 *
 * I accept KeyEvent and pass movements to the ship.
 * I could move invaders down and missiles up.
 */
public class Space extends JPanel implements KeyListener, IPane {

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

    /*
     * KeyListener methods
     * ====================
     *
     * We need to catch only the keyPressed
     */

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        // Notify the panel of the event
        int keyCode = event.getKeyCode();
        Ship ship = Engine.getInstance().getShip();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                ship.moveLeft();
            break;

            case KeyEvent.VK_UP:
                ship.moveUp();
            break;

            case KeyEvent.VK_RIGHT:
                ship.moveRight();
            break;

            case KeyEvent.VK_DOWN:
                ship.moveDown();
            break;

            case KeyEvent.VK_SPACE:
                Engine.getInstance().addMissile(new Missile(
                    ship.getX() + (int) ship.getPreferredSize().getWidth() / 2,
                    ship.getY()
                ));
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}