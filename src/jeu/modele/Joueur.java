package jeu.modele;

import java.util.ArrayList;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.modele.inventaire.Inventaire;
import jeu.modele.inventaire.objet.ObjetVide;
import jeu.modele.inventaire.objet.caseInventaire;
import jeu.modele.inventaire.objet.arme.*;
import jeu.modele.inventaire.objet.objetSoin.*;
import jeu.modele.resource.Bois;
import jeu.modele.resource.Metal;
import jeu.modele.resource.Pierre;
import jeu.modele.resource.Resource;


public class Joueur {
	//variables//
	private int xx,yy;
	private IntegerProperty x,y; //position du joueur
	private IntegerProperty nbCoeursProperty; // nombre de coeur du perso (0 a 5)
	protected Map map; //map
	private int nbSaut=0; //nb saut 
	private int vitesse; //vitesse de deplacement du perso
	private boolean droite,gauche,saute; //vraie si il se deplace ou saute
	private ArrayList<Resource> inventaireResource; 
	private Inventaire inventaireObjet =new Inventaire();
	private Resource bois= new Bois();
	private Resource metal= new Metal();
	private Resource pierre=new Pierre();
	private IntegerProperty nbBandageProperty,nbKitdeSoinProperty; //nombre de bandage et de kit de soin
	private IntegerProperty nbBouclierProperty; // nombre bouclier du perso (0 a 3)

	
	//CONSTRUCTEUR//
	public Joueur() {
		this.xx = 40;
		this.yy =360;
		this.nbCoeursProperty=new SimpleIntegerProperty(5);
		this.nbBouclierProperty = new SimpleIntegerProperty(0);
		this.x = new SimpleIntegerProperty(xx);
		this.y = new SimpleIntegerProperty(yy);
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
		inventaireResource=new ArrayList<>();
		inventaireResource.add(bois);
		inventaireResource.add(pierre);
		inventaireResource.add(metal);
	}

	/////////////Methodes de gestion des PV ///////////////
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
	public void allerAGauche() {
		int npos = getX()-vitesse;
		if(npos > -5)
			this.x.setValue(npos);
	}
	public void allerADroite() {
		int npos = getX()+vitesse;
		if (npos < 766)
			this.x.setValue(npos);
	}
	public void sauter() {
		int npos = getY()-10;
		if(npos >0 )
			if(nbSaut<6) {
				this.y.setValue(npos);
				nbSaut++;
			}
	}
	public void tomber() {
		int npos = getY()+10;
		this.y.setValue(npos);
	}


	//////////////METHODES CRAFT//////////////////
	
