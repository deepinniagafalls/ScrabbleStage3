package code;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class ReadText extends ArrayList<String> {
	
	ArrayList<String> _map = new ArrayList<String>(23);
	
<<<<<<< HEAD
	public ArrayList<String> ReadText(){
		FileReader sc = new FileReader("C:\\Users\\Michael\\Documents\\UB 15 Spring\\CSE116\\Lab4-test");
=======
	public ReadText(){
		String fileName = "words.txt";
		Scanner sc = new Scanner(fileName);
>>>>>>> branch 'master' of https://github.com/jasonkimik/part2
		
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			System.out.println(s);
			_map.add(s);
		}
		return _map;
	}

	
	public void access(int index){
		System.out.println(_map.get(index));
	}
}
