package com.finalProject.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="annonce")
public class Annonce {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAnnonce")
	private int idAnnonce;
	@Column(nullable=false, length= 30)
	private String titreAnnonce;
	@Column(nullable=false, length= 500)
	private String description;
	@Column(nullable=false)
	private int prix;
	@Column(length = 500)
	private String imageAnnonce;
	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Utilisateur utilisateur;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Departement dpt;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="rubrique_Affectation",
	joinColumns=@JoinColumn(name="annonce", referencedColumnName="idAnnonce"),
	inverseJoinColumns=@JoinColumn(name="rubrique", referencedColumnName="idRubrique"))
	private List<Rubrique> rubriques;

	

	public int getIdAnnonce() {
		return idAnnonce;
	}



	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}



	public String getTitreAnnonce() {
		return titreAnnonce;
	}



	public void setTitreAnnonce(String titreAnnonce) {
		this.titreAnnonce = titreAnnonce;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getPrix() {
		return prix;
	}



	public void setPrix(int prix) {
		this.prix = prix;
	}



	public String getImageAnnonce() {
		return imageAnnonce;
	}



	public void setImageAnnonce(String imageAnnonce) {
		this.imageAnnonce = imageAnnonce;
	}





	public List<Rubrique> getRubriques() {
		return rubriques;
	}



	public void setRubriques(List<Rubrique> rubriques) {
		this.rubriques = rubriques;
	}



	


	@Override
	public String toString() {
		return "Annonce [idAnnonce=" + idAnnonce + ", titreAnnonce=" + titreAnnonce + ", description=" + description
				+ ", prix=" + prix + ", imageAnnonce=" + imageAnnonce + ", utilisateur=" + utilisateur + ", dpt=" + dpt
				+ ", rubriques=" + rubriques + "]";
	}



	public Annonce(String titreAnnonce, String description, int prix, String imageAnnonce, Utilisateur utilisateur,
			Departement dpt, List<Rubrique> rubriques) {
		super();
		this.titreAnnonce = titreAnnonce;
		this.description = description;
		this.prix = prix;
		this.imageAnnonce = imageAnnonce;
		this.utilisateur = utilisateur;
		this.dpt = dpt;
		this.rubriques = rubriques;
	}



	public Annonce(int idAnnonce, String titreAnnonce, String description, int prix, String imageAnnonce,
			Utilisateur utilisateur, Departement dpt, List<Rubrique> rubriques) {
		super();
		this.idAnnonce = idAnnonce;
		this.titreAnnonce = titreAnnonce;
		this.description = description;
		this.prix = prix;
		this.imageAnnonce = imageAnnonce;
		this.utilisateur = utilisateur;
		this.dpt = dpt;
		this.rubriques = rubriques;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public Departement getDpt() {
		return dpt;
	}



	public void setDpt(Departement dpt) {
		this.dpt = dpt;
	}



	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}	

