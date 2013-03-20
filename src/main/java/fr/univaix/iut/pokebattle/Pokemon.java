package fr.univaix.iut.pokebattle;

public class Pokemon {
	public Pokemon(String nomPoke, String criPoke) {
		super();
		this.nomPoke = nomPoke;
		this.criPoke = criPoke;
	}

	String nomPoke;
	String criPoke;
	String ownerPoke;
	String attaque1Poke;

	public String getAttaque1Poke() {
		return attaque1Poke;
	}

	public void setAttaque1Poke(String attaque1Poke) {
		this.attaque1Poke = attaque1Poke;
	}

	public Pokemon() {
		// TODO Auto-generated constructor stub

	}

	public Pokemon(String nomPoke, String criPoke, String ownerPoke, String attaque1Poke) {
		super();
		this.nomPoke = nomPoke;
		this.criPoke = criPoke;
		this.ownerPoke = ownerPoke;
		this.attaque1Poke = attaque1Poke;
	}

	@Override
	public String toString() {
		return "Pokemon [nomPoke=" + nomPoke + ", criPoke=" + criPoke
				+ ", ownerPoke=" + ownerPoke + "]";
	}

	public String getNomPoke() {
		return nomPoke;
	}

	public String getCriPoke() {
		return criPoke;
	}

	public String getOwnerPoke() {
		return ownerPoke;
	}

	public void setNomPoke(String nomPoke) {
		this.nomPoke = nomPoke;
	}

	public void setCriPoke(String criPoke) {
		this.criPoke = criPoke;
	}

	public void setOwnerPoke(String ownerPoke) {
		this.ownerPoke = ownerPoke;
	}
}
