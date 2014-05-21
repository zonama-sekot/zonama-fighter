package game;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Random;

import game.space.Space;
import game.player.Player;
import game.player.PlayerPanel;
import game.invader.Invader;

/**
 * I am the Engine of the game.
 * I use the Singleton pattern.
 * I keep everything together:
 *  - missiles,
 *  - invaders,
 *  - space,
 *  - ship,
 *  - player,
 *  - timer
 *
 * Refer to my single instance with `Engine.getInstance()`.
 * 
 * {@link https://en.wikipedia.org/wiki/Singleton_pattern Singleton pattern}
 */
public class Engine implements ActionListener {

    /**
     * The single instance of the Engine.
     * Singleton pattern via `Engine.getInstance()`.
     *
     */
    protected static Engine instance;

    /**
     * The single instance of Space - the JPanel which holds everything
     */
    protected Space space;

    /**
     * The ship - moving and shooting
     */
    protected Ship ship;

    /**
     * The player - points and lives
     */
    protected Player player;

    /**
     * The player panel - prints the points and lives of the player
     */
    protected PlayerPanel playerPanel;

    /**
     * All the invaders on the Space.
     */
    protected ArrayList<Invader> invaders = new ArrayList<Invader>();

    /**
     * All the missiles on the Space.
     */
    protected ArrayList<Missile> missiles = new ArrayList<Missile>();

    /**
     * The Timer instance which I use to tick.
     */
    protected Timer timer;

    /**
     * Total count of the ticks
     * I use it to create an invader
     * every other `Shared.NEW_INVADER_THRESHOLD` time.
     */
    private int totalMomentsCount = 0;

    /**
     * Get the single instance of the Engine.
     *
     * @return Engine
     */
    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine();
        }

        return instance;
    }

    /**
     * Get the Space.
     * 
     * @return Space
     */
    public Space getSpace(){
        return this.space;
    }

    /**
     * Get the Player.
     * 
     * @return Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the Ship.
     * 
     * @return Ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Get the invaders
     *
     * @return ArrayList<Invader>
     */
    public ArrayList<Invader> getInvaders() {
        return invaders;
    }

    /**
     * Get the missiles
     *
     * @return ArrayList<Missile>
     */
    public ArrayList<Missile> getMissile() {
        return missiles;
    }

    public int getTotalMomentsCount() {
        return totalMomentsCount;
    }

    /**
     * Start the game.
     * Create initial instances, add them together and start the timer.
     */
    public void start() {
        player = new Player();
        ship = new Ship();
        playerPanel = new PlayerPanel();
        space = new Space();
        JFrame frame = createFrame();
        frame.getContentPane().add(space);

        // It is important the ship image is created after
        // it is added to the space.
        // Otherwise the transparent images are not visible
        space.add(ship);
        ship.setBufferedImageFromPath(ship.getImagePath());

        space.add(playerPanel);

        frame.pack();
        frame.setVisible(true);
        timer = new Timer(Shared.TIMER_DELAY, this);
        timer.addActionListener(ship);
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    /**
     * Called by the Timer because of the ActionListener interface
     *
     * Every tick I move the invaders down and create a new invader.
     *
     * @param ActionEvent event
     */
    public void actionPerformed(ActionEvent event) {
        totalMomentsCount++;
        space.moveInvadersDown(invaders);
        space.moveMissilesUp(missiles);
        if (shouldCreateInvader()) {
            addInvader(new Invader());
        }
        playerPanel.updateLabels();
        space.repaint();
    }

    /**
     * Add an invader to the Space
     * This will add it to both the panel and the invaders ArrayList
     *
     * @param Invader newInvader
     */
    public void addInvader(Invader newInvader) {
        invaders.add(newInvader);
        space.add(newInvader);
        space.revalidate();
        space.repaint();
    }

    public void addMissile(Missile newMissile) {
        missiles.add(newMissile);
        space.add(newMissile);
        space.revalidate();
        space.repaint();
    }

    /**
     * Check if new invader should be created and added to the space,
     * based on the number of ticks since the last one and a bit of randomness.
     *
     * @return boolean
     */
    protected boolean shouldCreateInvader() {
        // Check if the number of ticks (threshold) have passed
        if (totalMomentsCount % Shared.NEW_INVADER_THRESHOLD != 0) {
            return false;
        }

        // Add a bit of randomness so the invaders movement is not so droningly
        Random rand = new Random();
        int chance = rand.nextInt(100);

        return chance < Shared.NEW_INVADER_CHANCE;
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame(Shared.NAME);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        return frame;
    }
}
