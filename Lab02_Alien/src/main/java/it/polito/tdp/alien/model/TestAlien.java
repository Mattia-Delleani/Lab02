package it.polito.tdp.alien.model;

public class TestAlien {

	AlienModel model;
	
	public void run() {
		
		this.model = new AlienModel();
		
		
		String aw1 ="hagSèsb";
		String t1 = "ciao";
		
		String aw2 ="zgSsb";
		String t2 = "come";
		
		Word w1 = new Word(aw1, t1);
		System.out.println("La parola numero 1 è: "+ w1.toString());
		Word w2 = new Word(aw2, t2);
		System.out.println("La parola numero 2 è: "+ w2.toString());
		
		System.out.printf("Le parole %s e %s sono uguali: " + w1.equals(w2), aw1,aw2);
		
		Dictionary dic = new Dictionary();
		
		dic.addWord(aw1, t1);
		dic.addWord(aw2, t2);
		
		System.out.println("\nDimensione: " +dic.getDictionary().size() +
				"\n" + "Stampa dizionario: \n"+ dic.getDictionary().toString());
		
		//String trad = dic.translateWord(aw2);
		//String trad2 = dic.translateWord("ciao");
		
		//System.out.printf("Traduzione %s:" + trad, aw2);
		//System.out.printf("\nTraduzione ciao:" + trad2, aw2);
		
		System.out.println("\nSTAMPO: \n"+ dic.toString());

		
	}
	
	
	public static void main(String[] args) {

		TestAlien test = new TestAlien();
		test.run();
	}

}
