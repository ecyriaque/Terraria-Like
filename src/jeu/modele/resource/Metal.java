package jeu.modele.resource;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Metal extends Resource{

	IntegerProperty nbMetal;
	
	public Metal() {
		super("metal");
		nbMetal=new SimpleIntegerProperty(0);
	}

	public IntegerProperty getNbMetal() {
		return nbMetal;
	}

	public  void ajouterResource(){
		int c;
		c=this.nbMetal.getValue()+1;
		if (this.nbMetal.getValue() < 99)
		this.nbMetal.setValue(c);
	}
	
	public IntegerProperty getResource() {
		return this.getNbMetal();	
	}
	
	public  void EnleverResource(){
		int c;
		c=this.nbMetal.getValue()-3;
		this.nbMetal.setValue(c);
	}
	
	@Override
	public void retirerResource() {
		this.nbMetal.setValue(this.nbMetal.getValue()-1);	
	}
}
