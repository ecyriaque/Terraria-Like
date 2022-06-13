package jeu.vue;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import jeu.modele.Construction;
import jeu.modele.Joueur;
import jeu.modele.Map;

public class VueMap {
	private int[] tabMap;
	private TilePane carte;
	private ImageView imageActive;
	private ArrayList<Image> imagesMap;
	private ArrayList<Image> imageRessources;
	private Map env;
	private Joueur joueur;
//	private int prochaineTuileDroitePlacer =  (xtileDroitePlacer+(ytile*20));
	
	public VueMap(TilePane carte , Joueur j) {
		imageActive = new ImageView();
		imagesMap = new ArrayList<>();
		imagesMap.add(new Image("jeu/modele/image/map/ciel.png")); //0 ciel
		imagesMap.add(new Image("jeu/modele/image/map/terre.png")); //1 terre
		imagesMap.add(new Image("jeu/modele/image/map/sol.png")); //2 sol avec herbes
		imagesMap.add(new Image("jeu/modele/image/map/obsidienne.png")); //3 obsidennes
		imagesMap.add(new Image("jeu/modele/image/map/bois.png")); //4 bois
		imagesMap.add(new Image("jeu/modele/image/map/pierre.png")); //5 pierre
		imagesMap.add(new Image("jeu/modele/image/map/metal.png")); //6 metal
		imagesMap.add(new Image("jeu/modele/image/map/haut.png")); //7 haut de la map
		this.env = new Map();
		this.tabMap = env.getTab();
		this.carte = carte; 
		this.joueur = j;
		
		this.imageRessources = new ArrayList<>();
		this.imageRessources.add(new Image("jeu/modele/image/map/bois.png"));
		this.imageRessources.add(new Image("jeu/modele/image/map/pierre.png"));
		this.imageRessources.add(new Image("jeu/modele/image/map/metal.png"));
	}
	
	public void afficherMap() {
		for(int a=0 ; a<tabMap.length; a++) {
			switch(tabMap[a]) {
			case 0 :
				imageActive = new ImageView(imagesMap.get(tabMap[a]));
				break;
			case 1 :
				imageActive = new ImageView(imagesMap.get(tabMap[a]));
				break;
			case 2 :
				imageActive = new ImageView(imagesMap.get(tabMap[a]));
				break;
			case 3 :
				imageActive = new ImageView(imagesMap.get(tabMap[a]));
				break;
			case 4 :
				imageActive = new ImageView(imagesMap.get(tabMap[a]));
				break;
			case 5 :
				imageActive = new ImageView(imagesMap.get(tabMap[a]));
				break;
			case 6 :
				imageActive = new ImageView(imagesMap.get(tabMap[a]));
				break;
			case 7 :
				imageActive = new ImageView(imagesMap.get(tabMap[a]));
				break;
			}
			carte.getChildren().add(imageActive);
		}	
	}
	
	public void actualiserMapDroite() {
		carte.getChildren().remove(joueur.getProchaineTuileDroitePlacer());
		carte.getChildren().add(joueur.getProchaineTuileDroitePlacer(), new ImageView(imageRessources.get(joueur.getMatChoisi()) ));
	}
	
	public void actualiserMapGauche() {
		carte.getChildren().remove(joueur.getProchaineTuileGauchePlacer());
		carte.getChildren().add(joueur.getProchaineTuileGauchePlacer(), new ImageView (imageRessources.get(joueur.getMatChoisi()) ));
	}
	
	public void actualiserMapDroiteCasser() {
		carte.getChildren().remove(joueur.getProchaineTuileDroiteCasser());
		carte.getChildren().add(joueur.getProchaineTuileDroiteCasser(), new ImageView(imagesMap.get(0)));
	}
	
	public void actualiserMapGaucheCasser() {
		carte.getChildren().remove(joueur.getProchaineTuileGaucheCasser());
		carte.getChildren().add( joueur.getProchaineTuileGaucheCasser(), new ImageView(imagesMap.get(0)));
	}

	public int[] getTabMap() {
		return tabMap;
	}

	public void setTabMap(int[] tabMap) {
		this.tabMap = tabMap;
	}

	public Map getEnv() {
		return env;
	}

	public void setEnv(Map env) {
		this.env = env;
	}
	
	
	
	
}
