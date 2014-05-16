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
        this.setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.panel.notifyForKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
