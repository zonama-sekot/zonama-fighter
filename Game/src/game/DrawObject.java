package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class DrawObject extends JFrame {

	public int x;
	public int y;
	private Image imageBuff;
	private Graphics graphicBuff;
	//GamePanel gPanel;

	public DrawObject() {
		addKeyListener(new keyValue());
		//gPanel=new GamePanel();
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		//add(gPanel);
		x=10;
		y=10;

	}

	public class keyValue extends KeyAdapter{

		public void keyPressed(KeyEvent e){
			int key=e.getKeyCode();

			if (key==KeyEvent.VK_LEFT){

				x--;
			}
			if (key==KeyEvent.VK_RIGHT){

				x++;

			}
			if (key==KeyEvent.VK_UP){

				y--;
			}
			if (key==KeyEvent.VK_DOWN){
				y++;
			}
		}

		public void keyReleased(KeyEvent e){

		}

		public void keyTyped(KeyEvent e){

		}
	};

	public void paint(Graphics g){
		imageBuff=createImage(getWidth(),getHeight());
		 graphicBuff=imageBuff.getGraphics();
		 paintComponent(graphicBuff);
		 g.drawImage(imageBuff,0,0,this);
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.green);
		g.fillRect(x, y, 10, 10);
		repaint();
	}
}
