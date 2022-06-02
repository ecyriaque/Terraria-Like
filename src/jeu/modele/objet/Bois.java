package jeu.modele.objet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Bois extends Resource{

	IntegerProperty nbBois;
	
	public Bois() {
		super("bois");
		nbBois=new SimpleIntegerProperty(0);
	}

	public IntegerProperty getNbBois() {
		return nbBois;
	}

	public  void ajouterResource(){
		int c;
		c=this.nbBois.getValue()+1;
		this.nbBois.setValue(c);
	}
	
	public IntegerProperty getResource() {
		return this.getNbBois();
		
	}

	@Override
	public void retirerResource() {
		this.nbBois.setValue(this.nbBois.getValue()-1);
		
	}
}
