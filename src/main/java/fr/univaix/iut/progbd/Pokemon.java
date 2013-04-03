package fr.univaix.iut.progbd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import GSON.BDGSONLoading;
import GSON.DataObjectPokemon;

import com.google.gson.Gson;

@Entity
@NamedQueries({
        @NamedQuery(name = Pokemon.FIND_ALL, query = "SELECT p FROM Pokemon p"),
        @NamedQuery(name = Pokemon.FIND_BY_TYPE, query = "SELECT p FROM Pokemon p WHERE p.type1 = :ftype")
})
public class Pokemon {
	
	@Id
	@OneToMany(targetEntity = PokeBot.class, mappedBy = "typePokemon")
	private String nom;

    public static final String FIND_BY_TYPE = "findPokemonByType";
    public static final String FIND_ALL = "findAllPokemon";

	static int pv = 100;
	private String espece;
	private float taille;
	private float poids;
	private float fmratio;
	private String effortval;
	private String type1;
	private String type2;
	private int expval;
	private int expmax;
	private int captureval;	 	
	private String capspe1;
 	private String capspe2;
	private String couleur;
	private int forme;
	private String owner;
	private static String cri;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capspe1 == null) ? 0 : capspe1.hashCode());
		result = prime * result + ((capspe2 == null) ? 0 : capspe2.hashCode());
		result = prime * result + captureval;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((cri == null) ? 0 : cri.hashCode());
		result = prime * result
				+ ((effortval == null) ? 0 : effortval.hashCode());
		result = prime * result + ((espece == null) ? 0 : espece.hashCode());
		result = prime * result + expmax;
		result = prime * result + expval;
		result = prime * result + Float.floatToIntBits(fmratio);
		result = prime * result + forme;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + Float.floatToIntBits(poids);
		result = prime * result + Float.floatToIntBits(taille);
		result = prime * result + ((type1 == null) ? 0 : type1.hashCode());
		result = prime * result + ((type2 == null) ? 0 : type2.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (capspe1 == null) {
			if (other.capspe1 != null)
				return false;
		} else if (!capspe1.equals(other.capspe1))
			return false;
		if (capspe2 == null) {
			if (other.capspe2 != null)
				return false;
		} else if (!capspe2.equals(other.capspe2))
			return false;
		if (captureval != other.captureval)
			return false;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (cri == null) {
			if (other.cri != null)
				return false;
		} else if (!cri.equals(other.cri))
			return false;
		if (effortval == null) {
			if (other.effortval != null)
				return false;
		} else if (!effortval.equals(other.effortval))
			return false;
		if (espece == null) {
			if (other.espece != null)
				return false;
		} else if (!espece.equals(other.espece))
			return false;
		if (expmax != other.expmax)
			return false;
		if (expval != other.expval)
			return false;
		if (Float.floatToIntBits(fmratio) != Float
				.floatToIntBits(other.fmratio))
			return false;
		if (forme != other.forme)
			return false;
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
		if (Float.floatToIntBits(poids) != Float.floatToIntBits(other.poids))
			return false;
		if (Float.floatToIntBits(taille) != Float.floatToIntBits(other.taille))
			return false;
		if (type1 == null) {
			if (other.type1 != null)
				return false;
		} else if (!type1.equals(other.type1))
			return false;
		if (type2 == null) {
			if (other.type2 != null)
				return false;
		} else if (!type2.equals(other.type2))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pokemon [nom=" + nom + ", espece=" + espece + ", taille="
				+ taille + ", poids=" + poids + ", fmratio=" + fmratio
				+ ", effortval=" + effortval + ", type1=" + type1 + ", type2="
				+ type2 + ", expval=" + expval + ", expmax=" + expmax
				+ ", captureval=" + captureval + ", capspe1=" + capspe1
				+ ", capspe2=" + capspe2 + ", couleur=" + couleur + ", forme="
				+ forme + ", owner=" + owner + ", cri=" + cri + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public static int getPv() {
		return pv;
	}
	public static void setPv(int pv) {
		Pokemon.pv = pv;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	public float getTaille() {
		return taille;
	}
	public void setTaille(float taille) {
		this.taille = taille;
	}
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	public float getFmratio() {
		return fmratio;
	}
	public void setFmratio(float fmratio) {
		this.fmratio = fmratio;
	}
	public String getEffortval() {
		return effortval;
	}
	public void setEffortval(String effortval) {
		this.effortval = effortval;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public int getExpval() {
		return expval;
	}
	public void setExpval(int expval) {
		this.expval = expval;
	}
	public int getExpmax() {
		return expmax;
	}
	public void setExpmax(int expmax) {
		this.expmax = expmax;
	}
	public int getCaptureval() {
		return captureval;
	}
	public void setCaptureval(int captureval) {
		this.captureval = captureval;
	}
	public String getCapspe1() {
		return capspe1;
	}
	public void setCapspe1(String capspe1) {
		this.capspe1 = capspe1;
	}
	public String getCapspe2() {
		return capspe2;
	}
	public void setCapspe2(String capspe2) {
		this.capspe2 = capspe2;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getForme() {
		return forme;
	}
	public void setForme(int forme) {
		this.forme = forme;
	}
	public String getCri() {
		return cri;
	}
	public void setCri(String cri) {
		this.cri = cri;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Pokemon(String nom, String espece, float taille, float poids,
			float fmratio, String effortval, String type1, String type2,
			int expval, int expmax, int captureval, String capspe1,
			String capspe2, String couleur, int forme) {
		super();
		this.nom = nom;
		this.espece = espece;
		this.taille = taille;
		this.poids = poids;
		this.fmratio = fmratio;
		this.effortval = effortval;
		this.type1 = type1;
		this.type2 = type2;
		this.expval = expval;
		this.expmax = expmax;
		this.captureval = captureval;
		this.capspe1 = capspe1;
		this.capspe2 = capspe2;
		this.couleur = couleur;
		this.forme = forme;
	}
	public Pokemon(String nom) {
		super();
		this.nom = nom;
	}
	
	public Pokemon(){
		
	}
	
	public static Pokemon createPokemon(String name, String owner) 
	{
		Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new InputStreamReader(BDGSONLoading.class.getClassLoader().getResourceAsStream("pokedex.json")));
		DataObjectPokemon[] obj = gson.fromJson(br, DataObjectPokemon[].class);
		Object[] pokemonC = GSON.BDGSONLoading.FindCaracPokemon(name,obj);
		Pokemon pokemon = new Pokemon(name);
		pokemon.setNom(name);
		pokemon.setCapspe1((String) pokemonC[0]);
		pokemon.setCapspe2((String) pokemonC[1]);
		pokemon.setCaptureval((Integer) pokemonC[2]);
		pokemon.setCouleur((String) pokemonC[3]);
		pokemon.setEffortval((String) pokemonC[4]);
		pokemon.setEspece((String) pokemonC[5]);
		pokemon.setExpmax((Integer) pokemonC[6]);
		pokemon.setExpval((Integer) pokemonC[7]);
		pokemon.setFmratio((Float) pokemonC[8]);
		pokemon.setForme((Integer) pokemonC[9]);
		pokemon.setPoids((Float) pokemonC[10]);
		pokemon.setTaille((Float) pokemonC[11]);
		pokemon.setType1((String) pokemonC[12]);
		pokemon.setType2((String) pokemonC[13]);
		pokemon.setOwner(owner);
		Pokemon.setPv(pv);
		pokemon.setCri(cri);
		return pokemon;
	}
	
	

}
