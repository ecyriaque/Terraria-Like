package jeu.modele;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jeu.modele.resource.Resource;

public class Environnement {
	
	private Joueur joueur;
	private Resource bois,pierre,metal;
	private Map mape;
	private ArrayList<Resource> listeResource;
	private ObservableList<Ennemi> listeEnnemi;
	Ennemi ennemi;
	
	public Environnement() {
		this.listeEnnemi= FXCollections.observableArrayList();
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
	

	public void ajouter(Ennemi e) {
		this.listeEnnemi.add(e);
	}

	public void agit() {
		for (int i = 0; i < listeEnnemi.size(); i++) {
			ennemi=listeEnnemi.get(i);
			if(getJoueur().getX() < this.ennemi.getX() ) {
				ennemi.setGauche(true);
				ennemi.setDroite(false);
				ennemi.setDirection(2);
				if (!Collision.collisionGauche(ennemi,getTabMap())) 
					this.ennemi.allerAGauche();
			}
			else if(getJoueur().getX() > this.ennemi.getX()) {
				ennemi.setDroite(true);
				ennemi.setGauche(false);
				ennemi.setDirection(1);
				if(!Collision.collisionDroite(ennemi,getTabMap()))
					this.ennemi.allerADroite();	
			}
			else {
				ennemi.setDroite(false);
				ennemi.setGauche(false);
			}
			if(Collision.collisionDroiteEnnemi(ennemi,getTabMap()) && ennemi.isDroite()  || Collision.collisionGaucheEnnemi(ennemi,getTabMap()) && ennemi.isGauche() ) { 
				ennemi.sauter();
				ennemi.setDirection(3);
			}else if(!Collision.graviter(ennemi,getTabMap()) || Collision.collisionHaut(ennemi,getTabMap()) ) 
				ennemi.tomber();		
		}
		for(int i=listeEnnemi.size()-1; i>=0;i--){
			Ennemi a = listeEnnemi.get(i);
			if(a.getPv().get()==0)
				listeEnnemi.remove(i);
			if(a.getX()==getJoueur().getX()) 
				getJoueur().blesser();
		}
	}
	
	// getter resource 
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
	
	//getter
	public int[] getTabMap() {
		return mape.getTab();
	}
	public ArrayList<Resource> getListeResource() {
		return listeResource;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public ObservableList<Ennemi> getListeEnnemi() {
		return listeEnnemi;
	}
	
}