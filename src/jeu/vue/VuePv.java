
package jeu.vue;

import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import jeu.modele.Joueur;

public class VuePv {
	
	
	private Image[] tabImage= {new Image("jeu/modele/image/perdue.png"),new Image("jeu/modele/image/1hearts.png"),new Image("jeu/modele/image/2hearts.png"),
			new Image("jeu/modele/image/3hearts.png"),new Image("jeu/modele/image/4hearts.png"),new Image("jeu/modele/image/hearts.png"),};
	
	private ImageView imageActive;
	private Joueur joueur;
	
	public VuePv(Joueur j,Pane root) {
		this.joueur=j;
		this.imageActive=new ImageView(tabImage[5]);
		this.imageActive.setTranslateY(-100);
		root.getChildren().add(imageActive);
		
	}
	
	public IntegerProperty getCoeurs() {
		return this.joueur.nbCoeurProperty();
	}
	
	public Image[] getTabImage(){
	 return this.tabImage;
	}
	
	public void setImageActive(Image image) {
		imageActive.setImage(image);
	}
}
	
 

	

	


