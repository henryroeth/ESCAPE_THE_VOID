import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * This class is the main program and creates the JFrame to paint all components on. 
 * It provides a while loop with various methods to continually repaint them across the frame.
 * The objective of the game is to avoid the asteroids and emerge with your ship in one piece.
 * 
 * @author henry
 * 
 */

public class BackgroundMain {
	public static final int DELAY = 1;
	public static final int WINSIZE = 500;
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(WINSIZE, WINSIZE);
		frame.setTitle("ESCAPE THE VOID");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ArrayList<BackgroundComponent> components=new ArrayList<BackgroundComponent>();
		BackgroundComponent component = new BackgroundComponent();
		long oldTime=System.currentTimeMillis();
		frame.addKeyListener(component);
		frame.setVisible(true);
		frame.add(component);
		frame.setResizable(false);
		//imports a wav sound file from the Sound class to play at the start of the program
		Sound musicObject=new Sound();
		Sound musicObject1=new Sound();
		//if(!component.getMusicState()) {
			component.changeMusicState(true);
			musicObject.setLoop(true);
			musicObject.playMusic("Chiptronical.wav");
		//}
		//loop to continue painting objects across the screen
			while(!component.asteroidCollision()) {
					long curTime=System.currentTimeMillis();
					long diff=curTime-oldTime;
					if(component.startScreen()) {
					component.update(diff);
					component.updateScore();
					}
					oldTime=curTime;
					frame.repaint();
					try {
						Thread.sleep(DELAY);
					}
					catch(InterruptedException e) {
					}
			}
			
		//paints the overlay indicating that the game is over after the while loop is broken and plays an explosion sound effect
		musicObject.stopMusic(true);
		musicObject1.playMusic("boom.wav");
		
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
		}
		musicObject1.playMusic("lose.wav");
		component.setOverlay(true);
		frame.repaint();
		
		}
}

	


