package jeu.modele.inventaire;

import java.util.ArrayList;

import jeu.modele.inventaire.objet.ObjetInventaire;
import jeu.modele.inventaire.objet.caseInventaire;
import jeu.modele.inventaire.objet.arme.Arme;

public class Inventaire {
	private ArrayList<caseInventaire> inventaire;
	public Inventaire() {
		inventaire =new ArrayList<caseInventaire>();
		
		
	}
	
	public void ajouterDansLinventaire(caseInventaire obj) {
		this.inventaire.add(obj);
	}
	
	
	
	public ArrayList<caseInventaire> getInventaire() {
		return this.inventaire;
	}

}

