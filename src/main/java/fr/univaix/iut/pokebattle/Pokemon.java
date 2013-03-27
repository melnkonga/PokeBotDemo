package fr.univaix.iut.pokebattle;

public class Pokemon {
	public Pokemon(String nomPoke, String criPoke) {
		super();
		this.nomPoke = nomPoke;
		this.criPoke = criPoke;
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
	int PV = 100; // pv max
	int level = 1;
	int exp = 0;
	int PVCourant = 0;

	public Pokemon() {
		// TODO Auto-generated constructor stub

	}

	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public int getPVCourant() {
		return PVCourant;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setPVCourant(int pVCourant) {
		PVCourant = pVCourant;
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
