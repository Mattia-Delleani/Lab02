package it.polito.tdp.alien.model;

public class AlienModel {
	
	private Dictionary dictionary;
	
	public AlienModel() {
		dictionary = new Dictionary();
		
	}
	public void aggiungiParola(String alienWord, String translation) {
		
		dictionary.addWord(alienWord, translation);
		
	}
	public String traduciParola(String alienWord) {
		String tradotta = dictionary.translateWord(alienWord);
		return tradotta;
		
	}
	public Dictionary getDictionary() {
		return dictionary;
	}
}
