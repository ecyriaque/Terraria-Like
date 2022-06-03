package jeu.modele.objet;

public class Epee extends Arme{

	int degat;
	
	public Epee(String materiel) {
		super("Epee", materiel);
		this.degat=0;
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "je suis une Epee "+this.getMateriel();
	}
}
