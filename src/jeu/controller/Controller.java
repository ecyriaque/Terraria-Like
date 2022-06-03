package jeu.controller;
//IMPORT
import java.net.URL;

import jeu.modele.*;
import jeu.vue.VueJoueur;
import jeu.vue.VueMap;
import jeu.vue.VuePv;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
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
	private Joueur joueur =new Joueur();//creation du joueur
	private Timeline gameLoop;//boucle du jeu
	private ImageView coeurs;	//image du joueur et du nb de coeurs
	private int[]tabMap; //map (tableau)
	private boolean direction; // direction du joueur true=droite false=gauche
	private VueJoueur vueJ;

	//INITIALISATION
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAnimation();
		gameLoop.play();
		
	}
	
	//JOUEUR
	public  void joueur() {	
		vueJ = new VueJoueur(conteneur, joueur);
		vueJ.getImgActive().translateXProperty().bind(joueur.xProperty());
		vueJ.getImgActive().translateYProperty().bind(joueur.yProperty());
		vueJ.ajouterImageDuJoueur(); 
	}
	
	//GESTION DES TOUCHES
	@FXML
	void gestionDesTouches() {	
		GestionnaireDeToucheAppuyer toucheAppuyer =new GestionnaireDeToucheAppuyer(root, joueur, tabMap,vueJ.getImgActive());
		GestionnaireDeToucheLacher toucheLacher =new GestionnaireDeToucheLacher(root, joueur,vueJ.getImgActive());
		root.setOnKeyPressed(toucheAppuyer);
		root.setOnKeyReleased(toucheLacher);
	}
	
	//DEPLACEMENT DU JOUEUR
	public void deplacement() {
		if(this.joueur.getGauche()) {
			direction = false;
			if(!Collision.collisionGauche(joueur, tabMap)) {
				joueur.allerAGauche();
			}
		}
		if(this.joueur.getDroite()) {
			direction = true;
			if(!Collision.collisionDroite(joueur, tabMap)) {
				joueur.allerADroite();
			}
		}
		if(this.joueur.getSaute()) {
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
		block();
		tabMap=VueMap.map(carte);
		joueur();
		this.joueur.nbCoeurProperty().addListener(new ObeservateurPv(new VuePv(joueur, root), joueur));
		this.gestionDesTouches();
		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.05), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{			
					if(!Collision.graviter(joueur, tabMap)&& !this.joueur.getSaute() || joueur.getNbSaut()==6 || joueur.getY()==10) 
						joueur.tomber();
					if(Collision.graviter(joueur, tabMap)) 
						joueur.setNbSaut(0);
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
	
	public void block() {
		root.setOnMouseClicked(ev -> {
			int xtile;
			int ytile;
			int prochaineTuile;	
			int valTab;
				if(direction) { // droite
					if(ev.getButton().equals(MouseButton.PRIMARY)) { //placer des blocks
						xtile=(joueur.getX()+40)/40;
						ytile=(joueur.getY()+20)/40;
						prochaineTuile = (xtile+(ytile*20));
						valTab=tabMap[prochaineTuile];
						if(valTab!=2 && valTab!=1 && valTab!=8 && valTab!=5 && valTab!=6 && valTab!=7 && valTab!=3) {
							carte.getChildren().remove(prochaineTuile);
							tabMap[prochaineTuile] = 5;
							carte.getChildren().add(prochaineTuile,new ImageView(new Image("jeu/modele/image/map/bois.png")) );
						}
					}else if(ev.getButton().equals(MouseButton.SECONDARY)){ // casser des blocks
						xtile=(joueur.getX()+40)/40;
						ytile=(joueur.getY()+20)/40;
						prochaineTuile = xtile+(ytile*20);
						valTab=tabMap[prochaineTuile];
						if(valTab!=3 && valTab!=1 && valTab!=2 && valTab!=8 && valTab!=4) {
							carte.getChildren().remove(prochaineTuile);
							tabMap[prochaineTuile] = 0;
							carte.getChildren().add(prochaineTuile,new ImageView(new Image("jeu/modele/image/map/ciel.png")) );
						}
					}
				}else{ // gauche
					if(ev.getButton().equals(MouseButton.PRIMARY)) { // placer des blocks
						xtile=(joueur.getX()-1)/40;
						ytile=joueur.getY()/40;
						prochaineTuile = xtile+(ytile*20);
						valTab=tabMap[prochaineTuile];
						if(valTab!=2 && valTab!=1 && valTab!=8 && valTab!=5 && valTab!=6 && valTab!=7 && valTab!=3) {
							carte.getChildren().remove(prochaineTuile);
							tabMap[prochaineTuile] = 5;
							carte.getChildren().add(prochaineTuile,new ImageView(new Image("jeu/modele/image/map/bois.png")) );
						}
					}else if(ev.getButton().equals(MouseButton.SECONDARY)){ // casser des blocks
						xtile=(joueur.getX()-1)/40;
						ytile=joueur.getY()/40;
						prochaineTuile = xtile+(ytile*20);
						valTab=tabMap[prochaineTuile];
						if(valTab!=3 && valTab!=1 && valTab!=2 && valTab!=8 && valTab!=4) {
							carte.getChildren().remove(prochaineTuile);
							tabMap[prochaineTuile] = 0;
							carte.getChildren().add(prochaineTuile,new ImageView(new Image("jeu/modele/image/map/ciel.png")) );
						}
					}
				}
		});
	}
	
}
