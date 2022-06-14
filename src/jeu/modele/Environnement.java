package jeu.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import jeu.modele.resource.Resource;

public class Environnement {
	private Joueur joueur;
	private Resource bois,pierre,metal;
	private Map mape;
	private ArrayList<Resource> listeResource;
	public Environnement() {
		
		this.joueur=new Joueur(this);
		this.mape = new Map();
		
		bois=new Resource();
		pierre = new Resource();
		metal=new Resource();
		
		listeResource= new ArrayList<>();
		listeResource.add(bois);
		listeResource.add(pierre);
		listeResource.add(metal);
	}
	//collision
	public boolean collisionGauche() {
		return Collision.collisionGauche(joueur,getTabMap());
	}
	public boolean collisionDroite() {
		return Collision.collisionDroite(joueur,getTabMap());
	}
	public boolean collisionHaut() {
		return Collision.collisionHaut(joueur,getTabMap());
	}
	public boolean graviter() {
		return Collision.graviter(joueur,getTabMap());
	}
	
	//map
	public int[] getTabMap() {
		return mape.getTab();
	}
	
	
	// resoruce bois,pierre,metal
	
	public Resource getResource(String matiere) {
		if (matiere.equals("bois")) {
			return this.bois;
		}else if (matiere.equals("pierre")) {
			return this.pierre;
		}else if (matiere.equals("metal")) {
			return this.metal;
		}
		return null;
	}
	
	public ArrayList<Resource> getListeResource() {
		return listeResource;
	}
	public final IntegerProperty getNbResourceProperty(String matiere){
		if (matiere.equals("bois")) {
			return this.bois.getNbResourceProperty();
		}else if (matiere.equals("pierre")) {
			return this.pierre.getNbResourceProperty();
		}else if (matiere.equals("metal")) {
			 return this.metal.getNbResourceProperty();
		}
		return null;
	}

	public int getNbResource(String matiere) {
		if (matiere.equals("bois")) {
			return bois.getNbResourceProperty().intValue();
		}else if (matiere.equals("pierre")) {
			return pierre.getNbResourceProperty().intValue();
		}else if (matiere.equals("metal")) {
			return metal.getNbResourceProperty().intValue();
		}
		return 0;
		
	}
	public void AjouterResource(String matiere) {
		if (matiere.equals("bois")) {
			bois.ajouterResource();
		}else if (matiere.equals("pierre")) {
			pierre.ajouterResource();
		}else if (matiere.equals("metal")) {
			metal.ajouterResource();
		}
		
	}
	
	public void EnleverResource(String matiere,int i) {
		if (matiere.equals("bois")) {
			bois.EnleverResource(i);
		}else if (matiere.equals("pierre")) {
			pierre.EnleverResource(i);
		}else if (matiere.equals("metal")) {
			metal.EnleverResource(i);
		}
	}
	public Joueur getJoueur() {
		return joueur;
	}
	

	

	
	
}