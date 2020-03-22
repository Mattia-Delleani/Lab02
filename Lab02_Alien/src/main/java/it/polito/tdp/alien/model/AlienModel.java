package it.polito.tdp.alien.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
	
	public String traduciWildcard(String alienWord) {
		int indice = alienWord.indexOf("?");
		String[] input = alienWord.split("\\?");
		List<String> lista = new LinkedList<String>();
		
		for(Word s: dictionary.getDictionary()) {
			if(s.getAlienWord().length()== alienWord.length()) {
				if(alienWord.substring(0, indice).equals(input[0]) && alienWord.substring(indice+1).equals(input[1]));
				lista.addAll(s.getTranslation());
			}
		}
		
		String sTemp = "";

		for(String s: lista)
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
