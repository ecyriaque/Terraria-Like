package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import jeu.modele.Joueur;

public class VueJoueur {
	
	//variables
	private ImageView imgActive;
	private Pane conteneur;
	
	//constructeur
	public VueJoueur (Pane conteneur, Joueur joueur) {
		this.imgActive = new ImageView(new Image("jeu/modele/image/neutre.png"));
		this.conteneur = conteneur;
	}
	
	//getter
	public ImageView getImgActive() {
		return imgActive;
	}
	
	//setter
	public void setImgActive(ImageView imgActive) {
		this.imgActive = imgActive;
	}
	
	//methode
	public void ajouterImageDuJoueur() {
		conteneur.getChildren().add(imgActive);
	}
}
