package game.space;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

import game.Missile;
import game.Shared;
import game.IDimensional;
import game.ShipWithImage;
import game.invader.Invader;

/**
 * I am a space panel - the single JPanel living inside the Space.
 *
 * I tick with a Timer and the ActionListener interface.
 * I hold invaders with ArrayList<Invader>
 * I hold a ship.
 * I accept KeyEvent and pass movements to the ship.
 * When I tick:
 *  - I move invaders down the space.
 *  - I create new invaders (not every tick)
 */
public class SpacePanel extends JPanel implements ActionListener, IDimensional {

    /**
     * The Timer instance which I use to tick.
     */
    protected Timer timer;

    /**
     * All the invaders on the SpacePanel.
     */
    protected ArrayList<Invader> invaders = new ArrayList<Invader>();
    protected ArrayList<Missile> missiles = new ArrayList<Missile>();

    /**
     * Total count of the ticks
     * I use it to create an invader
     * every other `Shared.NEW_INVADER_THRESHOLD` time.
     */
    private int totalMomentsCount = 0;

    /**
     * My dimensions
     */
    private Dimension dimension;

    /**
     * The ship which I move
     */
    private ShipWithImage ship;

    /**
     * Initialize the SpacePanel:
     *  - setDoubleBuffered for better painting and no flickering
     *  - set background
     *  - set the size
     *  - create and add the ship
     *  - start the timer
     */
    public SpacePanel() {
        setDoubleBuffered(true);
        setBackground(Color.BLACK);

        dimension = new Dimension(Shared.SPACE_WIDTH, Shared.SPACE_HEIGHT);
        setPreferredSize(dimension);

        ship = new ShipWithImage();
        add(ship);

        timer = new Timer(Shared.TIMER_DELAY, this);
        timer.start();
    }

    /**
     * Add an invader to the SpacePanel
     * This will add it to both the panel and the invaders ArrayList
     *
     * @param Invader newInvader
     */
    public void addInvader(Invader newInvader) {
        invaders.add(newInvader);
        add(newInvader);
        revalidate();
        repaint();
    }

    public void addMissile(Missile newMissile) {
        missiles.add(newMissile);
        add(newMissile);
        revalidate();
        repaint();
    }

    /**
     * Get the dimension
     *
     * @return Dimension
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * Set the dimension
     *
     * @param Dimension
     */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * Get the ship
     *
     * @return ShipWithImage
     */
    public ShipWithImage getShip() {
        return ship;
    }

    /**
     * Get the timer
     *
     * @return Timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * Move all invaders down.
     * The invader objects should
     * take care of their own hiding if they leave the space.
     */
    public void moveInvadersDown() {
        for (Invader invader : invaders) {
        	if (invader.checkCollision(ship)) {
                invader.visible = false;
            }else{
            	invader.moveDown();
            }
        }
    }

    public void moveMissilesUp() {
        for (Missile missile: missiles) {
            missile.moveUp();
        	for (Invader invader : invaders) {
            	if (invader.checkCollision(missile)) {
                    invader.visible = false;
                    missile.visible = false;
            	}
            }
        }
    }

    /**
     * Called by the Timer because of the ActionListener interface
     *
     * Every tick I move the invaders down and create a new invader.
     *
     * @param ActionEvent event
     */
    public void actionPerformed(ActionEvent event) {
        totalMomentsCount++;
        moveInvadersDown();
        moveMissilesUp();
        if (shouldCreateInvader()) {
            addInvader(new Invader());
        }
        repaint();
    }

    /**
     * Check if new invader should be created and added to the space,
     * based on the number of ticks since the last one and a bit of randomness.
     *
     * @return boolean
     */
    protected boolean shouldCreateInvader() {
        // Check if the number of ticks (threshold) have passed
        if (totalMomentsCount % Shared.NEW_INVADER_THRESHOLD != 0) {
            return false;
        }

        // Add a bit of randomness so the invaders movement is not so droningly
        Random rand = new Random();
        int chance = rand.nextInt(100);

        return chance < Shared.NEW_INVADER_CHANCE;
    }

    /**
     * Pass a key event and it would call the correct move method on the fighter
     *
     * @param KeyEvent
     */
    public void notifyForKeyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();

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
                addMissile(new Missile(ship.getX() + (int) ship.getDimension().getWidth() / 2, ship.getY()));
            break;
        }
    }
}