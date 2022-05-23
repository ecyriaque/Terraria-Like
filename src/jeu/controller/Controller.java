package jeu.controller;


import java.net.URL;
import jeu.modele.*;
import java.util.ResourceBundle;

import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
public class Controller implements Initializable{
	//VARIABLE
	@FXML
    private Pane root;
	@FXML
	private TilePane carte;//LA MAP
	@FXML

	private Pane conteneur;//CONTENEUR DES DIFFERENTS OBJETS
	Joueur joueur =new Joueur();//LE PERSONNAGE 	
	private Timeline gameLoop;	
  private IntegerProperty ncoeurIntegerProperty=new SimpleIntegerProperty();
	private ImageView imgJoueur,coeurs;//IMAGE UTILIS
	private boolean saute =true , tombe = false; //action saut vraie si le personnage saute
	private int positionJoueurX,positionJoueurY;
	private int[]tabMap;
	
//FONCTION GAGNE OU PERD UN COEUR	//FONCTION GAGNE OU PERD UN COEUR
	
	 @FXML
	    void perdre1pv(ActionEvent event) {
		 joueur.perdrepv();
	    }

	   @FXML
	    void gaggner1(ActionEvent event) {
		   joueur.gagnerpv();
	    }
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAnimation();
		// demarre l'animation
		gameLoop.play();
		int pxl = 40;
		int taille = 20;
		carte.setMaxSize(pxl*taille, pxl*taille);
    tabMap=this.map();
    positionJoueurX = joueur.getX();
		positionJoueurY = joueur.getY();
    Vue.map(carte);
		afficherJoueur();
		afficherCoeurs();
    	this.joueur();
		afficherCoeurs();
		this.deplacer();
	}
	
	public  int[] map () {
		ImageView img = null;
		Environnement env = new Environnement ();
		int[] t = env.getTab();
		for(int a=0 ; a<t.length; a++) {
			switch(t[a]) {
			case 0 :
				
				img = new ImageView(new Image("jeu/modele/image/bleu.png"));
				break;
			case 1 :
				img = new ImageView(new Image("jeu/modele/image/marron.png"));
				break;
			case 2 :
				img = new ImageView(new Image("jeu/modele/image/vert.png"));
				break;
			case 3 :
				img = new ImageView(new Image("jeu/modele/image/gris.png"));
				break;
			case 4 :
				img = new ImageView(new Image("jeu/modele/image/violet.png"));
				break;
			}
			carte.getChildren().add(img);
		}
		return t;
	}
	
	public void joueur() {
		
		img = new ImageView(new Image("jeu/modele/image/droite.png"));
        img.translateXProperty().bind(joueur.xProperty());
        img.translateYProperty().bind(joueur.yProperty());
        conteneur.getChildren().add(img);  
	}
	

	@FXML
	void deplacer() {
		
		
		root.setOnKeyPressed(e -> {
        int xtile,ytile,ValeurTile;
			
			xtile=joueur.getX()/40;
			ytile=joueur.getY()/40;
			ValeurTile=tabMap[(xtile+(ytile*20))];
      
      if(e.getCode().equals(KeyCode.Q)) {
            	allerGauche();
			}
      else if(e.getCode().equals(KeyCode.D)) {
        if(!this.collisionDroite()) {
					joueur.allerADroite();
				}
            	System.out.println("x joueur : "+joueur.getX());
                System.out.println("x tile : "+xtile);
                System.out.println("ytile : "+ytile);
                System.out.println("numero de tile  : "+ValeurTile);
            	
			}
      else if (e.getCode().equals(KeyCode.Z) && saute) {
            	sauter();
			}
      else if(e.getCode().equals(KeyCode.T){
      joueur.perdrepv();
      }
               else if(e.getCode().equals(KeyCode.y){
      joueur.gagnerpv();
      }

        });
	}
	
   
	//AFFICHAGE DU JOUEUR 
	public void afficherJoueur() {
		imgJoueur = new ImageView(new Image("jeu/modele/image/droite.png"));
        imgJoueur.setX(100);
        imgJoueur.setY(350);
        conteneur.getChildren().add(imgJoueur);  
	}
	//AFFICHAGE DES COEURS DU PERSONNAGES
	public void afficherCoeurs() {
		coeurs = new ImageView(new Image("jeu/modele/image/hearts.png"));
		coeurs.translateXProperty().setValue(-80);
		coeurs.translateYProperty().setValue(-100);
        conteneur.getChildren().add(coeurs);  
	}
	
//BOUCLE QUI MET A JOUR LE NOMBRE DE COUEUR DU PERSONNAGE

	public void gestionDesPv() {
		switch (ncoeurIntegerProperty.getValue()) {
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
		case 0:
			
			System.exit(0);
			break;
				
		default:
			break;
		} 
	}
	private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		ncoeurIntegerProperty.bind(joueur.nbCoeurProperty());
		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.127), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					
					gestionDesPv();
					

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
					if (positionJoueurY == 270)
						System.out.println(positionJoueurY);

				})
				
				);

		gameLoop.getKeyFrames().add(kf);
	}
	

	public void allerDroite() {
		imgJoueur.setImage(new Image("jeu/modele/image/droite.png"));
    	TranslateTransition droite = new TranslateTransition(Duration.millis(1),imgJoueur);
    	droite.setByX(+8);
    	if(positionJoueurX < 750) {
    		droite.play();
        	positionJoueurX +=8;
    	}
	}
	
	public void allerGauche() {
		imgJoueur.setImage(new Image("jeu/modele/image/gauche.png"));
    	TranslateTransition gauche = new TranslateTransition(Duration.millis(1),imgJoueur);
    	gauche.setByX(-8);
    	if(positionJoueurX > -11) {
    		gauche.play();
        	positionJoueurX -=8;
    	}
	}
	
	public void sauter() {
		TranslateTransition saut = new TranslateTransition(Duration.millis(400),imgJoueur);
    	saut.setByY(-80);
    	if(positionJoueurY == 350 && saute) {
        	saut.play();
    		saute = false;
    	}
    	Timer peutSauterDans = new Timer();        
    	peutSauterDans.schedule(new TimerTask() {
			@Override
			public void run() {
				saute = true;
			}
		}, 1400);
    	Timer tempSaut = new Timer();        
    	tempSaut.schedule(new TimerTask() {
			@Override
			public void run() {
          		positionJoueurY -=80;
			}
		}, 400);
    	tombe();
	}
	
	public void tombe() {
		TranslateTransition tomber = new TranslateTransition(Duration.millis(400),imgJoueur);
		tomber.setByY(+80);
		Timer tempTombe = new Timer();
		tempTombe.schedule(new TimerTask() {
			@Override
			public void run() {
				tomber.play();
				positionJoueurY +=80; 
			}
		}, 1000);
	}
	

	public boolean collisionDroite(){
		int xtile,ytile,ValeurTile;
		
		xtile=(joueur.getX()+20)/40;
		ytile=joueur.getY()/40;
		ValeurTile=tabMap[(xtile+(ytile*20))];
		if (ValeurTile==1) {
			return true;
		}
		return false;
	}
	
	public boolean collisionGauche(){
		int xtile,ytile,ValeurTile;
		
		xtile=(joueur.getX()-20)/40;
		ytile=joueur.getY()/40;
		ValeurTile=tabMap[(xtile+(ytile*20))];
		if (ValeurTile==1) {
			return true;
		}
		return false;
	}
	


}
