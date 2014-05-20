package game.space;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.Box;

import game.Shared;
import game.Engine;

public class SpacePanel extends JPanel {

//    protected static final String POINTS_TEXT = "Points: ";
//
//    protected static final String LIVES_TEXT = "Lives: ";
//
//    protected JLabel points;
//
//    protected JLabel lives;
	protected static final String path = "C:\\Users\\Elia\\Documents\\GitHub\\zonama-fighter\\Game\\src\\game\\spaceground.gif";
    
	protected JLabel panel;

    public SpacePanel() {
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(
            Shared.SPACE_WIDTH,
            Shared.SPACE_HEIGHT
        ));
        JPanel jp = new JPanel();  
        jp.add(new JLabel(new ImageIcon(path)));
        jp.setOpaque(true);
        add(jp);
        setVisible(true);
    }    
}