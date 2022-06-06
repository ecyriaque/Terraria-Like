package jeu.modele.inventaire.objet;

public class ObjetSoin extends ObjetInventaire{
	
	int nbDobjet;
	
	public ObjetSoin(String typeobjet,int numObjet) {
		super(typeobjet,numObjet);
		// TODO Auto-generated constructor stub
	}

	public void addUnObjet() {
		nbDobjet++;
	}
	
}
