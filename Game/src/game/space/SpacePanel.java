package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import game.Shared;
import game.ShipWithImage;
import game.invader.Invader;

public class SpacePanel extends JPanel implements ActionListener, KeyListener {

    protected Timer timer;

    protected ArrayList<Invader> invaders = new ArrayList<Invader>();

    private int totalMomentsCount = 0;

    private Dimension dim;

    private ShipWithImage ship;

    public SpacePanel() {
        setFocusable(true);
        // Used shift key.
        setFocusTraversalKeysEnabled(false);

        // This refer to KeyListener interface.
        addKeyListener(this);

        setDoubleBuffered(true);
        setBackground(Color.BLACK);

        dim = new Dimension(Shared.SPACE_WIDTH, Shared.SPACE_HEIGHT);
        setPreferredSize(dim);

        ship = new ShipWithImage();
        add(ship);
        revalidate();
        repaint();

        timer = new Timer(Shared.TIMER_DELAY, this);
        timer.start();
    }

    public void addInvader(Invader newInvader) {
        invaders.add(newInvader);
        add(newInvader);
        revalidate();
        repaint();
    }

    public Dimension getDimension() {
        return dim;
    }

    public void moveInvaders() {
        for (Invader invader : invaders) {
            invader.move();
        }
    }

    public void actionPerformed(ActionEvent event) {
        moveInvaders();
        totalMomentsCount++;
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (totalMomentsCount % Shared.NEW_INVADER_THRESHOLD == 0 && chance < Shared.NEW_INVADER_CHANCE) {
            addInvader(new Invader());
        }
        repaint();
    }

    public void keyPressed(KeyEvent event) {
        // Get the button from the keyboard.
        int keyCode = event.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                ship.moveLeft();
            break;

            case KeyEvent.VK_RIGHT:
                ship.moveRight();
            break;

            case KeyEvent.VK_UP:
                ship.moveUp();
            break;

            case KeyEvent.VK_DOWN:
                ship.moveDown();
            break;
        }

        revalidate();
        repaint();
    }
    
    public void keyTyped(KeyEvent event) {
        // none
    }
    public void keyReleased(KeyEvent event) {
        ship.reset();
    }

}
