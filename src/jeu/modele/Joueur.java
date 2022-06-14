package jeu.modele;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.modele.inventaire.Inventaire;
import jeu.modele.inventaire.objet.ObjetInventaire;
import jeu.modele.inventaire.objet.ObjetVide;
import jeu.modele.inventaire.objet.caseInventaire;
import jeu.modele.inventaire.objet.arme.*;
import jeu.modele.inventaire.objet.objetSoin.*;
import jeu.modele.resource.*;


public class Joueur extends Personnage{
	//variables//
	private IntegerProperty x,y; //position du joueur
	private IntegerProperty nbCoeursProperty; // nombre de coeur du perso (0 a 5)
	private int nbSaut; //nb saut 
	private int vitesse; //vitesse de deplacement du perso
	private boolean droite,gauche,saute; //vraie si il se deplace ou saute
	
	private Inventaire inventaireObjet =new Inventaire();

	private IntegerProperty nbBandageProperty, nbKitdeSoinProperty; //nombre de bandage et de kit de soin
	private IntegerProperty nbBouclierProperty; // nombre bouclier du perso (0 a 3)
	private IntegerProperty ObjetEquiperProperty;
	private int matChoisi;
	private int caseChoisi;
	protected Environnement env;
	private boolean direction; //true:droite     false:gauche
	private int xtile;
	private int ytile;	
	
	//CONSTRUCTEUR//
	public Joueur(Environnement env) {
		this.env=env;
		this.nbCoeursProperty=new SimpleIntegerProperty(5);
		this.nbBouclierProperty = new SimpleIntegerProperty(0);
		this.x = new SimpleIntegerProperty(40);
		this.y = new SimpleIntegerProperty(360);
		this.vitesse = 8;
		this.nbBandageProperty=new SimpleIntegerProperty(0);
		this.nbKitdeSoinProperty=new SimpleIntegerProperty(0);

		caseInventaire case1= new caseInventaire(new ObjetVide(),1);
		caseInventaire case2=new caseInventaire(new ObjetVide(),2);
		caseInventaire case3=new caseInventaire(new ObjetVide(),3);
		caseInventaire case4=new caseInventaire(new ObjetVide(),4);
		caseInventaire case5=new caseInventaire(new ObjetVide(),5);
		caseInventaire case6=new caseInventaire(new ObjetVide(),6);

		inventaireObjet.ajouterDansLinventaire(case1);
		inventaireObjet.ajouterDansLinventaire(case2);
		inventaireObjet.ajouterDansLinventaire(case3);
		inventaireObjet.ajouterDansLinventaire(case4);
		inventaireObjet.ajouterDansLinventaire(case5);
		inventaireObjet.ajouterDansLinventaire(case6);
		
		this.nbSaut = 0;
		this.matChoisi = 0;
	}

	//CONSTRUCION
	public int constructionDroitePlacer() {
		this.xtile = ((this.getX()+79)/40);
		this.ytile = ((this.getY()+20)/40);
		return (xtile+(ytile*20));
	}
	public int constructionGauchePlacer() {
		this.xtile = ((this.getX()-40)/40);
		this.ytile = ((this.getY()+20)/40);
		return(xtile+(ytile*20));
	}
	public int constructionDroiteCasser() {
		this.xtile = ((this.getX()+40)/40);
		this.ytile = ((this.getY()+20)/40);
		return (xtile+(ytile*20));
	}
	public int constructionGaucheCasser() {
		this.xtile = ((this.getX()-1)/40);
		this.ytile = ((this.getY()+20)/40);
		return (xtile+(ytile*20));
	}

	/////////////Methodes de gestion des PV ///////////////
	@Override
	public void perdrePv() {
		int nbCoeur =this.getNbCoeurs()-1;
		if(getNbCoeurs()>=1) 
			this.nbCoeursProperty.setValue(nbCoeur);
	}
	public void gagnerPv() {
		int nbCoeur =this.getNbCoeurs()+1;
		if(getNbCoeurs()<5)
			this.nbCoeursProperty.setValue(nbCoeur);
	}
	
	/////////////Methodes de gestion de Bouclier ///////////////
	public void perdreBouclier() {
		int nbBouclier = this.getNbBouclier()-1;
		if(getNbBouclier()>=1) 
			this.nbBouclierProperty.setValue(nbBouclier);
	}

	public void gagnerBouclier() {
		int nbBouclier = this.getNbBouclier()+1;
		if(getNbBouclier()<3) 
			this.nbBouclierProperty.setValue(nbBouclier);
	}
	
	public void blesser() {
		if(getNbBouclier()>0)
			perdreBouclier();
		else
			perdrePv();
	}
	
	///////////// Les integersProperty /////////////
	public final IntegerProperty xProperty(){
		return this.x;
	}
	public final IntegerProperty yProperty(){
		return this.y;
	}
	public final IntegerProperty nbCoeurProperty() {
		return this.nbCoeursProperty;
	}
	public final IntegerProperty getNbBouclierProperty() {
		return this.nbBouclierProperty;
	}

