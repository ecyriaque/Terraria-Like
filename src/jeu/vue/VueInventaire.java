package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import jeu.modele.Joueur;
import jeu.modele.objet.Bandage;
import jeu.modele.objet.Epee;

public class VueInventaire {

	private Joueur joueur;
	private HBox	boxInv;
	public VueInventaire(Joueur joueur,HBox boxInv) {
		this.joueur=joueur;
		this.boxInv=boxInv;
		afficherInventaire();
	}
	
	public void afficherInventaire() {
		for (int i = 0; i < 5; i++) {
			if (joueur.getInventaire().get(i) instanceof Epee) {
				ImageView imgJoueur = new ImageView(new Image("jeu/modele/image/epeebois.png"));
				this.boxInv.getChildren().add(imgJoueur);
			}
			else if(joueur.getInventaire().get(i) instanceof Bandage){
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
