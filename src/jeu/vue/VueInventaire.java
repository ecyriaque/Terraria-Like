package jeu.vue;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import jeu.modele.Joueur;
import jeu.modele.objet.Bandage;
import jeu.modele.objet.Epee;

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
		
		for (int i = 0; i < 5; i++) {
			if (joueur.getInventaireObjet().get(i) instanceof Epee) {
				ImageView imgJoueur = new ImageView(new Image("jeu/modele/image/epeebois.png"));
				this.boxInv.getChildren().add(imgJoueur);
			}
			else if(joueur.getInventaireObjet().get(i) instanceof Bandage){
				ImageView imgJoueur = new ImageView(new Image("jeu/modele/image/bandage.png"));
				this.boxInv.getChildren().add(imgJoueur);
			}
				else {
					ImageView imgJoueur = new ImageView(new Image("jeu/modele/image/carrerVide.png"));
					this.boxInv.getChildren().add(imgJoueur);
					
			}
		
			}
	}
	
	
	
	
}
