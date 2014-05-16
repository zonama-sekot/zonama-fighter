package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.Shared;

public class Space extends JFrame implements KeyListener{

    public static final String TITLE = "Zonama Fighter";

    protected SpacePanel panel;

    public SpacePanel getPanel() {
        return this.panel;
    }

    public Space() {
        setTitle(Shared.NAME);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new SpacePanel();
        setContentPane(panel);

        setResizable(false);
        pack();
        setVisible(true);

        // This refer to KeyListener interface.
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode(); // Get the button from the keyboard.

        if (c == KeyEvent.VK_LEFT) { // for left key
        }

        if (c == KeyEvent.VK_UP) { // for up key
        }

        if (c == KeyEvent.VK_RIGHT) { // for right key
        }

        if (c == KeyEvent.VK_DOWN) { // for down key
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
