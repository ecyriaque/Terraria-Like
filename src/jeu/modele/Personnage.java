package jeu.modele;



public abstract class Personnage {

	

	public Personnage() {	
	}	
	public abstract void perdrePv() ;
	
	public abstract void allerAGauche();
	
	public abstract void allerADroite();
	
	public abstract void sauter();
	
	public abstract void tomber();
	
	public abstract int getX();
	
	public abstract int getY();
	public void perdrePv(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
