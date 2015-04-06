package code;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class FileChooser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField filename = new JTextField(), dir = new JTextField();

	private JButton open = new JButton("Open"), save = new JButton("Save");
	private JButton pass = new JButton("Pass");

	public FileChooser() {
	       try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	       
	    JFrame frame = new JFrame();   
		JPanel p = new JPanel();
		
		p.add(filename);
		p.add(dir);
		p.add(open);
		p.add(save);
		p.add(pass);
		open.addActionListener(new OpenL());
		save.addActionListener(new SaveL());
		pass.addActionListener(new PassT());
		
		
		Container cp = getContentPane();
		cp.add(p, BorderLayout.SOUTH);
		
		dir.setEditable(false);
		filename.setEditable(false);
		//p.setLayout(new GridLayout(2, 1));
		cp.add(p, BorderLayout.SOUTH);
		
		
		frame.add(p);
		p.setVisible(true);
		frame.pack();
		frame.setVisible(true);
	}

	public class OpenL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser c = new JFileChooser();
				int value = c.showOpenDialog(FileChooser.this);
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
			int value = c.showSaveDialog(FileChooser.this);
			if (value == JFileChooser.APPROVE_OPTION) {
				filename.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if (value == JFileChooser.CANCEL_OPTION) {
			}
			c.setVisible(true);
		}
	}

	public static void main(String[] args) {
		run(new FileChooser(), 250, 110);
	}

	public static void run(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	public class PassT implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "You have passed your turn");
	}
	}

}

