package it.polito.tdp.alien.model;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Dictionary {
	
	private List<Word> dictionary = new LinkedList<>();
	
	
	public void addWord(String alienWord, String translation) {
		
		alienWord = alienWord.toLowerCase();
		translation = translation.toLowerCase();
		boolean correctWord = this.isValid(alienWord);
		boolean correctTranslation = this.isValid(translation);
		
		if(correctWord && correctTranslation){
			
			Word w = new Word(alienWord, translation);
			if(dictionary.contains(w)) {
				dictionary.get(dictionary.indexOf(w)).getTranslation().add(translation);
			}else {
				dictionary.add(w);
			}
			
		}else {
			throw new InputMismatchException();
		}
	}
	
	
	public Set<String> translateWord(String alienWord) {
		alienWord = alienWord.toLowerCase();
			for(Word w: this.dictionary)
				if(w.getAlienWord().equals(alienWord))
					return w.getTranslation();
		
		return null;
		
	}
	
	
	public List<Word> getDictionary() {
		return dictionary;
	}
	
	public List<Word> getElenco() {
		
		//TODO
		
		Collections.sort(dictionary);;
		
		return dictionary;
	}
	
	public String toString() {
		String s="";
		for(Word tempS: this.getElenco())
			if(s.compareTo("")==0)
				s+= tempS.toString();
			else
				s+= "\n"+tempS;
		
		return s;
	}


	public boolean isValid(String s) {
		boolean isValid = true;
		
		char string[] = s.toCharArray();
		for(char c: string) {
			if(!Character.isLetter(c))
				isValid = false;	
		}
	
		return isValid;
	}
	
	
}
