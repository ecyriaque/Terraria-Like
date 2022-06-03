package jeu.modele.inventaire.objet;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ObjetInventaire {

	private StringProperty typeObjetProperty;
	private String typeobjet;
	public ObjetInventaire(String typeobjet) {
		this.typeobjet=typeobjet;
		typeObjetProperty=new SimpleStringProperty(typeobjet);
	}

	public String getTypeObjet() {
		return typeobjet;
	}
	
	public StringProperty getTypeObjetProerty() {
		return typeObjetProperty;
	}
	
	public void setObjet(String s) {
		String npos = s;
			this.typeobjet=npos;
			this.typeObjetProperty.setValue(npos);
	}
	
}
