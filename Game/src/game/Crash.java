package game;

import java.awt.Dimension;
import java.util.ArrayList;

import game.Shared;
import game.MovablePanel;
import game.space.Space;
import game.invader.Invader;

import java.awt.Graphics;

import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class Crash extends MovablePanel implements ActionListener {

   
    private static final String ICON = "Crash_Bomb2.gif";

    private Timer timer;;
    private int t;
    
    public Crash(int x_, int y_) {
    	
    	 setDoubleBuffered(true);
    	
    	
    	
        setPreferredSize(new Dimension(40, 40));
        setImageFromPath(getImagePath());

        // Default position of the missile should
        // take into consideration its own width and height
        
        this.x = x_  ;
        this.y = y_ ;

        setVisible(true);
        setSpeed(0);
        
        timer = new Timer(Shared.TIMER_DELAY, this);
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

       
     //  if(y<100){ this.setVisible(false);  }
       
       
       
       
       
    }
    
    
  

public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
	 t++;
	   if(t==5){setVisible(false);timer.stop(); this.remove(this);}
	
}
   
   
   
}

