package jeu.vue;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import jeu.modele.Joueur;
//import jeu.modele.objet.Bandage;



public class VueInventaire {

	private Joueur joueur;
	private HBox	boxInv;
	private Label labelBois,labelPierre,labelMetal;
	
	public VueInventaire(Joueur joueur,HBox boxInv,Label labelBois,Label labelPierre,Label labelMetal) {
		this.joueur=joueur;
		this.boxInv=boxInv;
		this.labelBois=labelBois;
		this.labelPierre=labelPierre;
		this.labelMetal=labelMetal;
		afficherInventaireObjet();
	}
	
	public void afficherInventaireObjet() {
		joueur.getInventaireResource().get(0).getResource().addListener((obse,old,nouv)-> this.labelBois.setText(nouv.toString()));
		joueur.getInventaireResource().get(1).getResource().addListener((obse,old,nouv)-> this.labelPierre.setText(nouv.toString()));
		joueur.getInventaireResource().get(2).getResource().addListener((obse,old,nouv)-> this.labelMetal.setText(nouv.toString()));
		
		for (int i = 0; i < joueur.getInventaireObjet().getInventaire().size(); i++) {
			joueur.getInventaireObjet().getInventaire().get(i).getTypeObjetProerty().addListener((obse,old,nouv)-> actualiser());
			switch (joueur.getInventaireObjet().getInventaire().get(i).getTypeObjet()) {
			case "epeeBois":
				
				ImageView case1 = new ImageView(new Image("jeu/modele/image/epeebois.png"));
				this.boxInv.getChildren().add(case1);
				break;
			case "bandage":
				ImageView case2 = new ImageView(new Image("jeu/modele/image/bandage.png"));
				this.boxInv.getChildren().add(case2);
				break;
				
			case "vide":
				ImageView case3 = new ImageView(new Image("jeu/modele/image/carrerVide.png"));
				this.boxInv.getChildren().add(case3);
				break;
				
			case "kitDeSoin":
				ImageView case4= new ImageView(new Image("jeu/modele/image/kitDeSoin.png"));
				this.boxInv.getChildren().add(case4);
				break;	

			default:
				break;
			}
			
		}		
			
	}
	
	public void actualiser() {
		for (int i = 0; i < joueur.getInventaireObjet().getInventaire().size(); i++) {
			switch (joueur.getInventaireObjet().getInventaire().get(i).getTypeObjet()) {
			case "epeeBois":
				
				ImageView case1 = new ImageView(new Image("jeu/modele/image/epeebois.png"));
				this.boxInv.getChildren().remove(i);
				this.boxInv.getChildren().add(i, case1);
				break;
			case "bandage":
				ImageView case2 = new ImageView(new Image("jeu/modele/image/bandage.png"));
				this.boxInv.getChildren().remove(i);
				this.boxInv.getChildren().add(i, case2);
				break;
				
			case "vide":
				ImageView case3 = new ImageView(new Image("jeu/modele/image/carrerVide.png"));
				this.boxInv.getChildren().remove(i);
				this.boxInv.getChildren().add(i, case3);
				break;
				
			case "kitDeSoin":
				ImageView case4= new ImageView(new Image("jeu/modele/image/kitDeSoin.png"));
				this.boxInv.getChildren().remove(i);
				this.boxInv.getChildren().add(i, case4);
				break;	

			default:
				break;
			}
			
		}
	}
	
	
}
