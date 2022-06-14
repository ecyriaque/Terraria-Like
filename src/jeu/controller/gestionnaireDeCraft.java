package jeu.controller;

import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import jeu.modele.Joueur;

public class gestionnaireDeCraft {

	private ArrayList<ImageView> imagesView; 
	private Joueur joueur;
	private Text textCraft;

	public gestionnaireDeCraft(Joueur joueur,Text textCraft, ArrayList<ImageView> images) {
		this.joueur=joueur;
		this.textCraft=textCraft;
		this.imagesView = images;
		crafter();
	}
	
	public void crafter( ) {
		//Epee
		imagesView.get(0).setOnMouseClicked(arg0 -> joueur.crafterEpeeBois());
		imagesView.get(0).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(0)));		
		imagesView.get(1).setOnMouseClicked(arg0 -> joueur.crafterEpeePierre());
		imagesView.get(1).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(1)));		
		imagesView.get(2).setOnMouseClicked(arg0 -> joueur.crafterEpeeMetal());
		imagesView.get(2).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(2)));
		
		//Hache
		imagesView.get(3).setOnMouseClicked(arg0 -> joueur.crafterHacheBois());
		imagesView.get(3).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(3)));		
		imagesView.get(4).setOnMouseClicked(arg0 -> joueur.crafterHachePierre());
		imagesView.get(4).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(4)));		
		imagesView.get(5).setOnMouseClicked(arg0 -> joueur.crafterHacheMetal());
		imagesView.get(5).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(5)));
		
		//Pioche
		imagesView.get(6).setOnMouseClicked(arg0 -> joueur.crafterPiocheBois());
		imagesView.get(6).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(6)));	
		imagesView.get(7).setOnMouseClicked(arg0 -> joueur.crafterPiochePierre());
		imagesView.get(7).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(7)));		
		imagesView.get(8).setOnMouseClicked(arg0 -> joueur.crafterPiocheMetal());
		imagesView.get(8).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(8)));
	
		//Kit de soin
		imagesView.get(9).setOnMouseClicked(arg0 -> joueur.crafterKitDeSoin());
		imagesView.get(9).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(9)));
		
		//Bandage
		imagesView.get(10).setOnMouseClicked(arg0 -> joueur.crafterBandage());
		imagesView.get(10).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(10)));
		
		//Pistolet
		imagesView.get(11).setOnMouseClicked(arg0 -> joueur.crafterPistolet());
		imagesView.get(11).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(11)));
		
		//Bouclier
		imagesView.get(12).setOnMouseClicked(arg0 -> joueur.crafterBouclier());
		imagesView.get(12).setOnMouseEntered(arg0 -> textPourCraft(imagesView.get(12)));
		
		for(int i=0 ; i<=12 ; i++)
			imagesView.get(i).setOnMouseExited(arg0 -> textCraft.setVisible(false));
	}
	
	public void textPourCraft(ImageView img) {
		if (img==imagesView.get(0) || img==imagesView.get(3) || img==imagesView.get(6) || img==imagesView.get(10)) 
			textCraft.setText("3 BOIS");	
		else if (img==imagesView.get(1) || img==imagesView.get(4) || img==imagesView.get(7) ) 
			textCraft.setText("3 PIERRES");			
		else if (img==imagesView.get(2) || img==imagesView.get(5) || img==imagesView.get(8) || img==imagesView.get(12)) 
			textCraft.setText("3 METALS");
		else if (img==imagesView.get(9)) 
			textCraft.setText("6 BOIS");
		else if (img==imagesView.get(11)) 
			textCraft.setText("10 METALS");
		textCraft.setVisible(true);
	}
}
