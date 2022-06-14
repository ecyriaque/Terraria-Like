package jeu.modele.resource;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Resource {

	private String typeResource;
	private IntegerProperty nbResource;
	
	
	public Resource(String typeResource) {
		this.typeResource=typeResource;
		nbResource = new SimpleIntegerProperty(0);
	}

	
	public  void ajouterResource(){
		int c;
		c=this.nbResource.getValue()+1;
		if (this.nbResource.getValue() < 99)
		this.nbResource.setValue(c);
	}
	
	public IntegerProperty getResource() {
		return this.getNbPierre();	
	}
	
	public  void EnleverResource(int nbR){
		int c;
		c=this.nbResource.getValue()-nbR;
		this.nbResource.setValue(c);
	}
	
	public IntegerProperty getNbPierre() {
		return nbResource;
	}
}
