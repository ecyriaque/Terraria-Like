package jeu.modele.objet;

public class Arme extends Objet{
	
	
	private String TypeArme;
	private String materiel;
	
	public Arme(String TypeArme,String materiel) {
		super("Arme");
		this.TypeArme=TypeArme;
		this.materiel=materiel;
	}
	public String getArme() {
		return TypeArme;
	}
	public String getMateriel() {
		return materiel;
	}
	
	
}
