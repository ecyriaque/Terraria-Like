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
	@FXML
    private BorderPane root;
	@FXML
	private TilePane carte;
	@FXML
	private Pane conteneur;
	Joueur joueur =new Joueur();
	
	private Timeline gameLoop;
	
	private int temps;
	private ImageView img,coeurs;

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
		this.map();
		this.joueur();
		afficherCoeurs();
		
		

//		// actions clavier:
//		root.setOnMouseEntered(e -> {
//			
//			switch (joueur.getNbCoeurs()) {
//			case 5:
//				coeurs.setImage(new Image("jeu/modele/image/hearts.png"));
//				System.out.println("4coeurs");
//				break;
//			case 4:
//				coeurs.setImage(new Image("jeu/modele/image/4hearts.png"));
//				System.out.println("4coeurs");
//				break;
//			case 3:
//				coeurs.setImage(new Image("jeu/modele/image/3hearts.png"));
//				System.out.println("3coeurs");
//				break;
//			case 2:
//				coeurs.setImage(new Image("jeu/modele/image/2hearts.png"));
//				System.out.println("2coeurs");
//				break;
//			case 1:
//				coeurs.setImage(new Image("jeu/modele/image/1hearts.png"));
//				System.out.println("1coeurs");
//				break;
//					
//			default:
//				break;
//			}
//			
//		});
		
	}
	
	public void map () {
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
            default:
                break;

            }
        });
	}
    
	public void afficherCoeurs() {
		coeurs = new ImageView(new Image("jeu/modele/image/hearts.png"));
		coeurs.translateXProperty().setValue(-80);
		coeurs.translateYProperty().setValue(-100);
        conteneur.getChildren().add(coeurs);  
	}
	
	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
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
				})
				);
		gameLoop.getKeyFrames().add(kf);
	}
	
}
