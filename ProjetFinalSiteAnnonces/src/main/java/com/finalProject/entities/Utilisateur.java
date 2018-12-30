package com.finalProject.entities;

import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUtilisateur")
	private int idUtilisateur;
	@Column(nullable = false)
	private String nomUtilisateur;
	@Column(nullable = false)
	private String prenomUtilisateur;
	@Column(nullable = false , unique = true)
	private String login;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private Date dateDeNaissance;
	private int numVoie;
	private String rue;
	private String codePostal;
	private String ville;
	private String telephone;
	private String PhotoProfil;
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="role_Affectation",
	joinColumns=@JoinColumn(name="utilisateur", referencedColumnName="idUtilisateur"),
	inverseJoinColumns=@JoinColumn(name="role", referencedColumnName="idRole"))
	@JsonIgnore
	private List<RoleUtilisateur> roles;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="utilisateur")
	@JsonIgnore
	private List<Annonce> annonces;

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public int getNumVoie() {
		return numVoie;
	}

	public void setNumVoie(int numVoie) {
		this.numVoie = numVoie;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPhotoProfil() {
		return PhotoProfil;
	}

	public void setPhotoProfil(String photoProfil) {
		PhotoProfil = photoProfil;
	}

	public List<RoleUtilisateur> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleUtilisateur> roles) {
		this.roles = roles;
	}

	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", login=" + login + ", password=" + password
				+ ", dateDeNaissance=" + dateDeNaissance + ", numVoie=" + numVoie + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", telephone=" + telephone + ", PhotoProfil=" + PhotoProfil
				+ ", roles=" + roles + ", annonces=" + annonces + "]";
	}

	
	public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String login,
			String password, Date dateDeNaissance, int numVoie, String rue, String codePostal, String ville,
			String telephone, String photoProfil, List<RoleUtilisateur> roles, List<Annonce> annonces) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.login = login;
		this.password = password;
		this.dateDeNaissance = dateDeNaissance;
		this.numVoie = numVoie;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		PhotoProfil = photoProfil;
		this.roles = roles;
		this.annonces = annonces;
	}


	public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String login, String password,
			Date dateDeNaissance, int numVoie, String rue, String codePostal, String ville, String telephone,
			String photoProfil, List<RoleUtilisateur> roles, List<Annonce> annonces) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.login = login;
		this.password = password;
		this.dateDeNaissance = dateDeNaissance;
		this.numVoie = numVoie;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		PhotoProfil = photoProfil;
		this.roles = roles;
		this.annonces = annonces;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