	///////// Les methodes de deplacement //////////
	@Override
	public void allerAGauche() {
		int npos = getX()-vitesse;
		if(npos > -5)
			this.x.setValue(npos);
	}
	@Override
	public void allerADroite() {
		int npos = getX()+vitesse;
		if (npos < 766)
			this.x.setValue(npos);
	}
	@Override
	public void sauter() {
		int npos = getY()-10;
		if(npos >0 )
			if(nbSaut<6) {
				this.y.setValue(npos);
				nbSaut++;
			}
	}
	@Override
	public void tomber() {
		int npos = getY()+10;
		this.y.setValue(npos);
	}


	//////////////METHODES CRAFT//////////////////
	
//	0 epeeBois
//	1 epeePierre
//	2 epeeMetal
//	3 hacheBois
//	4 hachePierre
//	5 hacheMetal
//	6 piocheBois
//	7 piochePierre
//	8 piocheMetal
//	9 bandage
//	10 kitDeSoin
//	11 pistolet
	
	//EPEE
	public void crafterEpeeBois() {
		if (env.getNbResource("bois")<3 ) 
			System.out.println("pas assez de bois il vous en manque ");
		else if(this.objetDejaPosseder(0, 0)) 
			System.out.println("deja poseder");
		else if(this.objetDejaPosseder(0, 1)|| this.objetDejaPosseder(0, 2))
			System.out.println("Vous posseder une meilleur epee");
		else if(env.getNbResource("bois")>=3) {
			this.setObjet(0, new EpeeBois());
			env.EnleverResource("bois",3);
		}
	}
	public void crafterEpeePierre() {
		if (env.getNbResource("pierre")<3) 
			System.out.println("pas assez de pierre il vous en manque ");
		else if(this.objetDejaPosseder(0, 1)) 
			System.out.println("deja poseder");	
		else if(this.objetDejaPosseder(0, 2))
			System.out.println("Vous posseder une meilleur epee");
		else if(env.getNbResource("pierre")>=3) {
			this.setObjet(0, new EpeePierre());
			env.EnleverResource("pierre",3);
		}
	}
	public void crafterEpeeMetal() {
		if (env.getNbResource("metal")<3) 
			System.out.println("pas assez de metal il vous en manque ");
		else if(this.objetDejaPosseder(0, 2))
			System.out.println("vous avez deja une epee en metal");
		else if(env.getNbResource("metal")>=3) {
			this.setObjet(0, new EpeeMetal());
			env.EnleverResource("metal",3);
		}
	}
	//HACHE
	public void crafterHacheBois() {
		if (env.getNbResource("bois")<3) 
			System.out.println("pas assez de bois il vous en manque ");
		else if(this.objetDejaPosseder(1, 3)) 
			System.out.println("vous avez deja une hache en bois");
		else if(this.objetDejaPosseder(1, 5) || this.objetDejaPosseder(1, 4))
			System.out.println("Vous posseder une meilleur hache");
		else if(env.getNbResource("bois")>=3) {
			this.setObjet(1, new HacheBois());
			env.EnleverResource("bois",3);
		}
	}
	public void crafterHachePierre() {
		if (env.getNbResource("pierre")<3) 
			System.out.println("pas assez de pierre il vous en manque ");
		else if(this.objetDejaPosseder(1, 4)) 
			System.out.println("vous avez deja une hache en pierre");
		else if(this.objetDejaPosseder(1, 5))
			System.out.println("Vous posseder une meilleur hache");
		else if(env.getNbResource("pierre")>=3) {
			this.setObjet(1, new HachePierre());
			env.EnleverResource("pierre",3);
		}
	}
	public void crafterHacheMetal() {
		if (env.getNbResource("metal")<3) 
			System.out.println("pas assez de metal il vous en manque ");
		else if(this.objetDejaPosseder(1, 5))
			System.out.println("vous avez deja une hache en metal");
		else if(env.getNbResource("metal")>=3) {
			this.setObjet(1, new HacheMetal());
			env.EnleverResource("metal", 3);
		}
	}
	//PIOCHE
	public void crafterPiocheBois() {
		if (env.getNbResource("bois")<3) 
			System.out.println("pas assez de bois il vous en manque ");
		else if(this.objetDejaPosseder(2, 6)) 
			System.out.println("vous avez deja une pioche en bois");
		else if(this.objetDejaPosseder(2, 7) || this.objetDejaPosseder(2, 8))
			System.out.println("Vous posseder une meilleur pioche");
		else if(env.getNbResource("bois")>=3) {
			this.setObjet(2, new PiocheBois());
			env.EnleverResource("bois",3);
		}
	}
	public void crafterPiochePierre() {
		if (env.getNbResource("pierre")<3 && this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()!=7) 
			System.out.println("pas assez de Pierre il vous en manque ");
		else if(this.objetDejaPosseder(2, 7)) 
			System.out.println("vous avez deja une pioche en pierre");
		else if(this.objetDejaPosseder(2, 8))
			System.out.println("Vous posseder une meilleur pioche");
		else if(env.getNbResource("pierre")>=3) {
			this.setObjet(2, new PiochePierre());
			env.EnleverResource("pierre",3);
		}
	}
	public void crafterPiocheMetal() {
		if (env.getNbResource("metal")<3) 
			System.out.println("pas assez de metal il vous en manque "+(3-env.getNbResource("metal")));
		else if(this.objetDejaPosseder(2, 8) )
			System.out.println("vous avez deja une pioche en metal");
		else if(env.getNbResource("metal")>=3) {
			this.setObjet(2, new PiocheMetal());
			env.EnleverResource("metal",3);
		}
	}
	//BANDAGES
	public void crafterBandage() {
		if (env.getNbResource("bois")<3) 
			System.out.println("pas assez de bois");
		else if(this.objetDejaPosseder(4, 9) && env.getNbResource("bois")>=3) {
			ajtNbBandage();	
		}
		else if(env.getNbResource("bois")>=3) {
			this.setObjet(4, new Bandage());
			ajtNbBandage();
		}
	}
	//KITS DE SOINS
	public void crafterKitDeSoin() {
		if (env.getNbResource("bois")<6) 
			System.out.println("pas assez de bois");
		else if(this.objetDejaPosseder(5, 10) && env.getNbResource("bois")>=6) {
			ajtNbKitdeSoin();
		}
		else if(env.getNbResource("bois")>=6 ) {
			this.setObjet(5, new KitDeSoin());
			ajtNbKitdeSoin();
		}
	}
	//PISTOLET
	public void crafterPistolet() {
		if(env.getNbResource("metal")< 10)
			System.out.println("pas assez de metal");
		else if(this.objetDejaPosseder(3, 11))
			System.out.println("vous avez deja un pistolet");
		else if(env.getNbResource("metal")>=10) {
			this.setObjet(3, new Pistolet());
			env.EnleverResource("metal",10);
		}
	}
	//BOUCLIER
	public void crafterBouclier() {
		if (env.getNbResource("metal") < 3) 
			System.out.println("pas assez de metal");
		else if(nbBouclierProperty.getValue() == 3) 
			System.out.println("Vous avez deja le maximum de bouclier");
		else if(env.getNbResource("metal")>=3) {	
			env.EnleverResource("metal",3);
			this.gagnerBouclier();
			System.out.println(nbBouclierProperty.getValue());
		}
	}
	
	
	////////Methodes ajout/supp soin////////
	public void ajtNbKitdeSoin() {
		int nbKDS = this.nbKitdeSoinProperty.getValue();
		if(nbKDS < 2) {
			this.nbKitdeSoinProperty.setValue(nbKitdeSoinProperty.getValue()+1);
			env.EnleverResource("bois",6);
		}
	}
	
