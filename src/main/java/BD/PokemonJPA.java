package BD;

import javax.persistence.Id;

@javax.persistence.Entity
public class PokemonJPA 
{	
	@Id
	private int idPokemon;

	public int getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(int idPokemon) {
		this.idPokemon = idPokemon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPokemon;
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
		PokemonJPA other = (PokemonJPA) obj;
		if (idPokemon != other.idPokemon)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PokemonJPA [idPokemon=" + idPokemon + "]";
	}

	public PokemonJPA(int idPokemon) {
		super();
		this.idPokemon = idPokemon;
	}
	
}
