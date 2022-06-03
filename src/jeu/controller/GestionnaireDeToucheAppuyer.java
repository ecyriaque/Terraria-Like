package jeu.controller;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import jeu.modele.Collision;
import jeu.modele.Joueur;

public class GestionnaireDeToucheAppuyer implements EventHandler<KeyEvent>{
	private Pane root;
	private Joueur joueur;
	private int[]tabMap;
	private ImageView imgJoueur;
	private ArrayList<Image> images;
	boolean visible =false;
		private Pane menuCraft;
	public GestionnaireDeToucheAppuyer(Pane root,Joueur joueur,int[]tabMap, ImageView imgJoueur,Pane menuCraft) {
		this.root=root;
		this.joueur=joueur;
		this.tabMap=tabMap;
		this.imgJoueur = imgJoueur;
		this.menuCraft=menuCraft;
		this.images = new ArrayList<>();
		images.add(new Image("jeu/modele/image/gauche.png"));
		images.add(new Image("jeu/modele/image/droite.png"));
		images.add(new Image("jeu/modele/image/saut.png"));
	}
	@Override
	public void handle(KeyEvent arg0) {
		// TODO Auto-generated method stub
		root.setOnKeyPressed(e -> {
			switch(e.getCode()){
			case Q :
				this.imgJoueur.setImage(images.get(0));
				joueur.setGauche(true);
				break;
			case D :
				this.imgJoueur.setImage(images.get(1));
				joueur.setDroite(true);
				break;
			case Z :
				this.imgJoueur.setImage(images.get(2));
				if(Collision.graviter(joueur, tabMap)) {
					this.joueur.setSaute(true);
				}		
				break;
			case T :
				joueur.perdrepv();
				break;
			case Y :
				joueur.gagnerpv();
				break;         
			
			case U :
				joueur.getInventaireResource().get(0).ajouterResource();
				break;
			case I :
				
				if (visible==false) {
					menuCraft.setVisible(true);
					visible=true;
				}else if(visible==true) {
					menuCraft.setVisible(false);
					visible=false;
				}
				
				
				break;
			case O :
				joueur.getInventaireResource().get(2).ajouterResource();
				break;
			case P :
				joueur.getInventaireResource().get(0).retirerResource();
				joueur.getInventaireResource().get(1).retirerResource();
				joueur.getInventaireResource().get(2).retirerResource();
				break;
			case M :
				joueur.getInventaireObjet().getInventaire().get(0).setObjet("vide");
				joueur.getInventaireObjet().getInventaire().get(1).setObjet("vide");
				joueur.getInventaireObjet().getInventaire().get(2).setObjet("vide");
				joueur.getInventaireObjet().getInventaire().get(3).setObjet("vide");
				joueur.getInventaireObjet().getInventaire().get(4).setObjet("vide");
				joueur.getInventaireObjet().getInventaire().get(5).setObjet("vide");
				System.out.println(joueur.getInventaireObjet().getInventaire().toString());
				break;
			case L :
			
				System.out.println(joueur.getInventaireObjet().getInventaire().toString());
				break;
			}
		});
		
	}

}
