package game.invader;

import game.space.Space;

import java.awt.*;
import javax.swing.*;

public class Invader extends JPanel {

    public static final int WIDTH = 20;

    public static final int HEIGHT = 20;

    public static final int DEFAULT_STEP = 1;

    private int step = DEFAULT_STEP;

    public static final String ICON = "invader.jpg";

    private int dx = 0;
    private int dy = 1;
    private int x = 0;
    private int y;
    private Image image;
    private boolean visible;

    public Invader() {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(ICON));
        image = icon.getImage();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        x = Space.getRandomColumn();
        y = 0;
        visible = true;

        System.out.printf("New column: %s\n", x);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public boolean isVisible() {
        return visible;
    }

    public void move() {
        if (!visible) {
            return;
        }

        x += dx * step;
        y += dy * step;

        if (y > Space.HEIGHT || (x > Space.WIDTH || (x - WIDTH) < 0)) {
            visible = false;
            System.out.printf("Hide invader at: %d, %d\n", x, y);
        }

        if (visible) {
            System.out.printf("Position  : %d, %d\n", x, y);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // see javadoc for more info on the parameters
        g.drawImage(image, 0, 0, null);
    }
}
