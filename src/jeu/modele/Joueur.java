package jeu.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Joueur {
	//variables//
	private int xx,yy;
	private IntegerProperty x,y;
	private IntegerProperty nbCoeursProperty;
	protected Map env;
	private int nbSaut =0;
	private int vitesse;

	
	//CONSTRUCTEUR//
	public Joueur() {
		this.xx = 40;
		this.yy =360;
		this.nbCoeursProperty=new SimpleIntegerProperty(5);
		this.x = new SimpleIntegerProperty(xx);
		this.y = new SimpleIntegerProperty(yy);
		this.vitesse = 8;
	}

	
	//Methodes de gestion des PV //
	public void perdrepv() {
	int c=this.getNbCoeurs()-1;
	if(getNbCoeurs()>=1) 
		this.nbCoeursProperty.setValue(c);
	}
	public void gagnerpv() {
		int c=this.getNbCoeurs()+1;
		if(getNbCoeurs()<5)
			this.nbCoeursProperty.setValue(c);
	}

	
	///////////// Les integersProperty /////////////
	public final IntegerProperty xProperty(){
		return this.x;
	}
	public final IntegerProperty yProperty(){
		return this.y;
	}
	public final IntegerProperty nbCoeurProperty() {
		return this.nbCoeursProperty;
	}

	
	///////// Les methodes de deplacement //////////
	public void allerAGauche() {
		int npos = getX()-vitesse;
		if(npos > -5)
			this.x.setValue(npos);
	}
	public void allerADroite() {
		int npos = getX()+vitesse;
		if (npos <770)
			this.x.setValue(npos);
	}
	public void sauter() {
		if(nbSaut<6) {
			int npos = getY()-10;
			this.y.setValue(npos);
			nbSaut++;
		}
	}
	public void tomber() {
		int npos = getY()+10;
		this.y.setValue(npos);
	}
	
	
	///////// Les setters /////////////
	public final void setY(int n){
		y.setValue(n);
	}
	public final void setX(int n){
		x.setValue(n);
	}
	public final void setNbCoeurs(int nb) {
		nbCoeursProperty.setValue(nb);
	}
	public void setNbSaut(int nbSaut) {
		this.nbSaut = nbSaut;
	}

	
	/////// Les Getters //////////////
	public final int getNbCoeurs() {
		return this.nbCoeursProperty.getValue();
	}
	public final int getX() {
		return x.getValue();
	}
	public final int getY() {
		return y.getValue();
	}
	public int getNbSaut() {
		return nbSaut;
	}
}
