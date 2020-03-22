package it.polito.tdp.alien.model;

import java.util.Set;

public class AlienModel {
	
	private Dictionary dictionary;
	
	public AlienModel() {
		dictionary = new Dictionary();
		
	}
	public void aggiungiParola(String alienWord, String translation) {
		
		dictionary.addWord(alienWord, translation);
		
	}
	public String traduciParola(String alienWord) {
		Set<String> tradotte= dictionary.translateWord(alienWord);
		String sTemp= "";
		for(String s: tradotte)
			if(sTemp.equals(""))
				sTemp+=s;
			else
				sTemp+=", "+s;
		sTemp+= ".";
		
		return sTemp;
		
		
	}
	public Dictionary getDictionary() {
		return dictionary;
	}
}
