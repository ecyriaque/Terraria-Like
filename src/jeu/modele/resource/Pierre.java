package jeu.modele.resource;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Pierre extends Resource{

	IntegerProperty nbPierre;
	
	public Pierre() {
		super("pierre");
		nbPierre=new SimpleIntegerProperty(0);
	}

	public IntegerProperty getNbPierre() {
		return nbPierre;
	}

	public  void ajouterResource(){
		int c;
		c=this.nbPierre.getValue()+1;
		this.nbPierre.setValue(c);
	}
	
	public IntegerProperty getResource() {
		return this.getNbPierre();
		
	}
	
	public  void EnleverResource(){
		int c;
		c=this.nbPierre.getValue()-3;
		this.nbPierre.setValue(c);
	}
	
	@Override
	public void retirerResource() {
		this.nbPierre.setValue(this.nbPierre.getValue()-1);
		
	}
}
