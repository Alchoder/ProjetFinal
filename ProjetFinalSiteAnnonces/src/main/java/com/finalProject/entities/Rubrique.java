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
import javax.persistence.Table;

@Entity
@Table(name="rubrique")
public class Rubrique {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idRubrique")
	private int idRubrique;
	@Column(nullable=false, unique=true, length= 30)
	private String titreRubrique;
	@Column(length= 500)
	private String imageRubrique;
	public int getIdRubrique() {
		return idRubrique;
	}
	public void setIdRubrique(int idRubrique) {
		this.idRubrique = idRubrique;
	}
	public String getTitreRubrique() {
		return titreRubrique;
	}
	public void setTitreRubrique(String titreRubrique) {
		this.titreRubrique = titreRubrique;
	}
	public String getImageRubrique() {
		return imageRubrique;
	}
	public void setImageRubrique(String imageRubrique) {
		this.imageRubrique = imageRubrique;
	}
	@Override
	public String toString() {
		return "Rubrique [idRubrique=" + idRubrique + ", titreRubrique=" + titreRubrique + ", imageRubrique="
				+ imageRubrique + "]";
	}
	public Rubrique(int idRubrique, String titreRubrique, String imageRubrique) {
		super();
		this.idRubrique = idRubrique;
		this.titreRubrique = titreRubrique;
		this.imageRubrique = imageRubrique;
	}
	public Rubrique(String titreRubrique, String imageRubrique) {
		super();
		this.titreRubrique = titreRubrique;
		this.imageRubrique = imageRubrique;
	}
	public Rubrique() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
