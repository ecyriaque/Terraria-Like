package jeu.modele.inventaire;

import java.util.ArrayList;

import jeu.modele.inventaire.objet.Arme;
import jeu.modele.inventaire.objet.Epee;
import jeu.modele.inventaire.objet.ObjetInventaire;

public class Inventaire {
	private ArrayList<ObjetInventaire> inventaire;
	public Inventaire() {
		inventaire =new ArrayList<ObjetInventaire>();
		
		
	}
	
	public void ajouterDansLinventaire(ObjetInventaire obj) {
		this.inventaire.add(obj);
	}
	
	public ArrayList<ObjetInventaire> getInventaire() {
		return this.inventaire;
	}

}

