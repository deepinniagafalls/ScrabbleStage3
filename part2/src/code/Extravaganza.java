package code;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import code.base.Scrabble;
import code.base.Tile;

public class Extravaganza extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField filename = new JTextField(), dir = new JTextField();

	private JButton open = new JButton("Open"), save = new JButton("Save");
	private JButton pass = new JButton("Pass");
	private BoardFrame _bf;
	private Scrabble _scrabble;
	private int _currentTurn;
	private int _numberOfPlayers;
	private Game _g;
	private int _c = 0;
	private JLabel label1;

	public Extravaganza(Scrabble scrabble, BoardFrame bf, Game g) {
	       try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	       
	    JFrame frame = new JFrame();   
		JPanel p = new JPanel();
		_scrabble = scrabble;
		_bf = bf;
		_g = g;
		
		//p.add(filename);
		//p.add(dir);
		p.add(open);
		p.add(save);
		p.add(pass);
		open.addActionListener(new OpenL());
		save.addActionListener(new SaveL());
		pass.addActionListener(new PassT());
		label1 = new JLabel("Turn: Player "+(_g.getCurrentTurn()+1),null,JLabel.CENTER);
		
		
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

	public class OpenL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
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
		}
	}

	public class SaveL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser c = new JFileChooser();
			int value = c.showSaveDialog(Extravaganza.this);
			if (value == JFileChooser.APPROVE_OPTION) {
				filename.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if (value == JFileChooser.CANCEL_OPTION) {
			}
			c.setVisible(true);
		}
	}

	public static void run(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	
	public class PassT implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "You have passed your turn");
			label1.setText("Turn: Player "+(_g.getCurrentTurn()+1));
			PlayerFrame temp = _bf.getPlayerFrame(_g.getCurrentTurn());
			for(int i=0; i<12; i++){
				if(temp.getPlayerSpace(i).getTile()==null){
					Tile t = _scrabble.getInv().removeRandomTile();
					temp.getPlayerSpace(i).setText(Character.toString(t.getChar()));
					temp.getPlayerSpace(i).setCurrentTile(t);
				}
				}
			_g.incrementTurn();
			System.out.println(_g.getCurrentTurn());	
			label1.setText("Turn: Player "+(_g.getCurrentTurn()+1));

	}
	}
	

}
