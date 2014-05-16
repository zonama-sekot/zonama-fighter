package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import game.invader.Invader;

public class Space extends JFrame implements KeyListener{

    public static final String TITLE = "Zonama Fighter";

    public static final int WIDTH = 600;

    public static final int HEIGHT = 400;

    protected SpacePanel panel;

    public SpacePanel getPanel(){
        return this.panel;
    }

    public static int getRandomColumn() {
        Random rand = new Random();
        return rand.nextInt(WIDTH - Invader.WIDTH);
    }

    public Space() {
        setLayout(new BorderLayout());
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new SpacePanel();
        setContentPane(panel);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);
        pack();
        setResizable(false);
        setVisible(true);
        panel.startTimer();

        addKeyListener(this); // This refer to KeyListener interface.
    }

    public void addInvaders(int invadersCount){
        for (int i = 0; i < invadersCount; i++) {
            this.getPanel().addInvader(Invader.createInvader());
        }
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
