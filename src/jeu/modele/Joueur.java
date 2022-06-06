package jeu.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.modele.inventaire.Inventaire;
import jeu.modele.inventaire.objet.ObjetInventaire;
import jeu.modele.inventaire.objet.ObjetVide;
import jeu.modele.inventaire.objet.caseInventaire;
import jeu.modele.inventaire.objet.arme.EpeeBois;
import jeu.modele.inventaire.objet.arme.EpeeMetal;
import jeu.modele.inventaire.objet.arme.EpeePierre;
import jeu.modele.inventaire.objet.arme.HacheBois;
import jeu.modele.inventaire.objet.arme.HacheMetal;
import jeu.modele.inventaire.objet.arme.HachePierre;
import jeu.modele.inventaire.objet.objetSoin.Bandage;
import jeu.modele.inventaire.objet.objetSoin.KitDeSoin;
import jeu.modele.resource.Bois;
import jeu.modele.resource.Metal;
import jeu.modele.resource.Pierre;
import jeu.modele.resource.Resource;


public class Joueur {
	//variables//
	private int xx,yy;
	private IntegerProperty x,y;
	private IntegerProperty nbCoeursProperty;
	protected Map env;
	private int nbSaut =0;
	private int vitesse;
	private boolean droite,gauche,saute; //vraie si il se deplace ou saute
	private ArrayList<Resource> inventaireResource;
	private Inventaire inventaireObjet =new Inventaire();
	private Resource bois= new Bois();
	private Resource metal= new Metal();
	private Resource pierre=new Pierre();
	//CONSTRUCTEUR//
	public Joueur() {
		this.xx = 40;
		this.yy =360;
		this.nbCoeursProperty=new SimpleIntegerProperty(5);
		this.x = new SimpleIntegerProperty(xx);
		this.y = new SimpleIntegerProperty(yy);
		this.vitesse = 8;
		
		caseInventaire case1= new caseInventaire(new ObjetVide());
		caseInventaire case2=new caseInventaire(new ObjetVide());
		caseInventaire case3=new caseInventaire(new ObjetVide());
		caseInventaire case4=new caseInventaire(new ObjetVide());
		caseInventaire case5=new caseInventaire(new ObjetVide());
		caseInventaire case6=new caseInventaire(new ObjetVide());
		
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




	
	public Inventaire getInventaireObjet() {
		return this.inventaireObjet;
	}
	
	public ArrayList<Resource> getInventaireResource() {
		return inventaireResource;
	}
	
	
	
	//Methodes de gestion des PV //
	public void perdrepv() {
	int c=this.getNbCoeurs()-1;
	if(getNbCoeurs()>=1) 
		this.nbCoeursProperty.setValue(c);
	}
	public void gagnerpv() {
		int c=this.getNbCoeurs()+1;
		if(getNbCoeurs()<5)
			this.nbCoeursProperty.setValue(c);
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
		if(npos >0 ) {
			if(nbSaut<6) {
				this.y.setValue(npos);
				nbSaut++;
			}
		}
	}
	public void tomber() {
		int npos = getY()+10;
		this.y.setValue(npos);
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

	
	/////// Les Getters //////////////
	public final int getNbCoeurs() {
		return this.nbCoeursProperty.getValue();
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
	
		///////////////// methodes de craft ///////////////////////
		
		/////////////craft d'epee///////////////////////
	public void crafterEpeeBois() {
			
			if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==0) {
				System.out.println("pas assez de bois il vous en manque "+(3-inventaireResource.get(0).getResource().getValue()));
			}
			
			else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==0) {
				System.out.println("deja poseder");
			}
			else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==1 || this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==2){
				System.out.println("Vous posséder une meilleur épee");
			}
			else if(inventaireResource.get(0).getResource().getValue()>=3) {
				System.out.println(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase());
				this.getInventaireObjet().getInventaire().get(0).setObjetDeLaCase(new EpeeBois());
				inventaireResource.get(0).EnleverResource();
				
			}
			
	}
	
	
	
