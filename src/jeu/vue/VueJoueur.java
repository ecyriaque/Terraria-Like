package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import jeu.modele.Joueur;

public class VueJoueur {
	//VARIABLES
	private Joueur joueur;
	private Pane conteneur;
	private ImageView imgActive;
	public VueJoueur (Pane conteneur, Joueur joueur) {
		this.joueur = joueur;
		this.conteneur = conteneur;
		this.imgActive=new ImageView(new Image("jeu/modele/image/vert.png"));
		conteneur.getChildren().add(imgActive);
	}
	

}
