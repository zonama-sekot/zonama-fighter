package game.player;

import game.Shared;

/**
 * I am a player.
 * I have points and lives.
 * You could increase my points.
 * You could increase or decrease my lives.
 * You could read my points and lives.
 */
public class Player {

    protected int lives = Shared.INITIAL_LIVES;

    protected int points = Shared.INITIAL_POINTS;

    public int getPoints() {
        return points;
    }

    public void increasePoints() {
        points++;
    }

    public int getLives() {
        return lives;
    }

    public void increaseLives() {
        lives++;
    }

    public void decreaseLives() {
        lives--;
    }

    public boolean isAlive() {
        return getLives() > 0;
    }
}