package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import game.invader.Invader;

public class Space extends JFrame implements ActionListener {

    public static final String TITLE = "Zonama Fighter";

    public static final int WIDTH = 600;

    public static final int HEIGHT = 400;

    public static final int TIMER_DELAY = 100;

    protected ArrayList<Invader> invaders = new ArrayList<Invader>();

    protected Timer timer = new Timer(TIMER_DELAY, this);

    public static void main(String[] args) {
        new Space();
    }

    public static int getRandomColumn() {
        Random rand = new Random();
        return rand.nextInt(WIDTH - Invader.WIDTH);
    }

    public static Invader createInvader() {
        Invader invader = new Invader();
        invader.setX(Space.getRandomColumn());
        return invader;
    }

    public Space() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addInvader(Space.createInvader());
        setVisible(true);
        timer.start();
    }

    public void addInvader(Invader invader) {
        Container pane = getContentPane();
        pane.add(invader);
        invaders.add(invader);
    }

    public void moveInvaders() {
        for (Invader invader : invaders) {
            invader.moveDown();
        }
    }

    public void actionPerformed(ActionEvent event) {
        moveInvaders();
        addInvader(Space.createInvader());
    }
}
