/**
 * Name: Chrystell Adams
 */

package org.howard.edu.lsp.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounting {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		Scanner txtFile = new Scanner(new File("src/main/resources/words.txt"));
	
		while(txtFile.hasNext()) {
			String word = txtFile.next();
			word = word.replaceAll("[0-9]","");
			word = word.toLowerCase();
			if(word== "") {
				word= txtFile.next();
			}
			else {
				if(word.length() >= 4) { 
					if(map.containsKey(word)) {
						int count = map.get(word) + 1;
						map.put(word, count);
				
					}
					else {
						map.put(word, 1);
					}
			
				}
			}
		}
		txtFile.close();
		for (Map.Entry<String,Integer> entry: map.entrySet()) {
			System.out.println(entry);
		}
	
	}
	

}
