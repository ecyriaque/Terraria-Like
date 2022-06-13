package jeu.modele;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Construction {
	
	//Variables
	private int valTabDroitePlacer;
	private int valTabGauchePlacer;	
	private int valTabDroiteCasser;
	private int valTabGaucheCasser;
	private int[] map;
	private Joueur joueur;	
	private ArrayList<Integer> tuileDure ;
	private ArrayList<Integer> tuileCassable;
	
	//Construceur
	public Construction(Joueur joueur, int[] tabMap  ) {
		this.tuileDure = new ArrayList<>();
		tuileDure.add(1);
		tuileDure.add(2);
		tuileDure.add(3);
		tuileDure.add(4);
		tuileDure.add(5);
		tuileDure.add(6);
		this.tuileCassable = new ArrayList<>();
		tuileCassable.add(4);
		tuileCassable.add(5);
		tuileCassable.add(6);
		
		this.map = tabMap;
		this.joueur = joueur;
		
		this.valTabDroitePlacer = tabMap[joueur.getProchaineTuileDroitePlacer()];	
		this.valTabGauchePlacer = tabMap[joueur.getProchaineTuileGauchePlacer()];	
		this.valTabDroiteCasser = tabMap[joueur.getProchaineTuileDroiteCasser()];	
		this.valTabGaucheCasser = tabMap[joueur.getProchaineTuileGaucheCasser()];	
		
	}
	
	//DROITE
	//placer
	public boolean peutPlacerDroite() {
		if(joueur.getInventaireResources().get(joueur.getMatChoisi()).getResource().getValue() > 0  && Collision.graviter(joueur, map) )
			return (!tuileDure.contains(valTabDroitePlacer));
		return false;
	}
	public boolean placerTuileDroite() {
		map[joueur.getProchaineTuileDroitePlacer()] = joueur.getMatChoisi()+4;
		joueur.getInventaireResources().get(joueur.getMatChoisi()).retirerResource();
		return true;
	}
	//casser
	public boolean peutCasserDroite() {
		return tuileCassable.contains(valTabDroiteCasser);
	}
	public void casserTuileDroite() {
		map[joueur.getProchaineTuileDroiteCasser()] = 0;
		if(valTabDroiteCasser==4)
			joueur.getInventaireResources().get(0).ajouterResource();
		else if (valTabDroiteCasser == 5)
			joueur.getInventaireResources().get(1).ajouterResource();
		else
			joueur.getInventaireResources().get(2).ajouterResource();
	}
	
	
	
	//GAUCHE
	//placer
	public boolean peutPlacerGauche() {
		if(joueur.getInventaireResources().get(joueur.getMatChoisi()).getResource().getValue() > 0 &&  Collision.graviter(joueur, map)  )
			return !tuileDure.contains(valTabGauchePlacer);
		return false;
	}
	public void placerTuileGauche() {
		map[joueur.getProchaineTuileGauchePlacer()] = joueur.getMatChoisi() + 4;
		joueur.getInventaireResources().get(joueur.getMatChoisi()).retirerResource();
	}
	//casser
	public boolean peutCasserGauche() {
		return tuileCassable.contains(valTabGaucheCasser);
	}
	public void casserTuileGauche() {
		map[joueur.getProchaineTuileGaucheCasser()] = 0;
		if(valTabGaucheCasser==4)
			joueur.getInventaireResources().get(0).ajouterResource();
		else if (valTabGaucheCasser == 5)
			joueur.getInventaireResources().get(1).ajouterResource();
		else
			joueur.getInventaireResources().get(2).ajouterResource();
	}
	
	
	
	//Getters
	public int getValTabDroite() {
		return valTabDroitePlacer;
	}
	public int getValTabGauche() {
		return valTabGauchePlacer;
	}
	public int[] getMap() {
		return map;
	}
	public int getValTabDroitePlacer() {
		return valTabDroitePlacer;
	}
	public int getValTabGauchePlacer() {
		return valTabGauchePlacer;
	}
	public int getValTabDroiteCasser() {
		return valTabDroiteCasser;
	}
	public int getValTabGaucheCasser() {
		return valTabGaucheCasser;
	}
	public ArrayList<Integer> getTuileDure() {
		return tuileDure;
	}
	public ArrayList<Integer> getTuileCassable() {
		return tuileCassable;
	}

	
	//Setters
	public void setValTabDroite(int valTabDroite) {
		this.valTabDroitePlacer = valTabDroite;
	}
	public void setValTabGauche(int valTabGauche) {
		this.valTabGauchePlacer = valTabGauche;
	}
	public void setMap(int[] map) {
		this.map = map;
	}
}
