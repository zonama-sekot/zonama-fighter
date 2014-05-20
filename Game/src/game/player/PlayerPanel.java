package game.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.Box;

import game.Shared;
import game.Engine;

public class PlayerPanel extends JPanel {

    protected static final String POINTS_TEXT = "Points: ";

    protected static final String LIVES_TEXT = "Lives: ";

    protected JLabel points;

    protected JLabel lives;

    protected int x;

    protected int y;

    public PlayerPanel() {
        setDoubleBuffered(true);
        setBackground(new Color(200, 200, 200));
        setPreferredSize(new Dimension(
            Shared.PLAYER_PANEL_WIDTH,
            Shared.PLAYER_PANEL_HEIGHT
        ));

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        x = 0;
        y = 0;

        points = new JLabel(POINTS_TEXT);
        lives = new JLabel(LIVES_TEXT);

        points.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        lives.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        add(points, BorderLayout.EAST);
        add(Box.createHorizontalGlue());
        add(lives, BorderLayout.WEST);

        // Set the bounds because of the null layout of the parent
        setBounds(x, y, Shared.PLAYER_PANEL_WIDTH, Shared.PLAYER_PANEL_HEIGHT);
        setVisible(true);
    }

    public void updateLabels() {
        points.setText(getPointsText());
        lives.setText(getLivesText());
    }

    protected String getPointsText() {
        return POINTS_TEXT + getPlayerPoints();
    }

    protected String getLivesText() {
        return LIVES_TEXT + getPlayerLives();
    }

    protected int getPlayerPoints() {
        return Engine.getInstance().getPlayer().getPoints();
    }

    protected int getPlayerLives() {
        return Engine.getInstance().getPlayer().getLives();
    }
}