package model;

public class Prodotto {
    private int idProdotto;
    private String nomeProdotto;
    private double prezzo;
    private String descrizione;
    private double iva;
    private String nomeCatalogo;

    // Costruttori
    public Prodotto() {}

    public Prodotto(int idProdotto, String nomeProdotto, double prezzo, String descrizione, double iva, String nomeCatalogo) {
        this.idProdotto = idProdotto;
        this.nomeProdotto = nomeProdotto;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.iva = iva;
        this.nomeCatalogo = nomeCatalogo;
    }

    // Metodi getter e setter
    // ...
    

    // Override del metodo toString()
    @Override
    public String toString() {
        return "Prodotto [idProdotto=" + idProdotto + ", nomeProdotto=" + nomeProdotto + ", prezzo=" + prezzo +
                ", descrizione=" + descrizione + ", iva=" + iva + ", nomeCatalogo=" + nomeCatalogo + "]";
    }

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public String getNomeCatalogo() {
		return nomeCatalogo;
	}

	public void setNomeCatalogo(String nomeCatalogo) {
		this.nomeCatalogo = nomeCatalogo;
	}
}

