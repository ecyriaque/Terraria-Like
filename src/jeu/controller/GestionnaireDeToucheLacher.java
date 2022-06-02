package jeu.controller;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import jeu.modele.Collision;
import jeu.modele.Joueur;

public class GestionnaireDeToucheLacher implements EventHandler<KeyEvent>{
	private Pane root;
	private Joueur joueur;
	private Image imageNeutre;
	private ImageView imgJoueur;

	public GestionnaireDeToucheLacher(Pane root,Joueur joueur, ImageView imgJoueur) {
		this.root=root;
		this.joueur=joueur;
		this.imgJoueur = imgJoueur;
		this.imageNeutre = new Image ("jeu/modele/image/neutre.png");
	}
	@Override
	public void handle(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		root.setOnKeyReleased(ev -> {
			switch(ev.getCode()){
			case Q :
				imgJoueur.setImage(imageNeutre);
				this.joueur.setGauche(false);
				break;
			case D :
				imgJoueur.setImage(imageNeutre);
				this.joueur.setDroite(false);
				break;
			case Z :
				imgJoueur.setImage(imageNeutre);
				this.joueur.setSaute(false);
				break;
			default :
				break;
			}
		});
	}

}
