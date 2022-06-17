package jeu.controller;

import java.util.ArrayList;

import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import jeu.modele.Ennemi;

public class MonObservateurEnnemie implements ListChangeListener<Ennemi>{

	private Pane conteneur;
	private ArrayList<Image> images;
	public MonObservateurEnnemie(Pane conteneur ) {
		super();
		this.conteneur=conteneur;
		
		this.images = new ArrayList<>();
		images.add(new Image("jeu/modele/image/personnage/ennemi/ennemiNeutre.png"));
		images.add(new Image("jeu/modele/image/personnage/ennemi/ennemiDroite.png"));
		images.add(new Image("jeu/modele/image/personnage/ennemi/ennemiGauche.png"));
		images.add(new Image("jeu/modele/image/personnage/ennemi/ennemiSaut.png"));
		}
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends Ennemi> c) {
			System.out.println("ça change");
			
			while(c.next()){
				// on ajoute les nouveau ennemie
				for(Ennemi nouveau: c.getAddedSubList()){
					ImageView r = new ImageView(images.get(0));
						r.setOnMouseClicked(e-> System.out.println("clic sur acteur"+ e.getSource()));		
						r.setId(nouveau.getId());
						r.translateXProperty().bind(nouveau.getXProperty());
						r.translateYProperty().bind(nouveau.getYProperty());
						
						conteneur.getChildren().add(r);	
					
					 	
				}
				// on enleve les ennemis mort
				for(Ennemi mort: c.getRemoved()){
					if(mort.getPv()==0)
						enleverSprite(mort);
				}
			}

		}
		



	private void enleverSprite(Ennemi mort) {
		
		this.conteneur.getChildren().remove(this.conteneur.lookup("#"+mort.getId()));

	}

		
}
