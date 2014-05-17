package game.invader;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

import game.space.Space;
import game.Shared;
import game.MovablePanel;

public class Invader extends MovablePanel {

    private static final String ICON = "invader.jpg";

    private Image image;
    private boolean visible;
    private Dimension dim;

    public Invader() {
        // Set an image
        ImageIcon icon = new ImageIcon(this.getClass().getResource(ICON));
        image = icon.getImage();

        // Invader defaults
        dim = new Dimension(Shared.INVADER_WIDTH, Shared.INVADER_HEIGHT);
        setPreferredSize(dim);

        x = getRandomColumn();
        y = 0;
        visible = true;
        setSpeed(Shared.INVADER_SPEED);
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

    @Override
    protected void performMove() {
        if (!visible) {
            return;
        }

        super.performMove();

        // If below bottom side or completely after the side edges - 
        // hide the invader
        // 
        // **NOTE**: Not checking the top side at the moment for simplicity
        // The invader should not go up and it's actually coming from the top
        // side and it should be visible initially 
        if (y > Shared.SPACE_HEIGHT || (x > Shared.SPACE_WIDTH || (x - dim.getWidth()) < 0)) {
            visible = false;
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
