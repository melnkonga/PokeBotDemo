package fr.univaix.iut.progbd;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Dresseur 
{
	public Dresseur(String nom) {
		super();
		this.nom = nom;
	}

	public Dresseur() {
		super();
	}


	@Id
	private String nom;
	
	@OneToMany(targetEntity = PokeBot.class, mappedBy = "owner")
	private Collection<PokeBot> poke;

	public Dresseur(String nom, Collection<PokeBot> poke) {
		super();
		this.nom = nom;
		this.poke = poke;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dresseur other = (Dresseur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (poke == null) {
			if (other.poke != null)
				return false;
		} else if (!poke.equals(other.poke))
			return false;
		return true;
	}

	public String getNom() {
		return nom;
	}

	public Collection<PokeBot> getPokemon() {
		return poke;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((poke == null) ? 0 : poke.hashCode());
		return result;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPokemon(Collection<PokeBot> poke) {
		this.poke = poke;
	}

	@Override
	public String toString() {
		return "Dresseur [nom=" + nom + ", poke=" + poke + "]";
	}
}