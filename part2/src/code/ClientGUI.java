package code;

import java.util.ArrayList;

import javax.swing.UIManager;

import code.base.Board_024;
import code.base.Scrabble_024_047;

public class ClientGUI {
	ArrayList<PlayerFrame_047> _playerFrameList;
	
	public void getData(){
		
	}
	
	public void startGUI(){
	       try {
	            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	       
	}

}
