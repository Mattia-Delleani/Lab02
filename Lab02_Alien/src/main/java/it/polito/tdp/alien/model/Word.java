package it.polito.tdp.alien.model;

import java.util.HashSet;
import java.util.Set;

public class Word implements Comparable<Word>{
	private String alienWord;
	private Set<String> translation;
	/**
	 * @param alienWord
	 * @param translation
	 */
	public Word(String alienWord, String translation) {
		
		this.alienWord = alienWord;
		this.translation= new HashSet<>();
		this.translation.add(translation);
	}
	
	
	@Override
	public String toString() {
		String sTemp= "";
		for(String s: translation)
			if(sTemp.equals(""))
				sTemp+=s;
			else
				sTemp+=", "+s;
		sTemp+= ".";
		
		return "" + alienWord + "-->" + sTemp;
	}




	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public Set<String> getTranslation() {
		return translation;
	}


	public void setTranslation(Set<String> translation) {
		this.translation = translation;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}


	@Override
	public int compareTo(Word o) {
		return this.alienWord.compareTo(o.getAlienWord());
	}
	
	
	

}
