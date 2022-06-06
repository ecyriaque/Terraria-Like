package jeu.modele.inventaire.objet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class caseInventaire {
	
	private IntegerProperty numObj = new SimpleIntegerProperty();
	private ObjetInventaire obj;
	public caseInventaire(ObjetInventaire obj) {
		
		this.numObj=obj.getNumProperty();
		this.obj=obj;
	}
	
	
	public void setObjetDeLaCase(ObjetInventaire obj) {
		this.obj=obj;
		this.numObj.setValue(obj.getNumProperty().getValue());
	}
	
	
	public ObjetInventaire getObjetDeLaCase() {
		return this.obj;
	}
	public IntegerProperty getNumObjetCase() {
		return this.numObj;	
	}
	
	public String toString() {
		return this.obj.toString();
	}
}
