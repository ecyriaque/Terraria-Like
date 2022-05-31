package jeu.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import jeu.modele.Collision;
import jeu.modele.Joueur;

public class GestionnaireDeToucheAppuyer implements EventHandler<KeyEvent>{
	private Pane root;
	private Joueur joueur;
	private int[]tabMap;
	public GestionnaireDeToucheAppuyer(Pane root,Joueur joueur,int[]tabMap) {
		this.root=root;
		this.joueur=joueur;
		this.tabMap=tabMap;
	}
	@Override
	public void handle(KeyEvent arg0) {
		// TODO Auto-generated method stub
		root.setOnKeyPressed(e -> {
			switch(e.getCode()){
			case Q :
				joueur.setGauche(true);
				break;
			case D :
				joueur.setDroite(true);
				break;
			case Z :
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
			default:
				break;
			}
		});
		
	}

}
