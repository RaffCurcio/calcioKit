package model;

import java.math.BigDecimal;

public class Composizione {
	private int idProdotto;
	private int idOrdine;
	private BigDecimal prezzo_vendita;
	private int quantita_prodotto;
	private String username;
	private String email;

	public Composizione() {
	}

	// Metodi getter e setter

	public String getEmail() {
		return email;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public BigDecimal getPrezzo_vendita() {
		return prezzo_vendita;
	}

	public int getQuantita_prodotto() {
		return quantita_prodotto;
	}

	public String getUsername() {
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public void setPrezzo_vendita(BigDecimal prezzo_vendita) {
		this.prezzo_vendita = prezzo_vendita;
	}

	public void setQuantita_prodotto(int quantita_prodotto) {
		this.quantita_prodotto = quantita_prodotto;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
