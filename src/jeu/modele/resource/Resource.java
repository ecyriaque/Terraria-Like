package jeu.modele.resource;
import javafx.beans.property.IntegerProperty;

public abstract class Resource {

	private String typeResource;
	
	public Resource(String typeResource) {
		this.typeResource=typeResource;
	}

	public String getTypeResource() {
		return typeResource;
	}

	public abstract void retirerResource();
	
	public abstract void ajouterResource();
	
	public abstract void EnleverResource();
	
	public abstract IntegerProperty getResource();

}
