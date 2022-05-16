package jeu.controller;


import java.io.InputStream;
import java.net.URL;
import jeu.modele.*;
import java.util.ResourceBundle;
import jeu.modele.*;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller implements Initializable{
	@FXML
    private BorderPane root;
	@FXML
	private TilePane carte;
	@FXML
	private Pane conteneur;
	Joueur j =new Joueur();
	private ImageView img;
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int pxl = 40;
		int taille = 20;
		carte.setMaxSize(pxl*taille, pxl*taille);
		this.map();
		this.joueur();
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
        img.translateXProperty().bind(j.xProperty());
        img.translateYProperty().bind(j.yProperty());
        conteneur.getChildren().add(img);  
        System.out.println("jjj");
	}
	
	@FXML
	void deplacer() {
		root.setOnKeyPressed(e -> {
            switch(e.getCode()){
            case Q :
            	img.setImage(new Image("jeu/modele/image/gauche.png"));
                j.allerAGauche();
                System.out.println(j.getX());
                break;
            case D :
            	img.setImage(new Image("jeu/modele/image/droite.png"));
                j.allerADroite();
                System.out.println(j.getX());
            default:
                break;

            }
        });
	}
	
	public void sauter() {
		 root.setOnKeyTyped(e -> {
			switch(e.getCode()) {
			case SPACE :
				
			}
		 });
	}
}
