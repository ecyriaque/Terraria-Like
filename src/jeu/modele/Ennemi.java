package jeu.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemi extends Personnage{
	
	private IntegerProperty x, y;
	private IntegerProperty pv;
	private int vitesse;
	private IntegerProperty direction;
	private boolean droite,gauche,saute;
	private String id;
	public Ennemi(int xx) {
		this.x = new SimpleIntegerProperty(xx);
		this.y = new SimpleIntegerProperty(360);
		this.direction =new SimpleIntegerProperty(0);
		this.vitesse = 4;
		this.pv = new SimpleIntegerProperty(5);
		int compteur=1;
		this.id="A"+compteur;
	}
	
	//PVS
	@Override
	public void perdrePv(int i) {
		
		if(i>this.pv.get()) 
			this.pv.setValue(0);
		else
			this.pv.setValue(pv.getValue()-i);
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
				this.y.setValue(npos);
	}
	@Override
	public void tomber() {
		int npos = this.y.getValue()+10;
		this.y.setValue(npos);
	}
	

	//getter
	public IntegerProperty getPv() {
		return pv;
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
	public String getId() {
		return id;
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
	public void setX(IntegerProperty x) {
		this.x = x;
	}
	public void setY(IntegerProperty y) {
		this.y = y;
	}
	public void setPv(IntegerProperty pv) {
		this.pv = pv;
	}
	public void setDroite(boolean a) {
		droite = a;
	}
	public void setGauche(boolean a) {
		gauche = a;
	}
	
	public void setDirection(int i) {
		
		this.direction.setValue(i);
	}

	@Override
	public void perdrePv() {
		// TODO Auto-generated method stub
		
	}

	public IntegerProperty getDirection() {
		return direction;
	}

	
}
