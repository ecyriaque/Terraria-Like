package jeu.modele;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class HitBox {
	
	//Variables
	private int xtileDroite;
	private int xtileGauche;
	private int ytile;
	private int prochaineTuileDroite;
	private int prochaineTuileGauche;	
	private int valTabDroite;
	private int valTabGauche;
	private TilePane c;
	private int[] map;
	
	//Construceur
	public HitBox(Joueur joueur, TilePane carte, int[] tabMap) {
		this.c = carte;
		this.map = tabMap;
		this.ytile = (joueur.getY()+20)/40;
		this.xtileDroite = (joueur.getX()+40)/40;
		this.prochaineTuileDroite =  (xtileDroite+(ytile*20));
		this.valTabDroite = tabMap[prochaineTuileDroite];
		this.xtileGauche = ((joueur.getX()-1)/40);
		this.prochaineTuileGauche =  (xtileGauche+(ytile*20));
		this.valTabGauche = tabMap[prochaineTuileGauche];
	}
	
	//DROITE
	public boolean peutPlacerDroite() {
		return (valTabDroite!=1 && valTabDroite!=2 && valTabDroite!=3 && valTabDroite!=5 && valTabDroite!=6 && valTabDroite!=7 && valTabDroite!=8);
	}
	public boolean peutCasserDroite() {
		return (valTabDroite!=1 && valTabDroite!=2 && valTabDroite!=3 && valTabDroite!=4 && valTabDroite!=8);
	}
	public void placerTuileDroite() {
		c.getChildren().remove(this.prochaineTuileDroite);
		map[this.prochaineTuileDroite] = 5;
		c.getChildren().add(this.prochaineTuileDroite,new ImageView(new Image("jeu/modele/image/map/bois.png")) );
	}
	public void casserTuileDroite() {
		c.getChildren().remove(this.prochaineTuileDroite);
		map[this.prochaineTuileDroite] = 0;
		c.getChildren().add(this.prochaineTuileDroite,new ImageView(new Image("jeu/modele/image/map/ciel.png")) );
	}
	
	//GAUCHE
	public boolean peutPlacerGauche() {
		return (valTabGauche!=1 && valTabGauche!=2 && valTabGauche!=3 && valTabGauche!=5 && valTabGauche!=6 && valTabGauche!=7 && valTabGauche!=8);
	}
	public boolean peutCasserGauche() {
		return (valTabGauche!=1 && valTabGauche!=2 && valTabGauche!=3 && valTabGauche!=4 && valTabGauche!=8);
	}
	public void placerTuileGauche() {
		c.getChildren().remove(this.prochaineTuileGauche);
		map[this.prochaineTuileGauche] = 5;
		c.getChildren().add(this.prochaineTuileGauche,new ImageView(new Image("jeu/modele/image/map/bois.png")) );
	}
	public void casserTuileGauche() {
		c.getChildren().remove(this.prochaineTuileGauche);
		map[this.prochaineTuileGauche] = 0;
		c.getChildren().add(this.prochaineTuileGauche,new ImageView(new Image("jeu/modele/image/map/ciel.png")) );
	}
	
	//Getters
	public int getXtileDroite() {
		return xtileDroite;
	}
	public int getXtileGauche() {
		return xtileGauche;
	}
	public int getYtile() {
		return ytile;
	}
	public int getProchaineTuileDroite() {
		return prochaineTuileDroite;
	}
	public int getProchaineTuileGauche() {
		return prochaineTuileGauche;
	}
	public int getValTabDroite() {
		return valTabDroite;
	}
	public int getValTabGauche() {
		return valTabGauche;
	}
	public TilePane getC() {
		return c;
	}
	public int[] getMap() {
		return map;
	}
	
	
	//Setters
	public void setXtileDroite(int xtileDroite) {
		this.xtileDroite = xtileDroite;
	}
	public void setXtileGauche(int xtileGauche) {
		this.xtileGauche = xtileGauche;
	}
	public void setYtile(int ytile) {
		this.ytile = ytile;
	}
	public void setProchaineTuileDroite(int prochaineTuileDroite) {
		this.prochaineTuileDroite = prochaineTuileDroite;
	}
	public void setProchaineTuileGauche(int prochaineTuileGauche) {
		this.prochaineTuileGauche = prochaineTuileGauche;
	}
	public void setValTabDroite(int valTabDroite) {
		this.valTabDroite = valTabDroite;
	}
	public void setValTabGauche(int valTabGauche) {
		this.valTabGauche = valTabGauche;
	}
	public void setC(TilePane c) {
		this.c = c;
	}
	public void setMap(int[] map) {
		this.map = map;
	}
}
