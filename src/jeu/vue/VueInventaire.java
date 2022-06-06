package jeu.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import jeu.modele.Joueur;
import jeu.modele.inventaire.objet.ObjetInventaire;
//import jeu.modele.objet.Bandage;



public class VueInventaire {
	
	
	private Image[] tabImage= {new Image("jeu/modele/image/epeebois.png"),new Image("jeu/modele/image/epeePierre.png"),new Image("jeu/modele/image/epeeMetal.png"),
			new Image("jeu/modele/image/hacheBois.png"),new Image("jeu/modele/image/hachePierre.png"),new Image("jeu/modele/image/hacheMetal.png"),new Image("jeu/modele/image/piocheBois.png"),new Image("jeu/modele/image/piochePierre.png"),new Image("jeu/modele/image/piocheMetal.png"),new Image("jeu/modele/image/bandage.png"),new Image("jeu/modele/image/kitDeSoin.png"),new Image("jeu/modele/image/carrerVide.png"),};
	
	
	private Joueur joueur;
	private HBox	boxInv;
	private Label labelBois,labelPierre,labelMetal;
	private ImageView case1,case2,case3,case4,case5,case6;
	public VueInventaire(Joueur joueur,HBox boxInv,Label labelBois,Label labelPierre,Label labelMetal,ImageView case1,ImageView case2,ImageView case3,ImageView case4,ImageView case5,ImageView case6) {
		this.joueur=joueur;
		this.boxInv=boxInv;
		this.labelBois=labelBois;
		this.labelPierre=labelPierre;
		this.labelMetal=labelMetal;
		this.case1=case1;
		this.case2=case2;
		this.case3=case3;
		this.case4=case4;
		this.case5=case5;
		this.case6=case6;
		afficherInventaireObjet();
	}
	
	public void afficherInventaireObjet() {
		joueur.getInventaireResource().get(0).getResource().addListener((obse,old,nouv)-> this.labelBois.setText(nouv.toString()));
		joueur.getInventaireResource().get(1).getResource().addListener((obse,old,nouv)-> this.labelPierre.setText(nouv.toString()));
		joueur.getInventaireResource().get(2).getResource().addListener((obse,old,nouv)-> this.labelMetal.setText(nouv.toString()));
		
		for (int i = 0; i < joueur.getInventaireObjet().getInventaire().size(); i++) {
			int a=i;
			joueur.getInventaireObjet().getInventaire().get(i).getNumObjetCase().addListener((obse,old,nouv)-> System.out.println("�a change"));
			System.out.println("test");
		}		
		
			
	}
	
	public void actualiser(IntegerProperty obj) {
		System.out.println("je suis appeler");
		
			switch (obj.getValue()) {
			case 0:
				case1.setImage(tabImage[0]);
				
				break;
			case 1:
				case1.setImage(tabImage[1]);
				
				break;
			case 2:
				case1.setImage(tabImage[2]);
				
				break;
			case 3:
				case1.setImage(tabImage[3]);
				
				break;
			case 4:
				case1.setImage(tabImage[4]);
				
				break;
			case 5:
				case1.setImage(tabImage[5]);
				
				break;
			case 6:
				case1.setImage(tabImage[6]);
				
				break;
			case 7:
				case1.setImage(tabImage[7]);
				
				break;
			case 8:
				case1.setImage(tabImage[8]);
				
				break;
			case 9:
				case5.setImage(tabImage[9]);
				break;
			
				
				
			case 11:
				
				case5.setImage(tabImage[11]);
				break;
				
			case 10:
				case5.setImage(tabImage[10]);
				break;	

			default:
				break;
			}
			
		}
	
	
	
}
