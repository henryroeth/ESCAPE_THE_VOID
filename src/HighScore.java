import java.io.*;

public class HighScore {
	private BufferedWriter writer;
	private BufferedReader reader;
	public HighScore(String filePath) {
		try {
			writer=new BufferedWriter(new FileWriter(filePath));
			reader=new BufferedReader(new FileReader(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addScore(String emptyString,int highScore) throws IOException {
		writer.write(emptyString+highScore);
		writer.close();
	}
	public String getScore() {
		String score="";
		try {
			score = reader.readLine();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
	}
}