	public void ajtNbBandage() {
		int nbBandages = nbBandageProperty.getValue()+1;
		if(nbBandages<6) {
			this.nbBandageProperty.setValue(nbBandages);
			env.EnleverResource("bois",3);
		}
	}
	public void mettreAzero() {
		this.nbBandageProperty.setValue(0);
		this.nbKitdeSoinProperty.setValue(0);
	}
	
	
	///////// Les setters /////////////
	public final void setY(int n){
		y.setValue(n);
	}
	public final void setX(int n){
		x.setValue(n);
	}
	public final void setNbCoeurs(int nb) {
		nbCoeursProperty.setValue(nb);
	}
	public void setNbSaut(int nbSaut) {
		this.nbSaut = nbSaut;
	}
	public void setNbBouclierProperty(IntegerProperty nbBouclierProperty) {
		this.nbBouclierProperty = nbBouclierProperty;
	}
	public void setDroite(boolean droite) {
		this.droite = droite;
	}
	public void setSaute(boolean saute) {
		this.saute = saute;
	}
	public void setMatChoisi(int mat) {
		matChoisi = mat;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	/////// Les Getters //////////////
	public final int getNbCoeurs() {
		return this.nbCoeursProperty.getValue();
	}
	public final int getNbBouclier() {
		return this.nbBouclierProperty.getValue();
	}
	@Override
	public final int getX() {
		return x.getValue();
	}
	@Override
	public final int getY() {
		return y.getValue();
	}
	public int getNbSaut() {
		return nbSaut;
	}
	public boolean getDroite() {
		return droite;
	}
	public boolean getGauche() {
		return gauche;
	}
	public void setGauche(boolean gauche) {
		this.gauche = gauche;
	}
	public boolean getSaute() {
		return saute;
	}
	public IntegerProperty getNbKitdeSoinProperty() {
		return nbKitdeSoinProperty;
	}
	public IntegerProperty getNbBandageProperty() {
		return nbBandageProperty;
	}
	public Inventaire getInventaireObjet() {
		return this.inventaireObjet;
	}
	public void setObjet(int numCase, ObjetInventaire objet) {
		this.inventaireObjet.getInventaire().get(numCase).setObjetDeLaCase(objet);
	}
	public int getMatChoisi() {
		return matChoisi;
	}
	public boolean getDirection() {
		return direction;
	}
	public Environnement getEnv() {
		return this.env;
	}
	public boolean objetDejaPosseder(int caseI , int numObjet ) {
		return this.inventaireObjet.getInventaire().get(caseI).getNumObjetCase().getValue() == numObjet;
	}
}
