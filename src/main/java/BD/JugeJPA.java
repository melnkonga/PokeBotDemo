package BD;

import javax.persistence.Id;

@javax.persistence.Entity
public class JugeJPA {
	
	@Id
	private int idJuge;
	
	private String nomJuge;

	public JugeJPA(String nomJuge) {
		super();
		this.nomJuge = nomJuge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomJuge == null) ? 0 : nomJuge.hashCode());
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
		JugeJPA other = (JugeJPA) obj;
		if (nomJuge == null) {
			if (other.nomJuge != null)
				return false;
		} else if (!nomJuge.equals(other.nomJuge))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JugeJPA [nomJuge=" + nomJuge + "]";
	}

	public String getNomJuge() {
		return nomJuge;
	}

	public void setNomJuge(String nomJuge) {
		this.nomJuge = nomJuge;
	}


}
