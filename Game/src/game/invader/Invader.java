package game.invader;

import java.awt.*;
import javax.swing.*;

public class Invader extends JPanel {

    public static final Color DEFAULT_BACKGROUND = Color.MAGENTA;

    public static final int WIDTH = 10;

    public static final int HEIGHT = 10;

    public static final int DEFAULT_STEP = HEIGHT;

    int step = DEFAULT_STEP;

    int x = 0;

    int y = 0;

    public Invader() {
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
	
    public int getStep() {
        return step;
    }

    public Invader setStep(int step) {
        this.step = step;
        return this;
    }

    public void setX(int x) {
        System.out.printf("New column: %s\n", x);
        this.x = x;
    }

    public Invader moveDown() {
        y += step;
        repaint();
        System.out.printf("Position  : %d, %d\n", x, y);
        return this;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(x, y, WIDTH, HEIGHT);
    }
}
