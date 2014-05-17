package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.Shared;

public class Space extends JFrame implements KeyListener {

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

        // This refers to the KeyListener interface.
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        this.getPanel().notifyForKeyPressed(event);
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
