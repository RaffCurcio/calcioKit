package model;

public class Prodotto {
    private int idProdotto;
    private String nomeProdotto;
    private double prezzo;
    private String descrizione;
    private double iva;
    private String nomeCatalogo;
    private String path_immagine;

    // Costruttori
    public Prodotto() {}

    public Prodotto(int idProdotto, String nomeProdotto, double prezzo, String descrizione, double iva, String path_immagine , String nomeCatalogo) {
        this.idProdotto = idProdotto;
        this.nomeProdotto = nomeProdotto;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.iva = iva;
        this.path_immagine = path_immagine;
        this.nomeCatalogo = nomeCatalogo;
    }

    // Metodi getter e setter
    // ...
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
	
	public String getPath_immagine() {
		return path_immagine;
	}

	public void setPath_immagine(String path_immagine) {
		this.path_immagine = path_immagine;
	}

	public String getNomeCatalogo() {
		return nomeCatalogo;
	}

	public void setNomeCatalogo(String nomeCatalogo) {
		this.nomeCatalogo = nomeCatalogo;
	}


    // Override del metodo toString()
    @Override
    public String toString() {
        return "Prodotto [idProdotto=" + idProdotto + ", nomeProdotto=" + nomeProdotto + ", prezzo=" + prezzo +
                ", descrizione=" + descrizione + ", iva=" + iva + ", nomeCatalogo=" + nomeCatalogo + "]";
    }

}

