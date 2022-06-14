package jeu.modele;

import java.util.ArrayList;

public class Construction {
	
	//Variables
	private int valTabDroitePlacer;
	private int valTabGauchePlacer;	
	private int valTabDroiteCasser;
	private int valTabGaucheCasser;
	private int[] map;
	private Joueur joueur;	
	private ArrayList<Integer> tuileDure ;
	private ArrayList<Integer> tuileCassable;
	private int nbTuileParLigne;
	private Environnement env;
	//Construceur
	public Construction(Environnement env ) {
		this.env=env;
		this.tuileDure = new ArrayList<>();
		tuileDure.add(1);
		tuileDure.add(2);
		tuileDure.add(3);
		tuileDure.add(4);
		tuileDure.add(5);
		tuileDure.add(6);
		this.tuileCassable = new ArrayList<>();
		tuileCassable.add(4);
		tuileCassable.add(5);
		tuileCassable.add(6);
		
		this.map = env.getTabMap();
		this.joueur =env.getJoueur();
		
		this.valTabDroitePlacer = map[joueur.constructionDroitePlacer()];	
		this.valTabGauchePlacer = map[joueur.constructionGauchePlacer()];	
		this.valTabDroiteCasser = map[joueur.constructionDroiteCasser()];	
		this.valTabGaucheCasser = map[joueur.constructionGaucheCasser()];
		
		this.nbTuileParLigne = 20;
		
	}
	
	//DROITE
	//placer
	public boolean peutPlacerDroite() {
		
		if(env.getListeResource().get(joueur.getMatChoisi()).getNbResourceProperty().getValue() > 0  && Collision.graviter(joueur, map) && tuileDure.contains(map[joueur.constructionDroitePlacer()+nbTuileParLigne] ) && joueur.getObjetEquiperProperty().getValue()==joueur.getMatChoisi()+13 )
			return (!tuileDure.contains(valTabDroitePlacer));
		return false;
	}
	public void placerTuileDroite() {
		map[joueur.constructionDroitePlacer()] = joueur.getMatChoisi()+4;
		joueur.getEnv().getListeResource().get(joueur.getMatChoisi()).EnleverResource(1);
	}
	//casser
	public boolean peutCasserDroite() {
		if (valTabDroiteCasser==4 && (joueur.getObjetEquiperProperty().getValue()==3 ||joueur.getObjetEquiperProperty().getValue()==4 || joueur.getObjetEquiperProperty().getValue()==5 ||joueur.getObjetEquiperProperty().getValue()==12 )) {
			System.out.println("on casse du bois");
			return tuileCassable.contains(valTabDroiteCasser);
		}else if (valTabDroiteCasser==5 && (joueur.getObjetEquiperProperty().getValue()==6 ||joueur.getObjetEquiperProperty().getValue()==7 || joueur.getObjetEquiperProperty().getValue()==8 )) {
			System.out.println("on casse de la pierre");
			return tuileCassable.contains(valTabDroiteCasser);
		}else if (valTabDroiteCasser==6 && (joueur.getObjetEquiperProperty().getValue()==7 ||joueur.getObjetEquiperProperty().getValue()==8)) {
			System.out.println("on casse du metal");
			return tuileCassable.contains(valTabDroiteCasser);
		}
		return false;
	}
	
	public void casserTuileDroite() {
		map[joueur.constructionDroiteCasser()] = 0;
		if(valTabDroiteCasser==4)
			joueur.getEnv().AjouterResource("bois");
		
		else if (valTabDroiteCasser == 5)
			joueur.getEnv().AjouterResource("pierre");
		else
			joueur.getEnv().AjouterResource("metal");
			
	}

	
	
	//GAUCHE
	//placer
	public boolean peutPlacerGauche() {
		if(joueur.getEnv().getListeResource().get(joueur.getMatChoisi()).getNbResourceProperty().getValue() > 0 &&  Collision.graviter(joueur, map) && tuileDure.contains(map[joueur.constructionGauchePlacer()+nbTuileParLigne] )&& joueur.getObjetEquiperProperty().getValue()==joueur.getMatChoisi()+13)
			return !tuileDure.contains(valTabGauchePlacer);
		return false;
	}
	public void placerTuileGauche() {
		map[joueur.constructionGauchePlacer()] = joueur.getMatChoisi() + 4;
		joueur.getEnv().getListeResource().get(joueur.getMatChoisi()).EnleverResource(1);
	}
	//casser
	public boolean peutCasserGauche() {
		if (valTabGaucheCasser==4 && (joueur.getObjetEquiperProperty().getValue()==3 ||joueur.getObjetEquiperProperty().getValue()==4 || joueur.getObjetEquiperProperty().getValue()==5 ||joueur.getObjetEquiperProperty().getValue()==12 )) {
			System.out.println("on casse du bois");
			return tuileCassable.contains(valTabGaucheCasser);
		}else if (valTabGaucheCasser==5 && (joueur.getObjetEquiperProperty().getValue()==6 ||joueur.getObjetEquiperProperty().getValue()==7 || joueur.getObjetEquiperProperty().getValue()==8 )) {
			System.out.println("on casse de la pierre");
			return tuileCassable.contains(valTabGaucheCasser);
		}else if (valTabGaucheCasser==6 && (joueur.getObjetEquiperProperty().getValue()==7 ||joueur.getObjetEquiperProperty().getValue()==8)) {
			System.out.println("on casse du metal");
			return tuileCassable.contains(valTabGaucheCasser);
		}return false;
	}
	public void casserTuileGauche() {
		map[joueur.constructionGaucheCasser()] = 0;
		if(valTabGaucheCasser==4)
			joueur.getEnv().AjouterResource("bois");
		else if (valTabGaucheCasser == 5)
			joueur.getEnv().AjouterResource("pierre");
		else
			joueur.getEnv().AjouterResource("metal");
	}
	
	
	
	//Getters
	public int getValTabDroite() {
		return valTabDroitePlacer;
	}
	public int getValTabGauche() {
		return valTabGauchePlacer;
	}
	public int[] getMap() {
		return map;
	}
	public int getValTabDroitePlacer() {
		return valTabDroitePlacer;
	}
	public int getValTabGauchePlacer() {
		return valTabGauchePlacer;
	}
	public int getValTabDroiteCasser() {
		return valTabDroiteCasser;
	}
	public int getValTabGaucheCasser() {
		return valTabGaucheCasser;
	}
	public ArrayList<Integer> getTuileDure() {
		return tuileDure;
	}
	public ArrayList<Integer> getTuileCassable() {
		return tuileCassable;
	}

	
	//Setters
	public void setValTabDroite(int valTabDroite) {
		this.valTabDroitePlacer = valTabDroite;
	}
	public void setValTabGauche(int valTabGauche) {
		this.valTabGauchePlacer = valTabGauche;
	}
	public void setMap(int[] map) {
		this.map = map;
	}
}
