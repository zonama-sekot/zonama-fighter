package game;

import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;

import game.Direction;

/**
 * I am a ship.
 * I am initially possitioned at the bottom center of the Space.
 * I move around, but I cannot leave the Space (extend MovablePanel)
 * I have the looks of a spacecraft with an Image.
 * I should shoot and kill invaders, *but not yet*.
 */
public class Ship extends MovablePanel implements ActionListener {

    private Map<Direction, Boolean> directionMap = new HashMap<Direction, Boolean>();

    /**
     * Hold a relative path to the spaceship image.
     */
    private static final String ICON = "spaceship.gif";

    /**
     * Initialize the ship:
     *  - create and set the image from the path
     *  - set the size with a dimension
     *  - position at the bottom center of the space
     *  - set the initial speed
     */
    public Ship() {
        setPreferredSize(new Dimension(Shared.FIGHTER_WIDTH, Shared.FIGHTER_HEIGHT));

        // Default Position of the fighter - center bottom
        x = (Shared.SPACE_WIDTH - Shared.FIGHTER_WIDTH) / 2;
        y = Shared.SPACE_HEIGHT - Shared.FIGHTER_HEIGHT;
        speed = Shared.FIGHTER_SPEED;
        
        // Set the bounds because of the null layout of the parent
        setBounds(x, y, Shared.FIGHTER_WIDTH, Shared.FIGHTER_HEIGHT);

        for (Direction direction : Direction.values()) {
            directionMap.put(direction, false);
        }

        setKeyBindings();
    }

    protected String getImagePath() {
        return ICON;
    }

    /**
     * Check if the fighter would stay in the area.
     * If yes perform the move from the super class.
     */
    @Override
    protected void performMove() {
        // If the fighter on the left side of the screen
        if (x <= 0 && directionX < 0) {
            directionX = 0;
            x = 0;
        }

        // If the fighter is on the right side of the screen
        int maxX = Shared.SPACE_WIDTH - (int) getPreferredSize().getWidth();
        if (x >= maxX && directionX > 0) {
            directionX = 0;
            x = maxX;
        }

        // If the fighter is on the top side of the screen
        if (y <= 0 && directionY < 0) {
            directionY = 0;
            y = 0;
        }

        // If the fighter is on the bottom side of the screen
        int maxY = Shared.SPACE_HEIGHT - (int) getPreferredSize().getHeight();
        if (y >= maxY && directionY > 0) {
            directionY = 0;
            y = maxY;
        }

        super.performMove();
    }

    private void setKeyBindings() {
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();
        for (final Direction direction : Direction.values()) {
            KeyStroke pressed = KeyStroke.getKeyStroke(direction.getKeyCode(), 0, false);
            KeyStroke released = KeyStroke.getKeyStroke(direction.getKeyCode(), 0, true);
            inputMap.put(pressed, direction.toString() + "pressed");
            inputMap.put(released, direction.toString() + "released");

            actionMap.put(direction.toString() + "pressed", new AbstractAction() {

                private static final long serialVersionUID = 1L;

                @Override
                public void actionPerformed(ActionEvent event) {
                    directionMap.put(direction, true);
                }
            });

            actionMap.put(direction.toString() + "released", new AbstractAction() {

                private static final long serialVersionUID = 1L;

                @Override
                public void actionPerformed(ActionEvent event) {
                    directionMap.put(direction, false);
                }
            });
        }
    }

    public void actionPerformed(ActionEvent event) {
        boolean moved = false;
        for (Direction direction : Direction.values()) {
            if (directionMap.get(direction)) {

                if (direction.getXDirection() == 0 && direction.getYDirection() == 0) {
                    if (Engine.getInstance().getTotalMomentsCount() % 10 == 0) {
                        Engine.getInstance().addMissile(new Missile(
                            getX() + (int) getPreferredSize().getWidth() / 2,
                            getY()
                        ));
                    }
                } else {
                    x += getSpeed() * direction.getXDirection();
                    y += getSpeed() * direction.getYDirection();
                    moved = true;
                }
            }
        }

        if (moved) {
            int drawX = x - 2 * getSpeed();
            int drawY = y - 2 * getSpeed();
            int drawWidth = (int) getPreferredSize().getWidth() + 4 * getSpeed();
            int drawHeight = (int) getPreferredSize().getHeight() + 4 * getSpeed();

            // !! repaint just the ship
            repaint(drawX, drawY, drawWidth, drawHeight);
        }
    }
}