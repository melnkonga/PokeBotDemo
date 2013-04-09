package fr.univaix.iut.progbd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Dresseur 
{
	
	

	public Dresseur() {
		super();
	}


	@Id
	@OneToMany(targetEntity = PokeBot.class, mappedBy = "owner")
	private String nom;
	
	

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Dresseur(String nom) {
		super();
		this.nom = nom;
		
	}



	@Override
	public String toString() {
		return "Dresseur [" + (nom != null ? "nom=" + nom : "") + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Dresseur other = (Dresseur) obj;
		if (nom == null) {
			if (other.nom != null)
			{
				return false;
			};
		} else if (!nom.equals(other.nom))
		{
			return false;
		}
		return true;
	}

	
}