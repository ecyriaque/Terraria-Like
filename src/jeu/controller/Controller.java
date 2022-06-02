package jeu.controller;
//IMPORT
import java.net.URL;
import jeu.modele.*;
import jeu.modele.objet.Bandage;
import jeu.modele.objet.Objet;
import jeu.modele.objet.ObjetSoin;
import jeu.vue.VueInventaire;
import jeu.vue.VueMap;
import jeu.vue.VuePv;

import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Controller implements Initializable{
	//VARIABLES FXML
	@FXML
	private Pane root;//ROOT
	@FXML
	private TilePane carte;//MAP
	@FXML
	private Pane conteneur;//JOUEUR
	//VARIABLES
	Joueur joueur =new Joueur();//creation du joueur
	private Timeline gameLoop;//boucle du jeu
	private ImageView imgJoueur;//image du joueur et du nb de coeurs
	private int[]tabMap; //map (tableau)
	

	    @FXML
	    private HBox inventaireObjet;

	    @FXML
	    private Label labelBois;

	    @FXML
	    private Label labelMetal;

	    @FXML
	    private Label labelPierre;

	//INITIALISATION
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAnimation();
		gameLoop.play();
		GestionnaireDeToucheAppuyer toucheAppuyer =new GestionnaireDeToucheAppuyer(root, joueur, tabMap);
		GestionnaireDeToucheLacher toucheLacher =new GestionnaireDeToucheLacher(root, joueur);
		root.setOnKeyPressed(toucheAppuyer);
		root.setOnKeyReleased(toucheLacher);
		System.out.println(this.joueur.getInventaireObjet());
	}
	
	//JOUEUR
	public  void joueur() {	
		imgJoueur = new ImageView(new Image("jeu/modele/image/vert.png"));
		imgJoueur.translateXProperty().bind(joueur.xProperty());
		imgJoueur.translateYProperty().bind(joueur.yProperty());
		conteneur.getChildren().add(imgJoueur);  
	}
	
	//GESTION DES TOUCHES
	
	
	
	
	//DEPLACEMENT DU JOUEUR
	public void deplacement() {
		if(this.joueur.getGauche()) {
			imgJoueur.setImage(new Image("jeu/modele/image/vert.png"));		
			if(!Collision.collisionGauche(joueur, tabMap)) {
				joueur.allerAGauche();
			}
		}
		if(this.joueur.getDroite()) {
			imgJoueur.setImage(new Image("jeu/modele/image/vert.png"));
			if(!Collision.collisionDroite(joueur, tabMap)) {
				joueur.allerADroite();
			}
		}
		if(this.joueur.getSaute()) {
			imgJoueur.setImage(new Image("jeu/modele/image/vert.png"));
			if(!Collision.collisionHaut(joueur, tabMap)) {
				joueur.sauter();
			}		
		}
	}
	
	//BOUCLE DU JEU
	private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		int pxl = 40;
		int taille = 20;
		carte.setMaxSize(pxl*taille, pxl*taille);
		tabMap=VueMap.map(carte);
		joueur();
		this.joueur.nbCoeurProperty().addListener(new ObeservateurPv(new VuePv(joueur, root), joueur));
		VueInventaire vueInventaire = new VueInventaire(joueur, inventaireObjet,labelBois,labelPierre,labelMetal);
		
		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.050), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{			
					
					if(!Collision.graviter(joueur, tabMap)&& !this.joueur.getSaute() || joueur.getNbSaut()==6) {
						joueur.tomber();
						System.out.println(joueur.getY());
					}
					if(Collision.graviter(joueur, tabMap)) {
						joueur.setNbSaut(0);
					}
					deplacement();
				}));
		gameLoop.getKeyFrames().add(kf);
	}

}
