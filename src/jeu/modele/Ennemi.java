package jeu.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemi extends Personnage{
	
	private IntegerProperty xProperty, yProperty;
	private IntegerProperty pvProperty;
	private IntegerProperty directionProperty;
	private int vitesse;
	private boolean droite,gauche,saute;
	private String id;
	public static int compteur=0
			;
	public Ennemi(int xx) {
		this.xProperty = new SimpleIntegerProperty(xx);
		this.yProperty = new SimpleIntegerProperty(360);
		this.directionProperty =new SimpleIntegerProperty(0);
		this.vitesse = 4;
		this.pvProperty = new SimpleIntegerProperty(5);
		
		this.id="A"+compteur;
		compteur++;
	}
	
	//PVS
	@Override
	public void perdrePv(int i) {
		
		if(i>this.pvProperty.get()) 
			this.pvProperty.setValue(0);
		else
			this.pvProperty.setValue(pvProperty.getValue()-i);
	}
	
	//DEPLACEMENT
	@Override
	public void allerAGauche() {
		int npos = this.xProperty.getValue()-vitesse;
		if(npos > -5)
			this.xProperty.setValue(npos);
	}
	@Override
	public void allerADroite() {
		int npos = this.xProperty.getValue()+vitesse;
		if (npos < 766)
			this.xProperty.setValue(npos);
	}
	@Override
	public void sauter() {
		int npos = this.yProperty.getValue()-10;
		if(npos >0 )
				this.yProperty.setValue(npos);
	}
	@Override
	public void tomber() {
		int npos = this.yProperty.getValue()+10;
		this.yProperty.setValue(npos);
	}
	

	//getter
	public IntegerProperty getPvProperty() {
		return pvProperty;
	}
	
	public int getPv() {
		return pvProperty.getValue();
	}
	public IntegerProperty getXProperty() {
		return this.xProperty;
	}
	public IntegerProperty getYProperty() {
		return this.yProperty;
	}
	@Override
	public int getX() {
		return this.xProperty.getValue() ;	
	}
	@Override
	public int getY() {
		return this.yProperty.getValue() ;		
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
		this.xProperty = x;
	}
	public void setY(IntegerProperty y) {
		this.yProperty = y;
	}
	public void setPv(IntegerProperty pv) {
		this.pvProperty = pv;
	}
	public void setDroite(boolean a) {
		droite = a;
	}
	public void setGauche(boolean a) {
		gauche = a;
	}
	
	public void setDirection(int i) {
		
		this.directionProperty.setValue(i);
	}

	@Override
	public void perdrePv() {
		// TODO Auto-generated method stub
		
	}

	public IntegerProperty getDirection() {
		return directionProperty;
	}

	public String toString() {
		return this.id;
	}
}
