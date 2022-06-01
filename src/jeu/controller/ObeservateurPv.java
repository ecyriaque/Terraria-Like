package jeu.controller;

import jeu.modele.Joueur;
import jeu.vue.VuePv;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ObeservateurPv implements ChangeListener<Number> {
	

	private VuePv pv;
	private Joueur j;
	public ObeservateurPv(VuePv pv,Joueur j) {

		this.j=j;
		this.pv=pv;
		
	}
	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		pv.setImageActive(pv.getTabImage()[j.nbCoeurProperty().getValue()]);
		
	}
	
	

		
}


