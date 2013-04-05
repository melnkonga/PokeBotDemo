package fr.univaix.iut.progbd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Combat {
	
	
	
	@Id
	@GeneratedValue
	private int id_combat;
	
	private String arene;
	public Combat(int id_combat, String arene, Juge_Combat juge,
			PokeBot pokemon1, PokeBot pokemon2) {
		super();
		this.id_combat = id_combat;
		this.arene = arene;
		this.juge = juge;
		this.pokemon1 = pokemon1;
		this.pokemon2 = pokemon2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arene == null) ? 0 : arene.hashCode());
		result = prime * result + (encour ? 1231 : 1237);
		result = prime * result + id_combat;
		result = prime * result + ((juge == null) ? 0 : juge.hashCode());
		result = prime * result
				+ ((pokemon1 == null) ? 0 : pokemon1.hashCode());
		result = prime * result
				+ ((pokemon2 == null) ? 0 : pokemon2.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
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
		Combat other = (Combat) obj;
		if (arene == null) {
			if (other.arene != null)
				return false;
		} else if (!arene.equals(other.arene))
			return false;
		if (encour != other.encour)
			return false;
		if (id_combat != other.id_combat)
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
	@Override
	public String toString() {
		return "Combat [id_combat=" + id_combat + ", "
				+ (arene != null ? "arene=" + arene + ", " : "")
				+ (juge != null ? "juge=" + juge + ", " : "")
				+ (pokemon1 != null ? "pokemon1=" + pokemon1 + ", " : "")
				+ (pokemon2 != null ? "pokemon2=" + pokemon2 + ", " : "")
				+ (winner != null ? "winner=" + winner + ", " : "") + "encour="
				+ encour + "]";
	}
	public String getArene() {
		return arene;
	}
	public void setArene(String arene) {
		this.arene = arene;
	}
	public Juge_Combat getJuge() {
		return juge;
	}
	public void setJuge(Juge_Combat juge) {
		this.juge = juge;
	}
	public PokeBot getPokemon1() {
		return pokemon1;
	}
	public void setPokemon1(PokeBot pokemon1) {
		this.pokemon1 = pokemon1;
	}
	public PokeBot getPokemon2() {
		return pokemon2;
	}
	public void setPokemon2(PokeBot pokemon2) {
		this.pokemon2 = pokemon2;
	}
	public PokeBot getWinner() {
		return winner;
	}
	public void setWinner(PokeBot winner) {
		this.winner = winner;
	}
	public boolean isEncour() {
		return encour;
	}
	public void setEncour(boolean encour) {
		this.encour = encour;
	}
	@ManyToOne
	private Juge_Combat juge;
	@ManyToOne
	private PokeBot pokemon1;
	@ManyToOne
	private PokeBot pokemon2;
	@ManyToOne
	private PokeBot winner;
	
	boolean encour=true;
	public Combat() {
		super();
	}
	
	
}
