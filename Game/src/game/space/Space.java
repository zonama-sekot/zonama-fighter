package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.Shared;

/**
 * I am a space - the main entry to the ship and the invaders
 *
 * I hold a single SpacePanel and I resize to its size with pack().
 * (Found this to be listed as best practice - don't know why though :-/ )
 * I listen to keyboard events (wiht KeyListener)
 * and pass them to the SpacePanel.
 */
public class Space extends JFrame implements KeyListener {

    /**
     * The single SpacePanel I hold.
     */
    protected SpacePanel panel;

    /**
     * Get the space panel
     *
     * @return SpacePanel
     */
    public SpacePanel getPanel() {
        return this.panel;
    }

    /**
     * Initializing of the Space:
     *  - set title of the window
     *  - set background
     *  - exit the application when the frame is closed
     *  - create and set the SpacePanel to be the content pane of the frame
     *  - initialize the listenting to keys
     *  - disable resize
     *  - pack and show
     */
    public Space() {
        setTitle(Shared.NAME);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new SpacePanel();
        setContentPane(panel);

        setResizable(false);

        // This refers to the KeyListener interface.
        addKeyListener(this);

        pack();
        setVisible(true);
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
        this.getPanel().notifyForKeyPressed(event);
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
