package jeu.modele.inventaire.objet;

public class ObjetSoin extends ObjetInventaire{
	
	int nbDobjet;
	
	public ObjetSoin(String typeobjet,int numObjet) {
		super(typeobjet,numObjet);
	}

	public void addUnObjet() {
		nbDobjet++;
	}
	
	public int getNbDobjet(){
		return this.nbDobjet;
	}
	
}
