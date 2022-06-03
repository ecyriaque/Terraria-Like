package jeu.modele;

import javafx.scene.layout.TilePane;

public class HitBox {
	private int xtile;
	private int ytile;
	private int prochaineTuile;
	private int valeurTile;
	private TilePane carte;
	private Joueur joueur;
	
	public HitBox(TilePane carte, Joueur joueur, int[] tabMap) {
		this.carte = carte;
		this.joueur = joueur;
		this.xtile= (joueur.getX()+40)/40;
		this.ytile = joueur.getY()+20/40;
		this.prochaineTuile = xtile+(ytile*20);
	}
	
	//getters
	public int getXtile() {
		return xtile;
	}
	public int getYtile() {
		return ytile;
	}
	public int getProchaineTuile() {
		return prochaineTuile;
	}
	public int getValeurTile() {
		return valeurTile;
	}
	
	//setter
	public void setXtile(int xtile) {
		this.xtile = xtile;
	}
	
}
