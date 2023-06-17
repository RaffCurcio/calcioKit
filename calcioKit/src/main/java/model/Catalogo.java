package model;

public class Catalogo {
	private String nomeCatalogo;
	private String descrizione;

	// Costruttori
	public Catalogo() {
	}

	public Catalogo(String nomeCatalogo, String descrizione) {
		this.nomeCatalogo = nomeCatalogo;
		this.descrizione = descrizione;
	}

	// Metodi getter e setter
	// ...

	// Override del metodo toString()
	@Override
	public String toString() {
		return "Catalogo [nomeCatalogo=" + nomeCatalogo + ", descrizione=" + descrizione + "]";
	}
}
