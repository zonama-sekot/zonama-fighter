package game;

public interface Shared {

    public static final String NAME = "Zonama Fighter";

    public static final int INITIAL_LIVES = 3;
    public static final int INITIAL_POINTS = 0;

    public static final int SPACE_WIDTH = 389;
    public static final int SPACE_HEIGHT = 543;

    public static final int FIGHTER_WIDTH = 78;
    public static final int FIGHTER_HEIGHT = 81;
    public static final int FIGHTER_SPEED = 5;

    public static final int INVADER_WIDTH = 55;
    public static final int INVADER_HEIGHT = 45;
    public static final int INVADER_SPEED = 1;
    
    public static final int MISSILE_WIDTH = 15;
    public static final int MISSILE_HEIGHT = 38;
    public static final int MISSILE_SPEED = 3;

    public static final int TIMER_DELAY = 10;

    public static final int NEW_INVADER_THRESHOLD = 30;
    public static final double NEW_INVADER_CHANCE = 80;

    public static final int CRASH_WIDTH = 40;
    public static final int CRASH_HEIGHT = 40;
}