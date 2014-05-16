package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import game.Shared;
import game.invader.Invader;

public class SpacePanel extends JPanel implements ActionListener {

    protected Timer timer;

    protected ArrayList<Invader> invaders = new ArrayList<Invader>();

    private int totalMomentsCount = 0;

    private Dimension dim;

    public SpacePanel() {
        setFocusable(true);
        setDoubleBuffered(true);
        setBackground(Color.BLACK);

        dim = new Dimension(Shared.SPACE_WIDTH, Shared.SPACE_HEIGHT);
        setPreferredSize(dim);

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
}
