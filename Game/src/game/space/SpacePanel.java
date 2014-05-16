package game.space;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import game.IInputHandler;
import game.Shared;
import game.invader.Invader;

public class SpacePanel extends JPanel implements ActionListener {

    protected Timer timer;

    protected ArrayList<Invader> invaders = new ArrayList<Invader>();
    protected ArrayList<IInputHandler> inputHandlers = new ArrayList<IInputHandler>();

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

    public void addInputHandler(IInputHandler inputHandler){
        this.inputHandlers.add(inputHandler);
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

    public void notifyForKeyPressed(KeyEvent e){

        System.out.print(e.getKeyCode());

        for(IInputHandler handler : this.inputHandlers){
            this.notifyHandlerForKey(e, handler);
        }
    }

    protected void notifyHandlerForKey(KeyEvent e, IInputHandler handler){

        int keyCode = e.getKeyCode();


        if (keyCode == KeyEvent.VK_LEFT) {
            handler.LeftArrowPressed();
        }
        else if (keyCode == KeyEvent.VK_UP) {
            handler.UpArrowPressed();
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            handler.RightArrowPressed();
        }
        else if (keyCode == KeyEvent.VK_DOWN) {
            handler.DownArrowPressed();
        }
        else{
            handler.KeyPressed(keyCode);
        }
    }

}
