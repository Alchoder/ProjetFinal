package com.finalProject.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "departement")
public class Departement {

	@Id
	private int idDpt;
	@Column(nullable = false, unique = true, length=40)
	private String nomDpt;
	@Column(nullable = false, unique = true, length=2)
	private String numDpt;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dpt")
	@JsonIgnore
	private List<Annonce> annonces;

	public int getIdDpt() {
		return idDpt;
	}

	public void setIdDpt(int idDpt) {
		this.idDpt = idDpt;
	}

	public String getNomDpt() {
		return nomDpt;
	}

	public void setNomDpt(String nomDpt) {
		this.nomDpt = nomDpt;
	}

	public String getNumDpt() {
		return numDpt;
	}

	public void setNumDpt(String numDpt) {
		this.numDpt = numDpt;
	}

	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	@Override
	public String toString() {
		return "Departement [idDpt=" + idDpt + ", nomDpt=" + nomDpt + ", numDpt=" + numDpt + ", annonces=" + annonces
				+ "]";
	}

	public Departement(int idDpt, String nomDpt, String numDpt, List<Annonce> annonces) {
		super();
		this.idDpt = idDpt;
		this.nomDpt = nomDpt;
		this.numDpt = numDpt;
		this.annonces = annonces;
	}

	public Departement(String nomDpt, String numDpt, List<Annonce> annonces) {
		super();
		this.nomDpt = nomDpt;
		this.numDpt = numDpt;
		this.annonces = annonces;
	}

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

}
