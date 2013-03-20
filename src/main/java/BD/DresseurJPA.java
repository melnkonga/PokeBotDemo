package BD;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@javax.persistence.Entity
public class DresseurJPA implements Serializable {
	
	@Id
	private int idDresseur;
	
	private String nomDresseur;
	@ManyToOne
	private Collection<PokemonJPA> nomPokemon;
	public int getIdDresseur() {
		return idDresseur;
	}
	public void setIdDresseur(int idDresseur) {
		this.idDresseur = idDresseur;
	}
	public String getNomDresseur() {
		return nomDresseur;
	}
	public void setNomDresseur(String nomDresseur) {
		this.nomDresseur = nomDresseur;
	}	

	public Collection<PokemonJPA> getNomPokemon() {
		return nomPokemon;
	}
	public void setNomPokemon(Collection<PokemonJPA> nomPokemon) {
		this.nomPokemon = nomPokemon;
	}
	@Override
	public String toString() {
		return "DresseurJPA [idDresseur=" + idDresseur + ", nomDresseur="
				+ nomDresseur + ", nomPokemon=" + nomPokemon + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDresseur;
		result = prime * result
				+ ((nomDresseur == null) ? 0 : nomDresseur.hashCode());
		result = prime * result
				+ ((nomPokemon == null) ? 0 : nomPokemon.hashCode());
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
		DresseurJPA other = (DresseurJPA) obj;
		if (idDresseur != other.idDresseur)
			return false;
		if (nomDresseur == null) {
			if (other.nomDresseur != null)
				return false;
		} else if (!nomDresseur.equals(other.nomDresseur))
			return false;
		if (nomPokemon == null) {
			if (other.nomPokemon != null)
				return false;
		} else if (!nomPokemon.equals(other.nomPokemon))
			return false;
		return true;
	}
	public DresseurJPA(int idDresseur, String nomDresseur,
			Collection<PokemonJPA> nomPokemon) {
		super();
		this.idDresseur = idDresseur;
		this.nomDresseur = nomDresseur;
		this.nomPokemon = nomPokemon;
	}
	public DresseurJPA(String nomDresseur) {
		super();
		this.nomDresseur = nomDresseur;
	}
	public DresseurJPA(int idDresseur) {
		super();
		this.idDresseur = idDresseur;
	}
	

}