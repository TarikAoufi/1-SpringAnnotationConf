package fr.aoufi.springsampleannotation.model;

import java.io.Serializable;

public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nom;

	private String prenom;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}