package jeu.modele;

import java.util.Random;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Circle;


public class Joueur {
	private int xx,yy;
	private IntegerProperty x,y;
	protected Environnement env;
	
	public Joueur() {
		this.xx = 100;
		this.yy = 350;
		this.x = new SimpleIntegerProperty(xx);
		this.y = new SimpleIntegerProperty(yy);
	}
	
	public void allerAGauche() {
		int npos = getX()-8;
		if(npos > -10)
			this.x.setValue(npos);
    }
    public void allerADroite() {
    	int npos = getX()+8;
    	if (npos <770)
    		this.x.setValue(npos);
    }

    public final int getX() {
        return x.getValue();
    }
    public final void setX(int n){
        x.setValue(n);
    }
    public final IntegerProperty xProperty(){
        return this.x;
    }


    public final int getY() {
        return y.getValue();
    }
    public final void setY(int n){
        y.setValue(n);
    }
    public final IntegerProperty yProperty(){
        return this.y;
    }
}
