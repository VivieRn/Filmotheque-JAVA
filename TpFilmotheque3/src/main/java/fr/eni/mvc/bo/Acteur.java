package fr.eni.mvc.bo;

import javax.persistence.Entity;

@Entity
public class Acteur extends Personne {

	public Acteur() {
		super();
	}

	public Acteur(String nom, String prenom) {
		super(nom, prenom);
	}

	public Acteur(int id, String nom, String prenom) {
		super(id, nom, prenom);
	}

}
