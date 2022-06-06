package jeu.modele.inventaire.objet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class caseInventaire {
	
	private IntegerProperty numObj = new SimpleIntegerProperty();
	public caseInventaire(ObjetInventaire obj) {
		
		this.numObj=obj.getNumProperty();
	}
	
	
	public void setNum(ObjetInventaire obj) {
		this.numObj=obj.getNumProperty();
	}
	
	public IntegerProperty getNumObjetCase() {
		return this.numObj;	
	}
}
