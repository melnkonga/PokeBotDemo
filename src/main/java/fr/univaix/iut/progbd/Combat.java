package fr.univaix.iut.progbd;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Combat {
	
	private String arène;
	
	@Id
	private int id;
	private Juge_Combat juge;
	private PokeBot pokemon1;
	private PokeBot pokemon2;
	private PokeBot winner;
	public Combat() {
		super();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combat other = (Combat) obj;
		if (arène == null) {
			if (other.arène != null)
				return false;
		} else if (!arène.equals(other.arène))
			return false;
		if (id != other.id)
			return false;
		if (juge == null) {
			if (other.juge != null)
				return false;
		} else if (!juge.equals(other.juge))
			return false;
		if (pokemon1 == null) {
			if (other.pokemon1 != null)
				return false;
		} else if (!pokemon1.equals(other.pokemon1))
			return false;
		if (pokemon2 == null) {
			if (other.pokemon2 != null)
				return false;
		} else if (!pokemon2.equals(other.pokemon2))
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}
	public String getArène() {
		return arène;
	}
	public int getId() {
		return id;
	}
	public Juge_Combat getJuge() {
		return juge;
	}
	public PokeBot getPokemon1() {
		return pokemon1;
	}
	public PokeBot getPokemon2() {
		return pokemon2;
	}
	public PokeBot getWinner() {
		return winner;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arène == null) ? 0 : arène.hashCode());
		result = prime * result + id;
		result = prime * result + ((juge == null) ? 0 : juge.hashCode());
		result = prime * result
				+ ((pokemon1 == null) ? 0 : pokemon1.hashCode());
		result = prime * result
				+ ((pokemon2 == null) ? 0 : pokemon2.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
		return result;
	}
	public void setArène(String arène) {
		this.arène = arène;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setJuge(Juge_Combat juge) {
		this.juge = juge;
	}
	public void setPokemon1(PokeBot pokemon1) {
		this.pokemon1 = pokemon1;
	}
	public void setPokemon2(PokeBot pokemon2) {
		this.pokemon2 = pokemon2;
	}
	public void setWinner(PokeBot winner) {
		this.winner = winner;
	}
	@Override
	public String toString() {
		return "Combat [id=" + id + ", pokemon1=" + pokemon1 + ", pokemon2="
				+ pokemon2 + ", winner=" + winner + ", juge=" + juge
				+ ", arène=" + arène + "]";
	}
	
}
