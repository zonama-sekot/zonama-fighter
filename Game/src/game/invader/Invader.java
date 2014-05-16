package game.invader;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

import game.space.Space;
import game.Shared;

public class Invader extends JPanel {

    private static final String ICON = "invader.jpg";

    private int dx = 0;
    private int dy = 1;
    private int x;
    private int y;
    private int step = Shared.INVADER_STEP;
    private Image image;
    private boolean visible;
    private Dimension dim;

    public Invader() {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(ICON));
        image = icon.getImage();

        dim = new Dimension(Shared.INVADER_WIDTH, Shared.INVADER_HEIGHT);
        setPreferredSize(dim);

        x = getRandomColumn();
        y = 0;
        visible = true;

        //System.out.printf("New column: %s\n", x);
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

        if (y > Shared.SPACE_HEIGHT || (x > Shared.SPACE_WIDTH || (x - dim.getWidth()) < 0)) {
            visible = false;
            //System.out.printf("Hide invader at: %d, %d\n", x, y);
        }

        if (visible) {
            //System.out.printf("Position  : %d, %d\n", x, y);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // see javadoc for more info on the parameters
        g.drawImage(image, 0, 0, null);
    }

    private int getRandomColumn() {
        Random rand = new Random();
        return rand.nextInt(Shared.SPACE_WIDTH - (int) dim.getWidth());
    }
}
