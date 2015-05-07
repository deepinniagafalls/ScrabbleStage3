package code.client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import code.LoadGame_047;
import code.SaveGame_047;
import code.WordChecker_047;
import code.base.Board_024;
import code.base.Player_024_047;
import code.base.Scrabble_024_047;
import code.base.Tile_024;
import code.client.BoardFrame_047;
import code.client.Game_047;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MAY-7
 * The Extravaganza class creates a window that allows for saving, restoring, and passing turn functionality.
 */

public class Extravaganza_047 extends JFrame {
	// This class is a mess, but we didn't have any other choice.

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Stores serial version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * stores dir path
	 */
	private JTextField filename = new JTextField(), dir = new JTextField();
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Button for players to choose a directory to load
	 */
	private JButton open = new JButton("Open"), save = new JButton("Save");
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Button for players to pass their turn
	 */
	private JButton pass = new JButton("Pass");
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Holds a reference to a BoardFrame where tiles will be placed on
	 */
	private BoardFrame_047 _bf;
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Holds a reference to a Board model for the game
	 */
	private Board_024 _b;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Holds a reference to the Scrabble class where many classes are instantiated.
	 */
	private Scrabble_024_047 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * An int value that indicates turns
	 /
	private int _currentTurn;
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * An int value that indicates how many players are playing the game
	 * /
	private int _numberOfPlayers;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Hold a referenceto the Game class where we get inputs from players
	 */
	private Game_047 _g;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * An int value that is used for counting
	 */
	private int _c = 0;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Label that hold String value to show on the GUI screen for players
	 */
	private JLabel label1;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Boolean value that tells us whether a player's frame is empty or not.
	 */
	private boolean _isPlayerFrameStillEmpty = false;

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param scrabble gets a reference for a class that instantiate essential classes
	 * @param bf gets a reference for a class that holds JButtons for players to place tiles
	 * @param g gets a reference for the Game class
	 * @param name gets an arraylist that holds every name for every player
	 * @param pf gets an arraylist of player frame that holds a player's inventory
	 * @param path a string that holds path to the dictionary
	 * Class constructor
	 */
	public Extravaganza_047(Scrabble_024_047 scrabble, BoardFrame_047 bf, Game_047 g, ArrayList<String> name, ArrayList<PlayerFrame_047> pf, String path) throws IOException {

	       
	    JFrame frame = new JFrame();   
		JPanel p = new JPanel();
		_scrabble = scrabble;
		_b = _scrabble.getBoard();
		_bf = bf;
		_g = g;
		
		//p.add(filename);
		//p.add(dir);
		p.add(open);
		p.add(save);
		p.add(pass);
		open.addActionListener(new OpenL());
		save.addActionListener(new SaveL());
		pass.addActionListener(new PassT(name, path));
		label1 = new JLabel("Turn: " + name.get(0),null,JLabel.CENTER);
		
		
		Container cp = getContentPane();
		cp.add(p, BorderLayout.SOUTH);
		p.add(label1);
		
		dir.setEditable(false);
		filename.setEditable(false);
		p.setLayout(new GridLayout(1, 3));
		cp.add(p, BorderLayout.NORTH);
		
		
		frame.add(p);
		p.setVisible(true);
		frame.pack();
		frame.setVisible(true);
		
		
		
		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Class that holds codes that make open button work
	 */
	public class OpenL implements ActionListener {
		/**
		 * @author tylerdie (Tyler Dietrich)
		 * @author ceelman (Chris Elman)
		 * @author jaeheunk (Jason(Jaeheun) Kim)
		 * @author mjszymko (Michael Szymkowski)
		 * @author shokoors (Shokoor Syed)
		 * @date 2015-MAY-7
		 * This method explains what would happen if the open button is clicked
		 */
		public void actionPerformed(ActionEvent e) {
			/*
			JFileChooser c = new JFileChooser();
				int value = c.showOpenDialog(Extravaganza.this);
				if (value == JFileChooser.APPROVE_OPTION) {
					filename.setText(c.getSelectedFile().getName());
					dir.setText(c.getCurrentDirectory().toString());
				}
				if (value == JFileChooser.CANCEL_OPTION) {
					filename.setText("You pressed cancel");
					dir.setText("");
				}
				c.setVisible(true);
				*/
				
				try {
					new LoadGame_047(_scrabble, _scrabble.getBoard(), _bf);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Class that holds codes that make save button work
	 */
	private class SaveL implements ActionListener {
		
		/**
		 * @author tylerdie (Tyler Dietrich)
		 * @author ceelman (Chris Elman)
		 * @author jaeheunk (Jason(Jaeheun) Kim)
		 * @author mjszymko (Michael Szymkowski)
		 * @author shokoors (Shokoor Syed)
		 * @date 2015-MAY-7
		 * This method explains what would happen if the save button is clicked
		 */
		public void actionPerformed(ActionEvent e) {
			
			try {
				new SaveGame_047(_scrabble.getBoard(), _bf, _scrabble);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*JFileChooser c = new JFileChooser();
			int value = c.showSaveDialog(Extravaganza.this);
			if (value == JFileChooser.APPROVE_OPTION) {
				filename.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if (value == JFileChooser.CANCEL_OPTION) {
			}
			c.setVisible(true);*/
		}
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * This method sets details about a frame and make it visible
	 */
	private static void run(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * This class holds codes that make the Pass button work
	 */
	private class PassT implements ActionListener {
		private ArrayList<String> _name;
		private String _path = "";
		public PassT(ArrayList<String> name, String path){
			_name = name;
		}
		
		public PassT(String path){
			_path = path;
		}
		/**
		 * @author tylerdie (Tyler Dietrich)
		 * @author ceelman (Chris Elman)
		 * @author jaeheunk (Jason(Jaeheun) Kim)
		 * @author mjszymko (Michael Szymkowski)
		 * @author shokoors (Shokoor Syed)
		 * @date 2015-MAY-7
		 * Method that performs a certain action when an action is performed.
		 */
		public void actionPerformed(ActionEvent e) {
			String wordToScore = _bf.getWordChecker().isThisWord();
			if(_bf.getWordChecker().isZero()){
				_g.incrementTurn();	
				if(_g.getCurrentTurn() == 0){label1.setText("Turn: "+ _name.get(0));}
				if(_g.getCurrentTurn() == 1){label1.setText("Turn: "+ _name.get(1));}
				if(_g.getCurrentTurn() == 2){label1.setText("Turn: "+ _name.get(2));}
				if(_g.getCurrentTurn() == 3){label1.setText("Turn: "+ _name.get(3));}
			}
			else if(wordToScore == null){
				//Chris changed stuff here
				JOptionPane.showMessageDialog(null, "You have lost your turn");
				_g.incrementTurn();	
				if(_g.getCurrentTurn() == 0){label1.setText("Turn: "+ _name.get(0));}
				if(_g.getCurrentTurn() == 1){label1.setText("Turn: "+ _name.get(1));}
				if(_g.getCurrentTurn() == 2){label1.setText("Turn: "+ _name.get(2));}
				if(_g.getCurrentTurn() == 3){label1.setText("Turn: "+ _name.get(3));}
			}
			
			else{
			
			JOptionPane.showMessageDialog(null, "You have passed your turn");
			int tep = _g.getCurrentTurn();
			code.client.PlayerFrame_047 temp = _bf.getPlayerFrame(_g.getCurrentTurn());
			for(int i=0; i<12; i++){ //Refills empty PlayerSpaces in the PlayerFrame
				if(temp.getPlayerSpace(i).getTile()==null){
					Tile_024 t = _scrabble.getInv().removeRandomTile();
					temp.getPlayerSpace(i).setText(Character.toString(t.getChar()) + ", " + t.getValue());
					temp.getPlayerSpace(i).setCurrentTile(t);
				}
			}
			for(int i=0; i<12; i++){
				if(temp.getPlayerSpace(i).getTile()==null){
					_isPlayerFrameStillEmpty = true;
				}
			}
			if(_isPlayerFrameStillEmpty){ //Terminates the game
				System.exit(0);
			}
			_g.incrementTurn();	
			if(_g.getCurrentTurn() == 0){label1.setText("Turn: "+ _name.get(0));}
			if(_g.getCurrentTurn() == 1){label1.setText("Turn: "+ _name.get(1));}
			if(_g.getCurrentTurn() == 2){label1.setText("Turn: "+ _name.get(2));}
			if(_g.getCurrentTurn() == 3){label1.setText("Turn: "+ _name.get(3));}
			
			
			if(wordToScore != null){
				//New Stuff
				_scrabble.setIsVeryFirstTurn(false);
				ArrayList<Integer> tempRows = _bf.getWordChecker().getRowCoordinates();
				ArrayList<Integer> tempCols = _bf.getWordChecker().getColCoordinates();
				ArrayList<Integer> correctRows = new ArrayList<Integer>();
				ArrayList<Integer> correctCols = new ArrayList<Integer>();
				
				//Generates values for correctRows
				correctRows.add(tempRows.get(0));
				int rowCount = tempRows.get(0);
				while(rowCount < tempRows.get(tempRows.size()-1)){
					rowCount ++;
					correctRows.add(rowCount);
				}
				
				//Generates values for correctCols
				correctCols.add(tempCols.get(0));
				int colCount = tempCols.get(0);
				while(colCount < tempCols.get(tempCols.size()-1)){
					colCount ++;
					correctCols.add(colCount);
				}
				
				System.out.println(wordToScore);
				
				System.out.println("Row Coordinates");
				for(int i=0; i<correctRows.size(); i++){
					System.out.println(correctRows.get(i));
				}
				System.out.println("Col Coordinates");
				for(int i=0; i<correctCols.size(); i++){
					System.out.println(correctCols.get(i));
				}
				
				int sum = 0;
				int wordMultiplierSum = 0;
				boolean isRowLongerThanCol = correctRows.size() > correctCols.size();
				
				//Caluclates score if word is vertical
				if(isRowLongerThanCol){
					for(int i=0; i<correctRows.size();i++){
						sum = sum + _b.getLetterMultiplier(((correctRows.get(i))*20)+(correctCols.get(0)))*scoreHelper(wordToScore.charAt(i));
						_b.setLetterMultiplier(((correctRows.get(i))*20)+(correctCols.get(0)));
					}
					for(int i=0; i<correctRows.size();i++){
						if(_b.getWordMultiplier((correctRows.get(i))*20+(correctCols.get(0)))==1){
							//Do nothing
						}
						else{
							wordMultiplierSum = wordMultiplierSum + _b.getWordMultiplier(correctRows.get(i)*20+correctCols.get(0));
							_b.setWordMultipliers((correctRows.get(i))*20+(correctCols.get(0)));
						}
					}
					if(wordMultiplierSum == 0){
						//Do nothing
					}
					else{
					sum = sum*wordMultiplierSum;
					}
				}
				else{ //Calculates score if word is horizontal
					for(int i=0; i<correctCols.size();i++){
						sum = sum + _b.getLetterMultiplier(((correctRows.get(0))*20)+(correctCols.get(i)))*scoreHelper(wordToScore.charAt(i));
						_b.setLetterMultiplier(((correctRows.get(0))*20)+(correctCols.get(i)));
					}
					for(int i=0; i<correctCols.size();i++){
						if(_b.getWordMultiplier((correctRows.get(0))*20+(correctCols.get(i)))==1){
							//Do nothing
						}
						else{
							wordMultiplierSum = wordMultiplierSum + _b.getWordMultiplier(correctRows.get(0)*20+correctCols.get(i));
							_b.setWordMultipliers((correctRows.get(0))*20+(correctCols.get(i)));
						}
					}
					if(wordMultiplierSum == 0){
						//Do nothing
					}
					else{
						System.out.println("Word multiply");
					System.out.println(wordMultiplierSum);
					sum = sum*wordMultiplierSum;
					}
				}
				Player_024_047 tempPlayer = _scrabble.getPlayers().get(_g.getCurrentTurn());
				tempPlayer.addScore(tempPlayer.getScore(), sum);
			}
			WordChecker_047 check = new WordChecker_047(_bf,_bf.getBoard(),_path);
			_bf.setWord(check);
			_bf.getPlayerFrame(tep).update();
			}
			_bf.getWordChecker().clear();
		}
	}
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @return Returns an int value for a char that the method is getting
	 * This method returns a score value of type int according to a letter of type Char
	 */
	public int scoreHelper(char c){
		if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
			return 1;
		}
		if(c=='B' || c=='C' || c=='D' || c=='F' || c=='G' || c=='H' || c=='J' || c=='K' || c=='L' || c=='M' || c=='N' || c=='P' || c=='Q' || c=='R' || c=='S' || c=='T' || c=='V' || c=='W' || c=='X' || c=='Z'){
			return 5;
		}
		if(c=='Y'){
			return 2;
		}
		return 0;
	}
	

}
