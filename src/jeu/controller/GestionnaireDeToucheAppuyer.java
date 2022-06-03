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
	private Collision col;
	public GestionnaireDeToucheAppuyer(Pane root,Joueur joueur,int[]tabMap) {
		this.root=root;
		this.joueur=joueur;
		this.tabMap=tabMap;
		col=col;
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
			case U :
				joueur.getInventaireResource().get(0).ajouterResource();
				break;
			case I :
				joueur.getInventaireResource().get(1).ajouterResource();
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
			
			default:
				break;
			}
		});
		
	}

}
