package game;

import game.space.Space;

/**
 * Created by gngeorgiev on 15.05.14.
 */
public class Engine {

    private Space gameSpace;

    public Space getGameSpace(){
        return this.gameSpace;
    }

    public void Start() {
        this.gameSpace = new Space();
        this.gameSpace.addInvaders(15);
    }
}
