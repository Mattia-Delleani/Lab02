package it.polito.tdp.alien;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienModel model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	this.model.getDictionary().getElenco().clear();
    	txtResult.clear();
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String txt = txtInsert.getText();
    	String[] input= txt.split(" ");
    	txtResult.clear();
    	if(input.length==0 || input.length>2) {
    		txtResult.setText("Errore di inserimento dati.\nPer aggiungere una parola inserire la parola aliena da aggiungere poi spazio poi traduzione (es. 'ahgs ciao').\n"
    				+ "Per ricevere la traduzione inserire esclusivamente la parola aliena.");
    	}else if(input.length == 2) {
    		try {
    		String alienWord = input[0];
    		String translation = input[1];
    		this.model.aggiungiParola(alienWord, translation);
    		txtResult.setText(this.model.getDictionary().toString());
    		}catch(InputMismatchException ime) {
    			txtResult.clear();
    			txtResult.setText("Errore di inserimento input!\n");
    		}
    	}else if(input.length==1){
    		String alienWord = input[0];
    		String tradotta = null;
    		if(alienWord.contains("?")) {
    			tradotta = this.model.traduciWildcard(alienWord);
    		}else {
    			tradotta = this.model.traduciParola(alienWord);
    		}
    		
    		
    		if(tradotta == null) {
    			tradotta = "Parola non presente nel dizionario, aggiungerla oppure ritenta.";
    		}
    		txtResult.setText(tradotta);
    	}
    	txtInsert.clear();
    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(AlienModel model) {
		this.model = model;
	}
    
    
    
}
