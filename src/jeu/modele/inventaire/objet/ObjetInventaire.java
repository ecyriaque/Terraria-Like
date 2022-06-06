package jeu.modele.inventaire.objet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ObjetInventaire {


	private String typeobjet;
	
	private IntegerProperty numObjetProperty;
	private int numObjet;
	public ObjetInventaire(String typeobjet,int numObjet) {
		this.typeobjet=typeobjet;
		this.numObjet=numObjet;
		numObjetProperty=new SimpleIntegerProperty(numObjet);

	}

	public String getTypeObjet() {
		return typeobjet;
	}
	
	
	
	public String toString() {
		return this.typeobjet;
	}
	
	public ObjetInventaire getObjetInventaire() {
		return this;
		
	}
	
	public IntegerProperty getNumProperty() {
		return this.numObjetProperty;
	}
	
}
