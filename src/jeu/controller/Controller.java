package jeu.controller;
//IMPORT
import java.net.URL;
import jeu.modele.*;
import jeu.modele.inventaire.Inventaire;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
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
	private ImageView imgJoueur;//image du joueur et du nb de coeurs
	private int[]tabMap; //map (tableau)
		@FXML
		private Pane menuCraft;

	    @FXML
	    private HBox inventaireObjet;

	    @FXML
	    private Label labelBois;

	    @FXML
	    private Label labelMetal;

	    @FXML
	    private Label labelPierre;
	    
	    @FXML
	    private Text textCraft;

	//INITIALISATION
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAnimation();
		gameLoop.play();
		GestionnaireDeToucheAppuyer toucheAppuyer =new GestionnaireDeToucheAppuyer(root, joueur, tabMap);
		GestionnaireDeToucheLacher toucheLacher =new GestionnaireDeToucheLacher(root, joueur);
		root.setOnKeyPressed(toucheAppuyer);
		root.setOnKeyReleased(toucheLacher);
		
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
				// on dÃ©finit le FPS (nbre de frame par seconde)
				Duration.seconds(0.050), 
				// on dÃ©finit ce qui se passe Ã  chaque frame 
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
	
	
	  @FXML
	    void crafterBandage(MouseEvent event) {
		  joueur.crafterBandage();
	    }
	  
	   @FXML
	    void crafterEpeePierre(MouseEvent event) {
		   joueur.crafterEpeePierre();
	    }

    @FXML
    void ouuvrirInvcentaire(MouseEvent event) {
    	menuCraft.setVisible(true);
    }
    
    @FXML
    void crafterEpeeBois(MouseEvent event) {
    	joueur.crafterEpeeBois();
    }

    @FXML
    void fermerMenuCraft(MouseEvent event) {
    	menuCraft.setVisible(false);
    }
    
    @FXML
    void afficherTextBandage(MouseEvent event) {
    	textCraft.setText("3 de bois pour construire un bandage");
    	textCraft.setVisible(true);
    	
    }
    
    @FXML
    void enleverTextBandage(MouseEvent event) {
    	textCraft.setVisible(false);
    }
    @FXML
    void afficherTextPierre(MouseEvent event) {
    	textCraft.setText("3 de pierre pour construire une épee en pierre");
    	textCraft.setVisible(true);
    	
    }
    
    @FXML
    void enleverTextPierre(MouseEvent event) {
    	textCraft.setVisible(false);
    }
    @FXML
    void afficherTextBois(MouseEvent event) {
    	textCraft.setText("3 de bois pour construire une épee");
    	textCraft.setVisible(true);
    	
    }
    
    @FXML
    void enleverTextBois(MouseEvent event) {
    	textCraft.setVisible(false);
    }
}
