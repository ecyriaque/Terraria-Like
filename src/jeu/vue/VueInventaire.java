package jeu.vue;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import jeu.modele.Environnement;
import jeu.modele.Joueur;

public class VueInventaire {
		
	//VARIABLES
	private Image[] tabImage  = {new Image("jeu/modele/image/utilitaires/epeeBois.png"),new Image("jeu/modele/image/utilitaires/epeePierre.png"),
			new Image("jeu/modele/image/utilitaires/epeeMetal.png"),new Image("jeu/modele/image/utilitaires/hacheBois.png"),
			new Image("jeu/modele/image/utilitaires/hachePierre.png"),new Image("jeu/modele/image/utilitaires/hacheMetal.png"),
			new Image("jeu/modele/image/utilitaires/piocheBois.png"),new Image("jeu/modele/image/utilitaires/piochePierre.png"),
			new Image("jeu/modele/image/utilitaires/piocheMetal.png"),new Image("jeu/modele/image/utilitaires/bandage.png"),
			new Image("jeu/modele/image/utilitaires/kitDeSoin.png"),new Image("jeu/modele/image/utilitaires/pistolet.png"),
			new Image("jeu/modele/image/utilitaires/vide.png"),new Image("jeu/modele/image/utilitaires/bois.png"),
			new Image("jeu/modele/image/utilitaires/pierre.png"),new Image("jeu/modele/image/utilitaires/metal.png")};	
	
	private Joueur joueur;
	private Environnement env;
	private Label labelBois,labelPierre,labelMetal,labelNbDeBandage,labelNbDeKitDeSoin;
	private ArrayList<ImageView> imagesCase;
	private ImageView imgObjetDansLesMains;
	
	//CONSTRUCTEUR
	public VueInventaire(Environnement env,HBox boxInv,Label labelNbDeBandage,Label labelNbDeKitDeSoin,Label labelBois,Label labelPierre,Label labelMetal,
			ArrayList<ImageView> imgC,ImageView imgObjetDansLesMains) {
		this.env=env;
		this.joueur=env.getJoueur();
		this.labelBois=labelBois;
		this.labelPierre=labelPierre;
		this.labelMetal=labelMetal;
		this.labelNbDeBandage=labelNbDeBandage;
		this.labelNbDeKitDeSoin=labelNbDeKitDeSoin;
		this.imagesCase = imgC;
		afficherInventaireObjet();
		this.imgObjetDansLesMains=imgObjetDansLesMains;
		this.imgObjetDansLesMains.translateXProperty().bind(joueur.xProperty().add(40));
		this.imgObjetDansLesMains.translateYProperty().bind(joueur.yProperty());
		
	}
	
	public void afficherInventaireObjet() {
		this.env.getNbResourceProperty("bois").addListener((obse,old,nouv)-> this.labelBois.setText(nouv.toString()));
		this.env.getNbResourceProperty("pierre").addListener((obse,old,nouv)-> this.labelPierre.setText(nouv.toString()));
		this.env.getNbResourceProperty("metal").addListener((obse,old,nouv)-> this.labelMetal.setText(nouv.toString()));		
		
		this.joueur.getNbBandageProperty().addListener((obse,old,nouv)-> this.labelNbDeBandage.setText(nouv.toString()));
		this.joueur.getNbKitdeSoinProperty().addListener((obse,old,nouv)-> this.labelNbDeKitDeSoin.setText(nouv.toString()));
		//listenner qui sert a changer l'objet équiper par le joueur
		this.joueur.getObjetEquiperProperty().addListener((obse,old,nouv)-> equiperObjetDansLesMains(nouv.intValue()));	
		
		for (int i = 0; i < joueur.getInventaireObjet().getInventaire().size(); i++) {	
			joueur.getInventaireObjet().getInventaire().get(i).getNumObjetCase().addListener((obse,old,nouv)-> actualiser(nouv));
		}				
	}
		
	public void actualiser(Number nouv) {	
			switch (nouv.intValue()) {
			case 0:
				imagesCase.get(0).setImage(tabImage[0]);			
				break;
			case 1:
				imagesCase.get(0).setImage(tabImage[1]);		
				break;
			case 2:
				imagesCase.get(0).setImage(tabImage[2]);		
				break;
			case 3:
				imagesCase.get(1).setImage(tabImage[3]);				
				break;
			case 4:
				imagesCase.get(1).setImage(tabImage[4]);				
				break;
			case 5:
				imagesCase.get(1).setImage(tabImage[5]);				
				break;
			case 6:
				imagesCase.get(2).setImage(tabImage[6]);				
				break;
			case 7:
				imagesCase.get(2).setImage(tabImage[7]);				
				break;
			case 8:
				imagesCase.get(2).setImage(tabImage[8]);			
				break;
			case 9:
				imagesCase.get(4).setImage(tabImage[9]);
				break;				
			case 10:
				imagesCase.get(5).setImage(tabImage[10]);
				break;
			case 11 : 
				imagesCase.get(3).setImage(tabImage[11]);
				break;
			default:
				for(int i=0 ; i<6 ; i++)
					imagesCase.get(i).setImage(tabImage[tabImage.length-1]);
				break;
			}
			System.out.println(joueur.getInventaireObjet().getInventaire().toString());
		}	
	
	public void equiperObjetDansLesMains(int i) {
		System.out.println("Objet équiper :"+i );
		imgObjetDansLesMains.setImage(tabImage[i]);
	}
}
