package jeu.modele;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class HitBox {
	
	//Variables
	private int xtileDroitePlacer;
	private int xtileGauchePlacer;
	
	private int ytile;
	
	private int prochaineTuileDroitePlacer;
	private int prochaineTuileGauchePlacer;	
	
	private int xtileDroiteCasser;
	private int xtileGaucheCasser;
	
	private int prochaineTuileDroiteCasser;
	private int prochaineTuileGaucheCasser;	
	
	private int valTabDroitePlacer;
	private int valTabGauchePlacer;
	
	private int valTabDroiteCasser;
	private int valTabGaucheCasser;
	
	private TilePane c;
	private int[] map;
	private Joueur joueur;
	
	
	//Construceur
	public HitBox(Joueur joueur, TilePane carte, int[] tabMap  ) {
		this.c = carte;
		this.map = tabMap;
		this.joueur = joueur;
		this.ytile = (joueur.getY()+20)/40;
		
		this.xtileDroitePlacer = ((joueur.getX()+79)/40);
		this.prochaineTuileDroitePlacer =  (xtileDroitePlacer+(ytile*20));
		this.valTabDroitePlacer = tabMap[prochaineTuileDroitePlacer];
		
		this.xtileGauchePlacer = ((joueur.getX()-40)/40);
		this.prochaineTuileGauchePlacer =  (xtileGauchePlacer+(ytile*20));
		this.valTabGauchePlacer = tabMap[prochaineTuileGauchePlacer];
		
		this.xtileDroiteCasser = ((joueur.getX()+40)/40);
		this.prochaineTuileDroiteCasser =  (xtileDroiteCasser+(ytile*20));
		this.valTabDroiteCasser = tabMap[prochaineTuileDroiteCasser];
		
		this.xtileGaucheCasser = ((joueur.getX()-1)/40);
		this.prochaineTuileGaucheCasser =  (xtileGaucheCasser+(ytile*20));
		this.valTabGaucheCasser = tabMap[prochaineTuileGaucheCasser];	
		
	}
	
	//DROITE
	public boolean peutPlacerDroite() {
		if(joueur.getInventaireResource().get(0).getResource().getValue() > 0  && Collision.graviter(joueur, map) )
			return (valTabDroitePlacer!=1 && valTabDroitePlacer!=2 && valTabDroitePlacer!=3 && valTabDroitePlacer!=4 && valTabDroitePlacer!=5 && valTabDroitePlacer!=6);
		return false;
	}
	
	public boolean peutCasserDroite() {
		return (valTabDroiteCasser!=0 && valTabDroiteCasser!=1 && valTabDroiteCasser!=2 && valTabDroiteCasser!=3 && valTabDroiteCasser!=7);
	}
	
	public void placerTuileDroite() {
		c.getChildren().remove(this.prochaineTuileDroitePlacer);
		map[this.prochaineTuileDroitePlacer] = 4;
		c.getChildren().add(this.prochaineTuileDroitePlacer,new ImageView(new Image("jeu/modele/image/map/bois.png")) );
		joueur.getInventaireResource().get(0).retirerResource();
	}
	public void casserTuileDroite() {
		c.getChildren().remove(this.prochaineTuileDroiteCasser);
		map[this.prochaineTuileDroiteCasser] = 0;
		c.getChildren().add(this.prochaineTuileDroiteCasser,new ImageView(new Image("jeu/modele/image/map/ciel.png")) );
		joueur.getInventaireResource().get(0).ajouterResource();
	}
	
	//GAUCHE
	public boolean peutPlacerGauche() {
		if(joueur.getInventaireResource().get(0).getResource().getValue() > 0 &&  Collision.graviter(joueur, map))
			return (valTabGauchePlacer!=1 && valTabGauchePlacer!=2 && valTabGauchePlacer!=3 && valTabGauchePlacer!=4 && valTabGauchePlacer!=5 && valTabGauchePlacer!=6);
		return false;
	}
	public boolean peutCasserGauche() {
		return (valTabGaucheCasser!=0 && valTabGaucheCasser!=1 && valTabGaucheCasser!=2 && valTabGaucheCasser!=3 && valTabGaucheCasser!=7);
	}
	public void placerTuileGauche() {
		c.getChildren().remove(this.prochaineTuileGauchePlacer);
		map[this.prochaineTuileGauchePlacer] = 4;
		c.getChildren().add(this.prochaineTuileGauchePlacer,new ImageView(new Image("jeu/modele/image/map/bois.png")) );
		joueur.getInventaireResource().get(0).retirerResource();
	}
	public void casserTuileGauche() {
		c.getChildren().remove(this.prochaineTuileGaucheCasser);
		map[this.prochaineTuileGaucheCasser] = 0;
		c.getChildren().add(this.prochaineTuileGaucheCasser,new ImageView(new Image("jeu/modele/image/map/ciel.png")) );
		joueur.getInventaireResource().get(0).ajouterResource();
	}
	
	//Getters
	public int getXtileDroite() {
		return xtileDroitePlacer;
	}
	public int getXtileGauche() {
		return xtileGauchePlacer;
	}
	public int getYtile() {
		return ytile;
	}
	public int getProchaineTuileDroite() {
		return prochaineTuileDroitePlacer;
	}
	public int getProchaineTuileGauche() {
		return prochaineTuileGauchePlacer;
	}
	public int getValTabDroite() {
		return valTabDroitePlacer;
	}
	public int getValTabGauche() {
		return valTabGauchePlacer;
	}
	public TilePane getC() {
		return c;
	}
	public int[] getMap() {
		return map;
	}
	
	
	//Setters
	public void setXtileDroitePlacer(int xtileDroite) {
		this.xtileDroitePlacer = xtileDroite;
	}
	public void setXtileGauchePlacer(int xtileGauche) {
		this.xtileGauchePlacer = xtileGauche;
	}
	public void setYtile(int ytile) {
		this.ytile = ytile;
	}
	public void setProchaineTuileDroitePlacer(int prochaineTuileDroite) {
		this.prochaineTuileDroitePlacer = prochaineTuileDroite;
	}
	public void setProchaineTuileGauchePlacer(int prochaineTuileGauche) {
		this.prochaineTuileGauchePlacer = prochaineTuileGauche;
	}
	public void setValTabDroite(int valTabDroite) {
		this.valTabDroitePlacer = valTabDroite;
	}
	public void setValTabGauche(int valTabGauche) {
		this.valTabGauchePlacer = valTabGauche;
	}
	public void setC(TilePane c) {
		this.c = c;
	}
	public void setMap(int[] map) {
		this.map = map;
	}
}
