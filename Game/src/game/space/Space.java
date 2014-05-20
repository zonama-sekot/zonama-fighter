package game.space;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.MovablePanel;
import game.Shared;
import game.IPane;
import game.Engine;
import game.Missile;
import game.Ship;
import game.invader.Invader;


public class Space extends  MovablePanel implements KeyListener, IPane {

	 private static final String ICON = "0Ground_DeepMoon_AniA3_16bit.gif";

	 Ship ship = Engine.getInstance().getShip();
    
    public Space() {
    	
    	 setImageFromPath(getImagePath());
    	 
         setDoubleBuffered(true);
         
        setBackground(Color.BLACK);
        
        setPreferredSize(new Dimension(Shared.SPACE_WIDTH, Shared.SPACE_HEIGHT));
        
       
        

        // Default Position of the fighter - center bottom
        x = 0;
        y = 0;
        speed = 0;
        
        // Set the bounds because of the null layout of the parent
        setBounds(x, y, Shared.SPACE_WIDTH, Shared.SPACE_WIDTH);
        
       
        
        JLabel myLabel = new JLabel();
        String  sText  = " SCORE        LIFE                                                                                                       ";
      myLabel.setBackground(Color.GRAY);
      myLabel.setOpaque(true);
       myLabel.setText (sText);
       myLabel.setLocation(x, 30);
       myLabel.setForeground(Color.GREEN);
       this.add(myLabel);
         
         
         
         
         
        
    }

   
    public void moveInvadersDown(ArrayList<Invader> invaders) {
        for (Invader invader : invaders) {
            invader.moveDown();
        }
    }

    public void moveMissilesUp(ArrayList<Missile> missiles) {
        for (Missile missile: missiles) {
            missile.moveUp();
        }
    }

   
  //  @Override
    public void keyTyped(KeyEvent event) {

    	
    }

  //  @Override
    public void keyPressed(KeyEvent event) {
        // Notify the panel of the event
        int keyCode = event.getKeyCode();
     //   Ship ship = Engine.getInstance().getShip();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                ship.moveLeft();
            break;

            case KeyEvent.VK_UP:
                ship.moveUp();
            break;

            case KeyEvent.VK_RIGHT:
                ship.moveRight();
            break;

            case KeyEvent.VK_DOWN:
                ship.moveDown();
            break;

            case KeyEvent.VK_SPACE:
                Engine.getInstance().addMissile(new Missile(
                    ship.getX() + (int) ship.getPreferredSize().getWidth() / 2,
                    ship.getY()
                ));
            break;
        }
        
        
    }

   // @Override
    public void keyReleased(KeyEvent event) {

    	
    	
    }

@Override
protected String getImagePath() {
	// TODO Auto-generated method stub
	return ICON;
}
}