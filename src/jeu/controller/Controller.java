package jeu.controller;
//IMPORT
import java.net.URL;
import jeu.modele.*;
import jeu.vue.VueMap;
import jeu.vue.VuePv;

import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private ImageView imgJoueur,coeurs;	//image du joueur et du nb de coeurs
	private int[]tabMap; //map (tableau)
	private boolean droite,gauche,saute; //vraie si il se deplace ou saute
	
	private Circle red;

	//INITIALISATION
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAnimation();
		gameLoop.play();
		red = new Circle(3);
		red.setFill(Color.RED);
		red.setTranslateX(joueur.getX());
		red.setTranslateY(joueur.getY());
		conteneur.getChildren().add(red);
		red.translateXProperty().bind(joueur.xProperty());
		red.translateYProperty().bind(joueur.yProperty());
	}
	
	//JOUEUR
	public  void joueur() {	
		imgJoueur = new ImageView(new Image("jeu/modele/image/vert.png"));
		imgJoueur.translateXProperty().bind(joueur.xProperty());
		imgJoueur.translateYProperty().bind(joueur.yProperty());
		conteneur.getChildren().add(imgJoueur);  
	}
	
	//GESTION DES TOUCHES
	@FXML
	void gestionDesTouches() {	
		root.setOnKeyPressed(e -> {
			switch(e.getCode()){
			case Q :
				gauche=true;
				break;
			case D :
				droite=true;
				break;
			case Z :
				if(Collision.graviter(joueur, tabMap)) {
					saute=true;
				}		
				break;
			case T :
				joueur.perdrepv();
				break;
			case Y :
				joueur.gagnerpv();
				break;         
			default:
				break;
			}
		});
		root.setOnKeyReleased(ev -> {
			switch(ev.getCode()){
			case Q :
				gauche=false;
				break;
			case D :
				droite=false;
				break;
			case Z :
				saute=false;
				break;
			default :
				break;
			}
		});
	}
	
	//DEPLACEMENT DU JOUEUR
	public void deplacement() {
		if(gauche) {
			imgJoueur.setImage(new Image("jeu/modele/image/vert.png"));		
			if(!Collision.collisionGauche(joueur, tabMap)) {
				joueur.allerAGauche();
			}
		}
		if(droite) {
			imgJoueur.setImage(new Image("jeu/modele/image/vert.png"));
			if(!Collision.collisionDroite(joueur, tabMap)) {
				joueur.allerADroite();
			}
		}
		if(saute) {
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
		this.gestionDesTouches();
		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.127), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{			
					
					if(!Collision.graviter(joueur, tabMap)&& !saute || joueur.getNbSaut()==6) {
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

	public  void afficherCoeurs() {
		coeurs = new ImageView(new Image("jeu/modele/image/hearts.png"));
		coeurs.translateXProperty().setValue(0);
		coeurs.translateYProperty().setValue(-100);
		conteneur.getChildren().add(coeurs);  
	}
}
