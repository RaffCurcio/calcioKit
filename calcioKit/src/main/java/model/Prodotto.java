package model;

import java.math.BigDecimal;

public class Prodotto {
	private boolean cancellato;
	private String descrizione;
	private int idProdotto;
	private double iva;
	private String nomeCatalogo;
	private String nomeProdotto;
	private String path_immagine;
	private BigDecimal prezzo;

	// Costruttori
	public Prodotto() {
	}

	public Prodotto(int idProdotto, String nomeProdotto, BigDecimal prezzo, String descrizione, double iva,
			String path_immagine, String nomeCatalogo) {
		this.idProdotto = idProdotto;
		this.nomeProdotto = nomeProdotto;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.iva = iva;
		this.path_immagine = path_immagine;
		this.nomeCatalogo = nomeCatalogo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	// Metodi getter e setter
	// ...
	public int getIdProdotto() {
		return idProdotto;
	}

	public double getIva() {
		return iva;
	}

	public String getNomeCatalogo() {
		return nomeCatalogo;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public String getPath_immagine() {
		return path_immagine;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public boolean isCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public void setNomeCatalogo(String nomeCatalogo) {
		this.nomeCatalogo = nomeCatalogo;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public void setPath_immagine(String path_immagine) {
		this.path_immagine = path_immagine;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	// Override del metodo toString()
	@Override
	public String toString() {
		return "Prodotto [idProdotto=" + idProdotto + ", nomeProdotto=" + nomeProdotto + ", prezzo=" + prezzo
				+ ", descrizione=" + descrizione + ", iva=" + iva + ", nomeCatalogo=" + nomeCatalogo + "]";
	}

}
