package game;

import javax.swing.JFrame;
import java.awt.Color;

import game.space.Space;
import game.player.Player;

/**
 * Created by gngeorgiev on 15.05.14.
 */
public class Engine {

    protected static Engine instance;

    protected Space space;

    protected Ship ship;

    protected Player player;

    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine();
        }

        return instance;
    }

    public Space getSpace(){
        return this.space;
    }

    public Player getPlayer() {
        return player;
    }

    public Ship getShip() {
        return ship;
    }

    public void start() {
        player = new Player();
        ship = new Ship();
        space = new Space();
        space.add(ship);
        JFrame frame = createFrame();
        frame.getContentPane().add(space);
        frame.pack();
        frame.setVisible(true);
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame(Shared.NAME);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        return frame;
    }
}
