package com.finalProject.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleUtilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idRole")
	private int idRole;
	private String roleName;
//	private List<Utilisateur> utilisateurs;

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	@Override
	public String toString() {
		return "RoleUtilisateur [idRole=" + idRole + ", roleName=" + roleName + "]";
	}

	public RoleUtilisateur(String roleName) {
		super();
		this.roleName = roleName;
	}

	public RoleUtilisateur(int idRole, String roleName) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
	}

	public RoleUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
