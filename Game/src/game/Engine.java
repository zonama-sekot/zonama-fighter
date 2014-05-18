package game;

import game.space.Space;
import game.player.Player;

/**
 * Created by gngeorgiev on 15.05.14.
 */
public class Engine {

    protected static Engine instance;

    protected Space gameSpace;

    protected Player player;

    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine();
        }

        return instance;
    }

    public Space getGameSpace(){
        return this.gameSpace;
    }

    public Player getPlayer() {
        return player;
    }

    public void start() {
        player = new Player();
        gameSpace = new Space();
    }
}
