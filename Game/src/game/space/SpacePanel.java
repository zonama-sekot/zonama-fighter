package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import game.invader.Invader;

public class SpacePanel extends JPanel implements ActionListener {

    public static final int TIMER_DELAY = 10;

    protected Timer timer = new Timer(TIMER_DELAY, this);

    protected ArrayList<Invader> invaders = new ArrayList<Invader>();

    private int totalMomentsCount = 0;

    public SpacePanel() {
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        timer.start();
    }

    public void addInvader(Invader newInvader) {
        invaders.add(newInvader);
        add(newInvader);
        revalidate();
        repaint();
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
        if (totalMomentsCount % 30 == 0 && chance < 80) {
            addInvader(new Invader());
        }
        repaint();
    }
}
