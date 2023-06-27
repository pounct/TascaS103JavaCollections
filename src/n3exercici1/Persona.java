package n3exercici1;

import java.util.Objects;

public class Persona {
	
	private String nom;
	private String cognom;
	private String DNI;
	public Persona(String nom, String cognom, String dNI) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		DNI = dNI;
	}
	public String getNom() {
		return nom;
	}
	public String getCognom() {
		return cognom;
	}
	public String getDNI() {
		return DNI;
	}
	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(DNI, other.DNI);
	}
	@Override
	public String toString() {
		return nom + "  " + cognom + "  " + DNI;
	}
	
	

}