	//EPEE
	public void crafterEpeeBois() {
		if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==0) 
			System.out.println("pas assez de bois il vous en manque "+(3-inventaireResource.get(0).getResource().getValue()));
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==0) {
			System.out.println("deja poseder");
		}
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==1 || this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==2){
			System.out.println("Vous posseder une meilleur epee");
		}
		else if(inventaireResource.get(0).getResource().getValue()>=3) {
			System.out.println(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase());
			this.getInventaireObjet().getInventaire().get(0).setObjetDeLaCase(new EpeeBois());
			inventaireResource.get(0).EnleverResource();

		}
	}

	public void crafterEpeePierre() {
		if (inventaireResource.get(1).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()!=0) 
			System.out.println("pas assez de pierre il vous en manque "+(3-inventaireResource.get(1).getResource().getValue()));
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==1) 
			System.out.println("deja poseder");	
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==2)
			System.out.println("Vous posseder une meilleur epee");
		else if(inventaireResource.get(1).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(0).setObjetDeLaCase(new EpeePierre());
			inventaireResource.get(1).EnleverResource();
		}
	}

	public void crafterEpeeMetal() {
		if (inventaireResource.get(2).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()!=0) 
			System.out.println("pas assez de metal il vous en manque "+(3-inventaireResource.get(2).getResource().getValue()));
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==2)
			System.out.println("vous avez deja une epee en metal");
		else if(inventaireResource.get(2).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(0).setObjetDeLaCase(new EpeeMetal());
			inventaireResource.get(2).EnleverResource();
		}
	}

	//HACHE
	public void crafterHacheBois() {
		if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()!=3) 
			System.out.println("pas assez de bois il vous en manque "+(3-inventaireResource.get(0).getResource().getValue()));
		else if(this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()==3) 
			System.out.println("vous avez deja une hache en bois");
		else if(this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()==4 || this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==5)
			System.out.println("Vous posseder une meilleur hache");
		else if(inventaireResource.get(0).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(1).setObjetDeLaCase(new HacheBois());
			inventaireResource.get(0).EnleverResource();
		}
	}

	public void crafterHachePierre() {
		if (inventaireResource.get(1).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()!=3) 
			System.out.println("pas assez de pierre il vous en manque "+(3-inventaireResource.get(1).getResource().getValue()));
		else if(this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()==4) 
			System.out.println("vous avez deja une hache en pierre");
		else if(this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()==5)
			System.out.println("Vous poss�der une meilleur hache");
		else if(inventaireResource.get(1).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(1).setObjetDeLaCase(new HachePierre());
			inventaireResource.get(1).EnleverResource();
		}
	}

	public void crafterHacheMetal() {
		if (inventaireResource.get(2).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()!=3) 
			System.out.println("pas assez de metal il vous en manque "+(3-inventaireResource.get(2).getResource().getValue()));
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==5)
			System.out.println("vous avez deja une hache en metal");
		else if(inventaireResource.get(2).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(1).setObjetDeLaCase(new HacheMetal());
			inventaireResource.get(2).EnleverResource();
		}
	}

	//PIOCHE
	public void crafterPiocheBois() {
		if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()!=6) 
			System.out.println("pas assez de bois il vous en manque "+(3-inventaireResource.get(0).getResource().getValue()));
		else if(this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()==6) 
			System.out.println("vous avez deja une pioche en bois");
		else if(this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()==7 || this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()==8)
			System.out.println("Vous posseder une meilleur pioche");
		else if(inventaireResource.get(0).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(2).setObjetDeLaCase(new PiocheBois());
			inventaireResource.get(0).EnleverResource();
		}
	}
	
	public void crafterPiochePierre() {
		if (inventaireResource.get(1).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()!=7) 
			System.out.println("pas assez de Pierre il vous en manque "+(3-inventaireResource.get(1).getResource().getValue()));
		else if(this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()==7) 
			System.out.println("vous avez deja une pioche en pierre");
		else if(this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()==7 || this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()==8)
			System.out.println("Vous posseder une meilleur pioche");
		else if(inventaireResource.get(1).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(2).setObjetDeLaCase(new PiochePierre());
			inventaireResource.get(1).EnleverResource();
		}
	}

	public void crafterPiocheMetal() {
		if (inventaireResource.get(2).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()!=8) 
			System.out.println("pas assez de metal il vous en manque "+(3-inventaireResource.get(2).getResource().getValue()));
		else if(this.getInventaireObjet().getInventaire().get(2).getNumObjetCase().getValue()==8) 
			System.out.println("vous avez deja une pioche en metal");
		else if(inventaireResource.get(2).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(2).setObjetDeLaCase(new PiocheMetal());
			inventaireResource.get(2).EnleverResource();
		}
	}

	//BANDAGES
	public void crafterBandage() {
		if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(4).getNumObjetCase().getValue()!=9) 
			System.out.println("pas assez de bois");
		else if(this.getInventaireObjet().getInventaire().get(4).getNumObjetCase().getValue()==9 && inventaireResource.get(0).getResource().getValue()>=3) {
			ajtNbBandage();	
			System.out.println("bandage :"+this.nbBandageProperty.getValue());
		}
		else if(inventaireResource.get(0).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(4).setObjetDeLaCase(new Bandage());
			ajtNbBandage();
			System.out.println("bandage :"+this.nbBandageProperty.getValue());
		}
	}

	//KITS DE SOINS
	public void crafterKitDeSoin() {
		if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(5).getNumObjetCase().getValue()!=10) 
			System.out.println("pas assez de bois");
		else if(this.getInventaireObjet().getInventaire().get(5).getNumObjetCase().getValue()==10) {
			ajtNbKitdeSoin();
			System.out.println("kit de soin :"+this.nbKitdeSoinProperty.getValue());
		}
		else if(inventaireResource.get(0).getResource().getValue()>=6 ) {
			this.getInventaireObjet().getInventaire().get(5).setObjetDeLaCase(new KitDeSoin());
			ajtNbKitdeSoin();
			System.out.println("kit de soin :"+this.nbKitdeSoinProperty.getValue());
		}
	}
	
	//PISTOLET
	public void crafterPistolet() {
		if (inventaireResource.get(2).getResource().getValue()<10 && this.getInventaireObjet().getInventaire().get(3).getNumObjetCase().getValue()!=11) 
			System.out.println("pas assez de metals");
		else if(this.getInventaireObjet().getInventaire().get(3).getNumObjetCase().getValue()==11) 
			System.out.println("vous avez deja un pistolet");
		else if(inventaireResource.get(2).getResource().getValue()>=10) {
			this.getInventaireObjet().getInventaire().get(3).setObjetDeLaCase(new Pistolet());
			inventaireResource.get(2).EnleverResource();
			inventaireResource.get(2).EnleverResource();
			inventaireResource.get(2).EnleverResource();
			inventaireResource.get(2).retirerResource();
		}
	}
	
	//BOUCLIER
	public void crafterBouclier() {
		if (inventaireResource.get(2).getResource().getValue() < 3) 
			System.out.println("pas assez de metals");
		else if(nbBouclierProperty.getValue() == 3) 
			System.out.println("Vous avez deja le maximum de bouclier");
		else if(inventaireResource.get(2).getResource().getValue()>=3) {	
			inventaireResource.get(2).EnleverResource();
			this.gagnerBouclier();
			System.out.println(nbBouclierProperty.getValue());
			
		}
	}


	////////Methodes ajout/supp soin////////
	public void ajtNbKitdeSoin() {
		int nbKDS = this.nbKitdeSoinProperty.getValue();
		if(nbKDS < 2) {
			this.nbKitdeSoinProperty.setValue(nbKitdeSoinProperty.getValue()+1);
			inventaireResource.get(0).EnleverResource();
			inventaireResource.get(0).EnleverResource();
		}
	}
	
	public void ajtNbBandage() {
		int nbBandages = nbBandageProperty.getValue()+1;
		if(nbBandages<6) {
			this.nbBandageProperty.setValue(nbBandages);
			inventaireResource.get(0).EnleverResource();
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

	/////// Les Getters //////////////
	public final int getNbCoeurs() {
		return this.nbCoeursProperty.getValue();
	}
	public final int getNbBouclier() {
		return this.nbBouclierProperty.getValue();
	}
	public final int getX() {
		return x.getValue();
	}
	public final int getY() {
		return y.getValue();
	}
	public int getNbSaut() {
		return nbSaut;
	}
	public boolean getDroite() {
		return droite;
	}
	public void setDroite(boolean droite) {
		this.droite = droite;
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
	public void setSaute(boolean saute) {
		this.saute = saute;
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
	public ArrayList<Resource> getInventaireResource() {
		return inventaireResource;
	}
	
	
}
