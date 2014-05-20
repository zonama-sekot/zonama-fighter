package game;

import java.awt.Dimension;




public class Crash extends MovablePanel {

   
    private static final String ICON = "0Crash_Hewit_AniA5_32b.gif";


    public Crash(int x, int y) {
    	
    	 setDoubleBuffered(true);
    	
    	
        setPreferredSize(new Dimension(50, 50));
        setImageFromPath(getImagePath());

        // Default position of the missile should
        // take into consideration its own width and height
        this.x = x  ;
        this.y = y ;

        setVisible(true);
        setSpeed(0);
        
        
        
    }

    public String getImagePath() {
        return ICON;
    }

   
}

