package jeu.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemi extends Personnage{
	
	private IntegerProperty x, y;
	private IntegerProperty pv;
	private int vitesse;
	private int nbSaut;
	private Joueur joueur;
	private boolean droite,gauche,saute;
	
	public Ennemi(Joueur joueur) {
		this.x = new SimpleIntegerProperty(400);
		this.y = new SimpleIntegerProperty(360);
		this.vitesse = 1;
		this.pv = new SimpleIntegerProperty(5);
		this.nbSaut = 0;
		this.joueur = joueur;
	}
	
	//PVS
	@Override
	public void perdrePv() {
		int nbCoeur =this.pv.getValue()-1;
		if(this.pv.getValue()>=1) 
			this.pv.setValue(nbCoeur);
	}
	
	//DEPLACEMENT
	@Override
	public void allerAGauche() {
		int npos = this.x.getValue()-vitesse;
		if(npos > -5)
			this.x.setValue(npos);
	}
	@Override
	public void allerADroite() {
		int npos = this.x.getValue()+vitesse;
		if (npos < 766)
			this.x.setValue(npos);
	}
	@Override
	public void sauter() {
		int npos = this.y.getValue()-10;
		if(npos >0 )
			if(nbSaut<6) {
				this.y.setValue(npos);
				nbSaut++;
			}
	}
	@Override
	public void tomber() {
		int npos = this.y.getValue()+10;
		this.y.setValue(npos);
	}
	
	
	//SUIVRE JOUEUR
	public void suivreJoueur() {
		if(this.joueur.getX() < this.getX()) {
			this.allerAGauche();
			this.gauche = true;
			this.droite = false;
		}
		else if(this.joueur.getX() > this.getX()) {
			this.allerADroite();
			this.droite = true;
			this.gauche = false;
		}
		else {
			this.droite = false;
			this.gauche = false;
		}	
	}
	
	

	//getter
	public IntegerProperty getPv() {
		return pv;
	}
	public int getNbSaut() {
		return nbSaut;
	}
	public IntegerProperty getXProperty() {
		return this.x;
	}
	public IntegerProperty getYProperty() {
		return this.y;
	}
	@Override
	public int getX() {
		return this.x.getValue() ;	
	}
	@Override
	public int getY() {
		return this.y.getValue() ;		
	}
	public boolean isDroite() {
		return droite;
	}
	public boolean isGauche() {
		return gauche;
	}
	public boolean isSaute() {
		return saute;
	}
	
	
	
	//setter
	public void setNbSaut(int nbSaut) {
		this.nbSaut = nbSaut;
	}
	public void setX(IntegerProperty x) {
		this.x = x;
	}
	public void setY(IntegerProperty y) {
		this.y = y;
	}
	public void setPv(IntegerProperty pv) {
		this.pv = pv;
	}
}
