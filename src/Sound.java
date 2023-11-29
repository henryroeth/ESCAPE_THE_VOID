import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
/**
 * Sound class with methods to call wav files to be play in the main program.
 * @author henry
 *
 */
public class Sound {
	private boolean musicState=false;
	private boolean loopState=false;
	/**
	 * Method to play the the wav file from the specified file path that is to be fed into the method.
	 * @param musicLocation The file path of the wav file.
	 */
	public void playMusic(String musicLocation) {
		try
		{
			File filePath=new File(musicLocation);
				if(filePath.exists())
					{
						filePath.setExecutable(true);
						AudioInputStream audioInput=AudioSystem.getAudioInputStream(filePath);
						Clip clip=AudioSystem.getClip();
						clip.open(audioInput);
						clip.start();
						if(loopState) {
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						}
						if(musicState) {
							JOptionPane.showMessageDialog(null,"");
							clip.getMicrosecondPosition();
							clip.stop();
						}
					}
				else
				{
					System.out.println("Error");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	public void setLoop(boolean loopState) {
		this.loopState=loopState;
	}
	public void stopMusic(boolean stopState) {
		musicState=stopState;
	}
}