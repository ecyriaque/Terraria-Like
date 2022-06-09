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
import jeu.modele.inventaire.objet.ObjetVide;
import jeu.modele.inventaire.objet.objetSoin.KitDeSoin;

public class GestionnaireDeToucheAppuyer implements EventHandler<KeyEvent>{
	private Pane root;
	private Joueur joueur;
	private int[]tabMap;
	private ImageView imgJoueur;
	private ArrayList<Image> images;
	private boolean visible =false;
	private Pane menuCraft;
	private ImageView craftInventaire;
	
	public GestionnaireDeToucheAppuyer(Pane root,Joueur joueur,int[]tabMap, ImageView imgJoueur,Pane menuCraft, ImageView InventaireCraft) {
		this.root=root;
		this.joueur=joueur;
		this.tabMap=tabMap;
		this.imgJoueur = imgJoueur;
		this.menuCraft=menuCraft;
		this.craftInventaire = InventaireCraft;
		
		this.images = new ArrayList<>();
		images.add(new Image("jeu/modele/image/personnage/gauche.png"));
		images.add(new Image("jeu/modele/image/personnage/droite.png"));
		images.add(new Image("jeu/modele/image/personnage/saut.png"));
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
				joueur.blesser();
				break;
			case Y :
				joueur.gagnerPv();
				break;         
			
			case U :
				joueur.getInventaireResources().get(0).ajouterResource();
				break;
			case I :
				
				if (visible==false) {
					menuCraft.setVisible(true);
					craftInventaire.setVisible(true);
					visible=true;
				}else if(visible==true) {
					menuCraft.setVisible(false);
					craftInventaire.setVisible(false);
					visible=false;
				}
				
				
				break;
			case O :
				joueur.getInventaireResources().get(2).ajouterResource();
				break;
			case W :
				joueur.getInventaireResources().get(1).ajouterResource();
				break;
			case P :
				joueur.getInventaireResources().get(0).retirerResource();
				joueur.getInventaireResources().get(1).retirerResource();
				joueur.getInventaireResources().get(2).retirerResource();
				break;
			case M :
				joueur.getInventaireObjet().getInventaire().get(0).setObjetDeLaCase(new ObjetVide());
				joueur.getInventaireObjet().getInventaire().get(1).setObjetDeLaCase(new ObjetVide());
				joueur.getInventaireObjet().getInventaire().get(2).setObjetDeLaCase(new ObjetVide());
				joueur.getInventaireObjet().getInventaire().get(3).setObjetDeLaCase(new ObjetVide());
				joueur.getInventaireObjet().getInventaire().get(4).setObjetDeLaCase(new ObjetVide());
				joueur.getInventaireObjet().getInventaire().get(5).setObjetDeLaCase(new ObjetVide());
				System.out.println(joueur.getInventaireObjet().getInventaire().toString());
				joueur.mettreAzero();
				break;
			case L :
			
				System.out.println(joueur.getInventaireObjet().getInventaire().toString());
				break;
			}
		});
		
	}

}
