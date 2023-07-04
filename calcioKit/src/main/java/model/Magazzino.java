package model;

public class Magazzino {
	private String città;
	private String indirizzo;
	private String nomeMagazzino;

	public Magazzino() {
	}

	public Magazzino(String nomeMagazzino, String indirizzo, String città) {
		this.nomeMagazzino = nomeMagazzino;
		this.indirizzo = indirizzo;
		this.città = città;
	}

	// Metodi getter e setter

	public String getCittà() {
		return città;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getNomeMagazzino() {
		return nomeMagazzino;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setNomeMagazzino(String nomeMagazzino) {
		this.nomeMagazzino = nomeMagazzino;
	}
}
