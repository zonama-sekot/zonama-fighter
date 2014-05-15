package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import game.invader.Invader;

public class Space extends JFrame {

    public static final String TITLE = "Zonama Fighter";

    public static final int WIDTH = 600;

    public static final int HEIGHT = 400;

    protected SpacePanel panel;

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
        setLayout(new BorderLayout());
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new SpacePanel();
        setContentPane(panel);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);
        panel.addInvader(Space.createInvader());
        pack();
        setResizable(false);
        setVisible(true);
        panel.startTimer();
    }
}
