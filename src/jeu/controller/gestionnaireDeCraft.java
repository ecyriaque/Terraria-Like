package jeu.controller;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import jeu.modele.Joueur;

public class gestionnaireDeCraft {

	private ImageView ImageCraftEpeeBois,ImageCraftEpeePierre,ImageCraftEpeeMetal,ImageCraftHacheBois,ImageCraftHachePierre,ImageCraftHacheMetal,ImageCraftPiocheBois,ImageCraftPiochePierre,
	ImageCraftPiocheMetal,ImageCraftKitDeSoin,ImageCraftBandage, ImageCraftPistolet, ImageCraftBouclier;
	private Joueur joueur;
	private Text textCraft;

	public gestionnaireDeCraft(Joueur joueur,Text textCraft,ImageView imageCraftEpeeBois, ImageView imageCraftEpeePierre,ImageView imageCraftEpeeMetal, ImageView imageCraftHacheBois, ImageView imageCraftHachePierre,ImageView imageCraftHacheMetal, ImageView imageCraftPiocheBois, ImageView imageCraftPiochePierre,ImageView imageCraftPiocheMetal, ImageView imageCraftKitDeSoin, ImageView imageCraftBandage, ImageView imageCraftPistolet, ImageView ImageCrafBouclier) {
		this.joueur=joueur;
		this.textCraft=textCraft;
		this.ImageCraftEpeeBois = imageCraftEpeeBois;
		this.ImageCraftEpeePierre = imageCraftEpeePierre;
		this.ImageCraftEpeeMetal = imageCraftEpeeMetal;
		this.ImageCraftHacheBois = imageCraftHacheBois;
		this.ImageCraftHachePierre = imageCraftHachePierre;
		this.ImageCraftHacheMetal = imageCraftHacheMetal;
		this.ImageCraftPiocheBois = imageCraftPiocheBois;
		this.ImageCraftPiochePierre = imageCraftPiochePierre;
		this.ImageCraftPiocheMetal = imageCraftPiocheMetal;
		this.ImageCraftKitDeSoin = imageCraftKitDeSoin;
		this.ImageCraftBandage = imageCraftBandage;
		this.ImageCraftPistolet = imageCraftPistolet; 
		this.ImageCraftBouclier = ImageCrafBouclier;
		crafter();
	}
	
	public void crafter( ) {
		//Epee
		ImageCraftEpeeBois.setOnMouseClicked(arg0 -> joueur.crafterEpeeBois());
		ImageCraftEpeeBois.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftEpeeBois));
		ImageCraftEpeeBois.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		ImageCraftEpeePierre.setOnMouseClicked(arg0 -> joueur.crafterEpeePierre());
		ImageCraftEpeePierre.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftEpeePierre));
		ImageCraftEpeePierre.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		ImageCraftEpeeMetal.setOnMouseClicked(arg0 -> joueur.crafterEpeeMetal());
		ImageCraftEpeeMetal.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftEpeeMetal));
		ImageCraftEpeeMetal.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		//Hache
		ImageCraftHacheBois.setOnMouseClicked(arg0 -> joueur.crafterHacheBois());
		ImageCraftHacheBois.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftHacheBois));
		ImageCraftHacheBois.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		ImageCraftHachePierre.setOnMouseClicked(arg0 -> joueur.crafterHachePierre());
		ImageCraftHachePierre.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftHachePierre));
		ImageCraftHachePierre.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		ImageCraftHacheMetal.setOnMouseClicked(arg0 -> joueur.crafterHacheMetal());
		ImageCraftHacheMetal.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftHacheMetal));
		ImageCraftHacheMetal.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		//Pioche
		ImageCraftPiocheBois.setOnMouseClicked(arg0 -> joueur.crafterPiocheBois());
		ImageCraftPiocheBois.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftPiocheBois));
		ImageCraftPiocheBois.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		ImageCraftPiochePierre.setOnMouseClicked(arg0 -> joueur.crafterPiochePierre());
		ImageCraftPiochePierre.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftPiochePierre));
		ImageCraftPiochePierre.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		ImageCraftPiocheMetal.setOnMouseClicked(arg0 -> joueur.crafterPiocheMetal());
		ImageCraftPiocheMetal.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftPiocheMetal));
		ImageCraftPiocheMetal.setOnMouseExited(arg0 -> textCraft.setVisible(false));
	
		//Kit de soin
		ImageCraftKitDeSoin.setOnMouseClicked(arg0 -> joueur.crafterKitDeSoin());
		ImageCraftKitDeSoin.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftKitDeSoin));
		ImageCraftKitDeSoin.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		//Bandage
		ImageCraftBandage.setOnMouseClicked(arg0 -> joueur.crafterBandage());
		ImageCraftBandage.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftBandage));
		ImageCraftBandage.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		//Pistolet
		ImageCraftPistolet.setOnMouseClicked(arg0 -> joueur.crafterPistolet());
		ImageCraftPistolet.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftPistolet));
		ImageCraftPistolet.setOnMouseExited(arg0 -> textCraft.setVisible(false));
		
		//Bouclier
		ImageCraftBouclier.setOnMouseClicked(arg0 -> joueur.crafterBouclier());
		ImageCraftBouclier.setOnMouseEntered(arg0 -> textPourCraft(ImageCraftBouclier));
		ImageCraftBouclier.setOnMouseExited(arg0 -> textCraft.setVisible(false));
	}
	
	public void textPourCraft(ImageView img) {
		//Epee
		if (img==ImageCraftEpeeBois) {
			textCraft.setText("3 BOIS");
		}else if (img==ImageCraftEpeePierre) {
			textCraft.setText("3 PIERRES");
		}else if (img==ImageCraftEpeeMetal) {
			textCraft.setText("3 METALS");
		//Hache
		}else if (img==ImageCraftHacheBois) {
			textCraft.setText("3 BOIS");
		}else if (img==ImageCraftHachePierre) {
			textCraft.setText("3 PIERRES");
		}else if (img==ImageCraftHacheMetal) {
			textCraft.setText("3 METALS");
		//Pioche
		}else if (img==ImageCraftPiocheBois) {
			textCraft.setText("3 BOIS");
		}else if (img==ImageCraftPiochePierre) {
			textCraft.setText("3 PIERRES");
		}else if (img==ImageCraftPiocheMetal) {
			textCraft.setText("3 METALS");
		//Bandage
		}else if (img==ImageCraftBandage) {
			textCraft.setText("3 BOIS");
		//Kit de soin
		}else if (img==ImageCraftKitDeSoin) {
			textCraft.setText("6 BOIS");
		//Pistolet
		}else if (img==ImageCraftPistolet) {
			textCraft.setText("10 METALS");
		//Bouclier
		}else if (img==ImageCraftBouclier) {
			textCraft.setText("3 METALS");
		}
		textCraft.setVisible(true);
	}
}
