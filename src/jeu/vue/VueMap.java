package jeu.vue;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import jeu.modele.Map;

public class VueMap {

	public static  int[] map (TilePane carte) {
		ImageView img = null;
		Map env = new Map ();
		int[] t = env.getTab();
		List<Image> images = new ArrayList<>();
		images.add(new Image("jeu/modele/image/bleu.png"));
		images.add(new Image("jeu/modele/image/marron.png"));
		images.add(new Image("jeu/modele/image/vert.png"));
		images.add(new Image("jeu/modele/image/gris.png"));	
		images.add(new Image("jeu/modele/image/violet.png"));
		
		for(int a=0 ; a<t.length; a++) {
			switch(t[a]) {
			case 0 :
				img = new ImageView(images.get(0));
				break;
			case 1 :
				img = new ImageView(images.get(1));
				break;
			case 2 :
				img = new ImageView(images.get(2));
				break;
			case 3 :
				img = new ImageView(images.get(3));
				break;
			case 4 :
				img = new ImageView(images.get(4));
				break;
			}
			carte.getChildren().add(img);
		}
		return t;
	}
	
	
}
