package Frogger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Highscore {
	String fileName = "highscore.txt";
	int topscore;
	boolean nw;
	public Highscore()
	{
		try {
			this.setTopScore();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setTopScore() throws IOException
	{
		FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
            while((line = bufferedReader.readLine()) != null) 
            {
            	topscore = Integer.parseInt(line);
            }
	}
	
	public int getTopScore()
	{
		return topscore;
	}
	
	public void setScore(int score)
	{
		try {
			newTopScore(score);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void newTopScore(int score) throws IOException
	{
		if(score > topscore)
		{
			nw = true;
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			String content =Integer.toString(score)+"\n";
			bw.write(content);		
			bw.close();
			fw.close();	
		}
		else
			nw = false;
	}
	
	public boolean newHighScore()
	{
		return nw;
	}
}
