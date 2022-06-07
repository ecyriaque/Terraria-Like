package jeu.vue;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import jeu.modele.Map;

public class VueMap {
	private int[] tabMap;
	private TilePane carte;
	private ImageView img;
	private ArrayList<Image> images;
	private Map env;
	
	public VueMap(TilePane carte) {
		img = new ImageView();
		images = new ArrayList<>();
		images.add(new Image("jeu/modele/image/map/ciel.png")); //0 ciel
		images.add(new Image("jeu/modele/image/map/terre.png")); //1 terre
		images.add(new Image("jeu/modele/image/map/sol.png")); //2 sol avec herbes
		images.add(new Image("jeu/modele/image/map/obsidienne.png")); //3 obsidennes
		images.add(new Image("jeu/modele/image/map/bois.png")); //4 bois
		images.add(new Image("jeu/modele/image/map/metal.png")); //5 metal
		images.add(new Image("jeu/modele/image/map/pierre.png")); //6 pierre
		images.add(new Image("jeu/modele/image/map/haut.png")); //7 haut de la map
		this.env = new Map();
		this.tabMap = env.getTab();
		this.carte = carte; 	
	}
	
	public void afficherMap() {
		for(int a=0 ; a<tabMap.length; a++) {
			switch(tabMap[a]) {
			case 0 :
				img = new ImageView(images.get(tabMap[a]));
				break;
			case 1 :
				img = new ImageView(images.get(tabMap[a]));
				break;
			case 2 :
				img = new ImageView(images.get(tabMap[a]));
				break;
			case 3 :
				img = new ImageView(images.get(tabMap[a]));
				break;
			case 4 :
				img = new ImageView(images.get(tabMap[a]));
				break;
			case 5 :
				img = new ImageView(images.get(tabMap[a]));
				break;
			case 6 :
				img = new ImageView(images.get(tabMap[a]));
				break;
			case 7 :
				img = new ImageView(images.get(tabMap[a]));
				break;
			}
			carte.getChildren().add(img);
		}	
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
