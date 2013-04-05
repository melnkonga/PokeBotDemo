package fr.univaix.iut.progbd;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = PokeBot.FIND_ALL, query = "SELECT p FROM PokeBot p")   
})
public class PokeBot 
{
	@Id
	private String nom;
	private String owner;
	private int pv = 100;
	
	@ManyToOne
	private Pokemon typepokemon;	
	
    public static final String FIND_ALL = "findAllPokeBot";
    
    public PokeBot (String nom) {
    	this.nom = nom;
    }
    
	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}
	
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
				+ ((typepokemon == null) ? 0 : typepokemon.hashCode());
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
		if (typepokemon == null) {
			if (other.typepokemon != null)
				return false;
		} else if (!typepokemon.equals(other.typepokemon))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "PokeBot [nom=" + nom + ", owner=" + owner + ", typePokemon1="
				+ typepokemon + "]";
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

	public Pokemon getTypePokemon() {
		return typepokemon;
	}

	public void setTypePokemon(Pokemon typePokemon) {
		this.typepokemon = typePokemon;
	}
}
