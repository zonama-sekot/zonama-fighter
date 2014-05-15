package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import game.invader.Invader;

public class SpacePanel extends JPanel implements ActionListener {

    public static final int TIMER_DELAY = 1000;

    protected Timer timer = new Timer(TIMER_DELAY, this);

    protected ArrayList<Invader> invaders = new ArrayList<Invader>();

    LayoutManager layout = new BorderLayout();

    public SpacePanel() {
        setLayout(layout);
    }

    public void addInvader(Invader newInvader) {
        invaders.add(newInvader);
        setLayout(layout);
        add(newInvader);
        revalidate();
        repaint();
    }

    public void moveInvaders() {
        for (Invader invader : invaders) {
            invader.moveDown();
            if (invader.getY() > HEIGHT) {
                invaders.remove(invader);
            }
        }
    }

    public void startTimer() {
        timer.start();
    }

    public void actionPerformed(ActionEvent event) {
        moveInvaders();
        addInvader(Space.createInvader());
    }
}
