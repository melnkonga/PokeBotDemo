package fr.univaix.iut.progbd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PokeBot 
{
	@Id
	private String nom;
	private String owner;
	private int pv = 100;

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	@ManyToOne
	private Pokemon typePokemon1;
	
	@ManyToOne
	private Pokemon typePokemon2;

	public PokeBot() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + pv;
		result = prime * result
				+ ((typePokemon1 == null) ? 0 : typePokemon1.hashCode());
		result = prime * result
				+ ((typePokemon2 == null) ? 0 : typePokemon2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokeBot other = (PokeBot) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (pv != other.pv)
			return false;
		if (typePokemon1 == null) {
			if (other.typePokemon1 != null)
				return false;
		} else if (!typePokemon1.equals(other.typePokemon1))
			return false;
		if (typePokemon2 == null) {
			if (other.typePokemon2 != null)
				return false;
		} else if (!typePokemon2.equals(other.typePokemon2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PokeBot [nom=" + nom + ", owner=" + owner + ", typePokemon1="
				+ typePokemon1 + ", typePokemon2=" + typePokemon2 + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Pokemon getTypePokemon1() {
		return typePokemon1;
	}

	public void setTypePokemon1(Pokemon typePokemon1) {
		this.typePokemon1 = typePokemon1;
	}

	public Pokemon getTypePokemon2() {
		return typePokemon2;
	}

	public void setTypePokemon2(Pokemon typePokemon2) {
		this.typePokemon2 = typePokemon2;
	}
}
