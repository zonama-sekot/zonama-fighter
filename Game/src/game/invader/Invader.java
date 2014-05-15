package game.invader;

import java.awt.*;
import javax.swing.*;

public class Invader extends JPanel {

    public static final int DEFAULT_STEP = 1;

    public static final Color DEFAULT_BACKGROUND = Color.MAGENTA;

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    int step = DEFAULT_STEP;

    int x = 0;

    int y = 0;

    String content;
	
    public int getStep() {
        return step;
    }

    public Invader setStep(int step) {
        this.step = step;
        return this;
    }

    public void setX(int x) {
        System.out.println(x);
        this.x = x;
    }

    public Invader moveDown() {
        y += step;
        repaint();
        return this;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(x, y, WIDTH, HEIGHT);
    }
}
