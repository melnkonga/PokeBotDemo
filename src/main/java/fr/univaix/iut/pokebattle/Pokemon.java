package fr.univaix.iut.pokebattle;

public class Pokemon {
	public Pokemon(String nomPoke, String criPoke) {
		super();
		this.nomPoke = nomPoke;
		this.criPoke = criPoke;
	}

	public int getPV() {
		return pv;
	}

	public void setPV(int pV) {
		pv = pV;
	}
	
	public int getPP() {
		return pp;
	}
	
	public void setPP(int pP) {
		pp = pP;
	}

	private String nomPoke;
	private String criPoke;
	private String ownerPoke;
	// pv max
	private int pv = 100;
	// pp max
	private int pp = 35; 
	private int level = 1;
	private int exp = 0;
	private int pVCourant = 0;
	private int pPCourant = 10;

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
		return pVCourant;
	}
	
	public int getPPCourant() {
		return pPCourant;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setPVCourant(int pVCourant) {
		pVCourant = pVCourant;
	}
	
	public void setPPCourant(int pPCourant) {
		pPCourant = pPCourant;
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
