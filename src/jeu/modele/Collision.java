package jeu.modele;

public class Collision {

	public static boolean collisionDroite(Joueur joueur,int[] tabMap){
		int xtile;
		int ytile,ytile2,ytile3;
		int ValeurTile,ValeurTil2, ValeurTil3;
		
		xtile=(joueur.getX()+41)/40;
		ytile=(joueur.getY()+20)/40;
		ytile3=(joueur.getY()+35)/40;
		ytile2=(joueur.getY()+5)/40;
		ValeurTile=tabMap[(xtile+(ytile*20))];
		ValeurTil2=tabMap[(xtile+(ytile2*20))];
		ValeurTil3=tabMap[(xtile+(ytile3*20))];
		if (ValeurTile!=0 && ValeurTile!=7 || ValeurTil2!=0 && ValeurTil2!=7  || ValeurTil3!=0 && ValeurTil3!=7  ) {
			return true;
		}
		return false;
	}
	
	public static boolean collisionGauche(Joueur joueur,int[] tabMap){
		int xtile;
		int ytile,ytile2,ytile3;
		int ValeurTile,ValeurTil2, ValeurTil3;
		
		xtile=(joueur.getX()-1)/40;
		ytile=(joueur.getY()+1)/40;
		ytile2=(joueur.getY()+20)/40;
		ytile3=(joueur.getY()+39)/40;
		ValeurTile=tabMap[(xtile+(ytile*20))];
		ValeurTil2=tabMap[(xtile+(ytile2*20))];
		ValeurTil3=tabMap[(xtile+(ytile3*20))];
		if(ValeurTile!=0 && ValeurTile!=7 || ValeurTil2!=0 && ValeurTil2!=7  || ValeurTil3!=0 && ValeurTil3!=7  ) {
			return true;
		}
		return false;
	}
	
	public static boolean collisionHaut(Joueur joueur,int[] tabMap){
		int xtile,xtile2,xtile3;
		int ytile;
		int ValeurTile,ValeurTil2, ValeurTil3;
		
		xtile=(joueur.getX()+20)/40;
		xtile2=(joueur.getX())/40;
		xtile3=(joueur.getX()+39)/40;
		ytile=(joueur.getY()-1)/40;
		ValeurTile=tabMap[(xtile+(ytile*20))];
		ValeurTil2=tabMap[(xtile2+(ytile*20))];
		ValeurTil3=tabMap[(xtile3+(ytile*20))];
		if (ValeurTile!=0 && ValeurTile!=7 || ValeurTil2!=0 && ValeurTil2!=7  || ValeurTil3!=0 && ValeurTil3!=7  ) {
			return true;
		}
		return false;
	}
	
	

	public static boolean graviter(Joueur joueur,int[] tabMap) {
		int xtile,xtile2,xtile3;
		int ytile;
		int ValeurTile,ValeurTil2, ValeurTil3;
		
		xtile=joueur.getX()/40;
		xtile2=(joueur.getX()+20)/40;
		xtile3=(joueur.getX()+39)/40;
		ytile=(joueur.getY()+40)/40;
		ValeurTile=tabMap[(xtile+(ytile*20))];
		ValeurTil2=tabMap[(xtile2+(ytile*20))];
		ValeurTil3=tabMap[(xtile3+(ytile*20))];
		if (ValeurTile!=0 && ValeurTile!=7 || ValeurTil2!=0 && ValeurTil2!=7  || ValeurTil3!=0 && ValeurTil3!=7  ) {
			return true;
		}
		return false;
	}
}
