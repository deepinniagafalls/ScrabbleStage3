package code;

public class Game {

	public static void main(String[] args) {
		
		Scrabble scrabble = new Scrabble();
		Frame f = new Frame(scrabble);
		ReadText rt = new ReadText();
		rt.access(23);
	}
}
