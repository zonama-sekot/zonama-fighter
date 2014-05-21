package game;

import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

import game.Shared;
import game.MovablePanel;

public class Crash extends MovablePanel implements ActionListener {

    private static final String ICON = "Crash_Bomb2.gif";

    private Timer timer;
    
    public Crash(int x, int y) {
    	
        setDoubleBuffered(true);
    	
        setPreferredSize(new Dimension(Shared.CRASH_WIDTH, Shared.CRASH_HEIGHT));
        setBufferedImageFromPath(getImagePath());

        // Default position of the missile should
        // take into consideration its own width and height
        
        this.x = x - Shared.CRASH_WIDTH / 2;
        this.y = y - Shared.CRASH_HEIGHT / 2;

        timer = new Timer(100, this);
        setBounds(x, y, Shared.CRASH_WIDTH, Shared.CRASH_HEIGHT);
        setSpeed(0);
        setVisible(true);
        
        timer.start();
    }

    public String getImagePath() {
        return ICON;
    }

   @Override
   protected void performMove() {
        if (!isVisible()) {
            return;
        }

        super.performMove();
    }
    
    public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
        timer.stop();
    }
}

