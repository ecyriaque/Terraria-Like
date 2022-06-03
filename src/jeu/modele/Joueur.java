package jeu.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.modele.inventaire.Inventaire;
import jeu.modele.inventaire.objet.Arme;
import jeu.modele.inventaire.objet.Bandage;
import jeu.modele.inventaire.objet.Epee;
import jeu.modele.inventaire.objet.KitDeSoin;
import jeu.modele.inventaire.objet.ObjetInventaire;
import jeu.modele.resource.Bois;
import jeu.modele.resource.Metal;
import jeu.modele.resource.Pierre;
import jeu.modele.resource.Resource;


public class Joueur {
	//variables//
	private int xx,yy;
	private IntegerProperty x,y;
	private IntegerProperty nbCoeursProperty;
	private Map env;
	private int nbSaut =0;
	private int vitesse;
	private boolean droite,gauche,saute; //vraie si il se deplace ou saute
	private ArrayList<Resource> inventaireResource;
	private Inventaire inventaireObjet =new Inventaire();
	private Resource bois= new Bois();
	private Resource metal= new Metal();
	private Resource pierre=new Pierre();

	//CONSTRUCTEUR//
	public Joueur() {
		
		this.xx = 60;
		this.yy =360;
		this.nbCoeursProperty=new SimpleIntegerProperty(5);
		this.x = new SimpleIntegerProperty(xx);
		this.y = new SimpleIntegerProperty(yy);
		this.vitesse = 8;
		
		ObjetInventaire case1=new Epee("vide");
		ObjetInventaire case2=new Epee("vide");
		ObjetInventaire case3=new Epee("vide");
		ObjetInventaire case4=new Epee("vide");
		ObjetInventaire case5=new Epee("vide");
		ObjetInventaire case6=new Epee("vide");
		
		inventaireObjet.ajouterDansLinventaire(case1);
		inventaireObjet.ajouterDansLinventaire(case2);
		inventaireObjet.ajouterDansLinventaire(case3);
		inventaireObjet.ajouterDansLinventaire(case4);
		inventaireObjet.ajouterDansLinventaire(case5);
		inventaireObjet.ajouterDansLinventaire(case6);
		inventaireResource=new ArrayList<>();
		inventaireResource.add(bois);
		inventaireResource.add(pierre);
		inventaireResource.add(metal);
		
	}

	public void crafterEpee() {
		
		if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(0).getTypeObjetProerty().getValue()!="epeeBois") {
			System.out.println("pas assez de bois");
		}
		
		else if(this.getInventaireObjet().getInventaire().get(0).getTypeObjetProerty().getValue()=="epeeBois")
			System.out.println("deja poseder");
		else if(inventaireResource.get(0).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(0).setObjet("epeeBois");
			inventaireResource.get(0).EnleverResource();
		}
		
	}
	
	public Inventaire getInventaireObjet() {
		return this.inventaireObjet;
	}
	
	public ArrayList<Resource> getInventaireResource() {
		return inventaireResource;
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


	public boolean getDroite() {
		return droite;
	}


	public void setDroite(boolean droite) {
		this.droite = droite;
	}


	public boolean getGauche() {
		return gauche;
	}


	public void setGauche(boolean gauche) {
		this.gauche = gauche;
	}


	public boolean getSaute() {
		return saute;
	}


	public void setSaute(boolean saute) {
		this.saute = saute;
	}




}
