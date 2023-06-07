package model;

public class Locazione {
	private int idProdotto;
	private String nomeMagazzino;
	private String indirizzoMagazzino;
	private String cittàMagazzino;

	public Locazione() {
	}

	public Locazione(int idProdotto, String nomeMagazzino, String indirizzoMagazzino, String cittàMagazzino) {
		this.idProdotto = idProdotto;
		this.nomeMagazzino = nomeMagazzino;
		this.indirizzoMagazzino = indirizzoMagazzino;
		this.cittàMagazzino = cittàMagazzino;
	}

	// Metodi getter e setter

	public String getCittàMagazzino() {
		return cittàMagazzino;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public String getIndirizzoMagazzino() {
		return indirizzoMagazzino;
	}

	public String getNomeMagazzino() {
		return nomeMagazzino;
	}

	public void setCittàMagazzino(String cittàMagazzino) {
		this.cittàMagazzino = cittàMagazzino;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public void setIndirizzoMagazzino(String indirizzoMagazzino) {
		this.indirizzoMagazzino = indirizzoMagazzino;
	}

	public void setNomeMagazzino(String nomeMagazzino) {
		this.nomeMagazzino = nomeMagazzino;
	}
}