	public void crafterEpeePierre() {
		
		if (inventaireResource.get(1).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()!=0) {
			
			
			System.out.println("pas assez de pierre il vous en manque "+(3-inventaireResource.get(1).getResource().getValue()));
		
		}
		
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==1) {
			System.out.println("deja poseder");
		}
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==2){
			System.out.println("Vous posséder une meilleur épee");
		}
		else if(inventaireResource.get(1).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(0).setObjetDeLaCase(new EpeePierre());
			inventaireResource.get(1).EnleverResource();
		}
		
	}
	
	public void crafterEpeeMetal() {
			
			if (inventaireResource.get(2).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()!=0) {
				
				
				System.out.println("pas assez de metal il vous en manque "+(3-inventaireResource.get(2).getResource().getValue()));
			
			}
			
			else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==2)
				System.out.println("vous avez deja une epee en metal");
			else if(inventaireResource.get(2).getResource().getValue()>=3) {
				this.getInventaireObjet().getInventaire().get(0).setObjetDeLaCase(new EpeeMetal());
				inventaireResource.get(2).EnleverResource();
			}
			
		}
	
		/////////////craft de hache///////////////////////
		
		
		
	public void crafterHacheBois() {
			
			if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()!=3) {
				System.out.println("pas assez de bois il vous en manque "+(3-inventaireResource.get(0).getResource().getValue()));
			}
			
			else if(this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()==3) {
				System.out.println("vous avez deja une hache en bois");
			}
			else if(this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()==4 || this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==5){
				System.out.println("Vous posséder une meilleur hache");
			}
			else if(inventaireResource.get(0).getResource().getValue()>=3) {
				this.getInventaireObjet().getInventaire().get(1).setObjetDeLaCase(new HacheBois());
				inventaireResource.get(0).EnleverResource();
			}
			
		}
	
	
	
	public void crafterHachePierre() {
		
		if (inventaireResource.get(1).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()!=3) {
			
			
			System.out.println("pas assez de pierre il vous en manque "+(3-inventaireResource.get(1).getResource().getValue()));
		
		}
		
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==4) {
			System.out.println("vous avez deja une hache en pierre");
		}
		else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==5){
			System.out.println("Vous posséder une meilleur hache");
		}
		else if(inventaireResource.get(1).getResource().getValue()>=3) {
			this.getInventaireObjet().getInventaire().get(1).setObjetDeLaCase(new HachePierre());
			inventaireResource.get(1).EnleverResource();
		}
		
	}
	
	public void crafterHacheMetal() {
			
			if (inventaireResource.get(2).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()!=3) {
				
				
				System.out.println("pas assez de metal il vous en manque "+(3-inventaireResource.get(2).getResource().getValue()));
			
			}
			
			else if(this.getInventaireObjet().getInventaire().get(0).getNumObjetCase().getValue()==5)
				System.out.println("vous avez deja une hache en metal");
			else if(inventaireResource.get(2).getResource().getValue()>=3) {
				this.getInventaireObjet().getInventaire().get(0).setObjetDeLaCase(new HacheMetal());
				inventaireResource.get(2).EnleverResource();
			}
			
		}	
	
		/////////////craft de soin///////////////////////
		
	public void crafterBandage() {
			
			if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()!=9) {
				System.out.println("pas assez de bois");
			}
			
			else if(this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()==9)
				System.out.println("deja poseder");
			else if(inventaireResource.get(0).getResource().getValue()>=3) {
				this.getInventaireObjet().getInventaire().get(4).setObjetDeLaCase(new Bandage());
				inventaireResource.get(0).EnleverResource();
			}
			
		}
	
	public void crafterKitDeSoin() {
		
		if (inventaireResource.get(0).getResource().getValue()<3 && this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()!=10) {
			System.out.println("pas assez de bois");
		}
		
		else if(this.getInventaireObjet().getInventaire().get(1).getNumObjetCase().getValue()==10)
			System.out.println("deja poseder");
		else if(inventaireResource.get(0).getResource().getValue()>=6) {
			this.getInventaireObjet().getInventaire().get(5).setObjetDeLaCase(new KitDeSoin());
			inventaireResource.get(0).EnleverResource();
			inventaireResource.get(0).EnleverResource();
		}
		
	}
	
	
	
}
