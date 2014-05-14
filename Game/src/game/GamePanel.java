/*package game;

import javax.swing.JPanel;



import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable{
	
	
	
	private Image  bufferImage;
	private Graphics graphics;
	
	private final int WINDOWWIDTH=500;
	private final int WINDOWHEIGHT=500;
	private final Dimension gameWindow=new Dimension(WINDOWWIDTH,WINDOWHEIGHT);
	
	private Thread game;
	private volatile Boolean running=false;
	
	public GamePanel(){
		setPreferredSize(gameWindow);
		setBackground(Color.black);
		setFocusable(true);
		requestFocus();
		
		/*addKeyListener(new KeyAdapter(){
			
			public void keyPresset(KeyEvent e){
				int key=e.getKeyCode();
				
				if (key==e.VK_LEFT){
					
					x--;
				}
				if (key==e.VK_RIGHT){
						
					x++;
					
				}
				if (key==e.VK_UP){
					
					y--;
				}
				if (key==e.VK_DOWN){
					y++;
				}
			}
			
			public void keyReleased(KeyEvent e){
				
			}
			
			public void keyTyped(KeyEvent e){
				
			}
		}); 
	}
	
	private void startGame(){
		if (game==null || !running) {
			game=new Thread(this);
			game.start();
			running=true;
		}
	}
	
	public void run(){
		while(running){
			gameUpdate();
			gameRender();
			paintScreen();
		}
	}
	
	private void gameUpdate(){
		if (running && game!=null) {
			//to do
		}
	}
	
	private void gameRender(){
		if (bufferImage==null) {
			bufferImage=createImage(WINDOWWIDTH,WINDOWHEIGHT);
			if (bufferImage==null) {
				System.err.println("bufferImage is still null!");
				return;
			} else {
				graphics=bufferImage.getGraphics();
			}
			//clear screen
			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, WINDOWWIDTH,WINDOWHEIGHT);
			//draw the object
			draw(graphics);
			
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.green);
		g.drawRect(x, y, 10, 5);
	}
	
	public void paintScreen(){
		Graphics g;
		
		try {
			g=this.getGraphics();
			
			if (bufferImage!=null && g!=null) {
				g.drawImage(bufferImage,x,y,null);
			}
			Toolkit.getDefaultToolkit().sync();//for some OS !
			g.dispose();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void addNotify(){
		super.addNotify();
		startGame();
	}
	
	public void stopGame(){
		if(running){
			running=false;
		}
	}
	
	
	

}*/

