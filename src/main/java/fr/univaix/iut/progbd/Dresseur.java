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
	
	@OneToMany
	private Collection<Pokemon> pokemon;

	public Dresseur(String nom, Collection<Pokemon> pokemon) {
		super();
		this.nom = nom;
		this.pokemon = pokemon;
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
		if (pokemon == null) {
			if (other.pokemon != null)
				return false;
		} else if (!pokemon.equals(other.pokemon))
			return false;
		return true;
	}

	public String getNom() {
		return nom;
	}

	public Collection<Pokemon> getPokemon() {
		return pokemon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((pokemon == null) ? 0 : pokemon.hashCode());
		return result;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPokemon(Collection<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "Dresseur [nom=" + nom + ", pokemon=" + pokemon + "]";
	}
}