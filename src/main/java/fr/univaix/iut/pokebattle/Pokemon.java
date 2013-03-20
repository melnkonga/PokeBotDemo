package fr.univaix.iut.pokebattle;

public class Pokemon {
	public Pokemon(String nomPoke, String criPoke) {
		super();
		this.nomPoke = nomPoke;
		this.criPoke = criPoke;
		PV=100;
	}

	public int getPV() {
		return PV;
	}

	public void setPV(int pV) {
		PV = pV;
	}

	String nomPoke;
	String criPoke;
	String ownerPoke;
	int PV;
	public Pokemon() {
		// TODO Auto-generated constructor stub

	}

	public Pokemon(String nomPoke, String criPoke, String ownerPoke) {
		super();
		this.nomPoke = nomPoke;
		this.criPoke = criPoke;
		this.ownerPoke = ownerPoke;
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
