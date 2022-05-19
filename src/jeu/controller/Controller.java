package jeu.controller;


import java.net.URL;
import jeu.modele.*;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controller implements Initializable{
	//VARIABLE
	@FXML
    private BorderPane root;//ROOT 
	@FXML
	private TilePane carte;//LA MAP
	@FXML
	private Pane conteneur;//CONTENEUR DES DIFFERENTS OBJETS
	Joueur joueur =new Joueur();//LE PERSONNAGE 	
	private Timeline gameLoop;	
	private ImageView img,coeurs;//IMAGE UTILISE
	
	//FONCTION GAGNE OU PERD UN COEUR
	@FXML
	void perdre1pv(ActionEvent event) {
		joueur.perdrepv();
	}
	@FXML
	void gaggner1(ActionEvent event) {
		joueur.gagnerpv();
	}
	//INITILISATION
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAnimation();
		// demarre l'animation
		gameLoop.play();
		int pxl = 40;
		int taille = 20;
		carte.setMaxSize(pxl*taille, pxl*taille);
		Vue.map(carte);
		afficherJoueur();
		afficherCoeurs();
	}
	
	//DEPLACEMENT DU PERSONNAGE
	@FXML
	void deplacer() {
		root.setOnKeyPressed(e -> {
            switch(e.getCode()){
            case Q :
            	img.setImage(new Image("jeu/modele/image/gauche.png"));
                joueur.allerAGauche();
                System.out.println(joueur.getX());
                break;
            case D :
            	img.setImage(new Image("jeu/modele/image/droite.png"));
                joueur.allerADroite();
                System.out.println(joueur.getX());
                break;
            case Z :
            	joueur.saut();
            	System.out.println(joueur.getY());
            	break;
            default:
                break;

            }
        });
	}
    
	//AFFICHAGE DU JOUEUR 
	public void afficherJoueur() {
		img = new ImageView(new Image("jeu/modele/image/droite.png"));
        img.translateXProperty().bind(joueur.xProperty());
        img.translateYProperty().bind(joueur.yProperty());
        conteneur.getChildren().add(img);  
	}
	//AFFICHAGE DES COEURS DU PERSONNAGES
	public void afficherCoeurs() {
		coeurs = new ImageView(new Image("jeu/modele/image/hearts.png"));
		coeurs.translateXProperty().setValue(-80);
		coeurs.translateYProperty().setValue(-100);
        conteneur.getChildren().add(coeurs);  
	}
	
	//BOUCLE QUI MET A JOUR LE NOMBRE DE COUEUR DU PERSONNAGE
	private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.127), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					
					switch (joueur.getNbCoeurs()) {
					case 5:
						coeurs.setImage(new Image("jeu/modele/image/hearts.png"));
					
						break;
					case 4:
						coeurs.setImage(new Image("jeu/modele/image/4hearts.png"));
					
						break;
					case 3:
						coeurs.setImage(new Image("jeu/modele/image/3hearts.png"));
						
						break;
					case 2:
						coeurs.setImage(new Image("jeu/modele/image/2hearts.png"));
						
						break;
					case 1:
						coeurs.setImage(new Image("jeu/modele/image/1hearts.png"));
					
						break;
							
					default:
						break;
					}
					
					gravite();
				})
				);
		
	
		gameLoop.getKeyFrames().add(kf);
	}
	
	//AJOUTE UNE GRAVITE
	public void gravite() {
		joueur.tombe();
	}
	
}
