package code.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderTool {
	private ArrayList<String> _words;
	public ReaderTool(){
	_words = new ArrayList<String>();
    String  _line = null;
    try{
       BufferedReader br = new BufferedReader(new FileReader("res/words.txt"));
       while ((_line = br.readLine()) != null) {
          _words.add(_line);
       }       
    }
    catch(Exception e){
       e.printStackTrace();
    }
	}
	public ArrayList<String> getWords(){
		return _words;
	}
}
