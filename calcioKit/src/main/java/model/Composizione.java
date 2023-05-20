package model;

public class Composizione {
    private int idProdotto;
    private int idOrdine;
    private double prezzo_vendita;
    private int quantita_prodotto;
    private String username;
    private String email;

    public Composizione() {
    }

   

    // Metodi getter e setter

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

	public double getPrezzo_vendita() {
		return prezzo_vendita;
	}

	public void setPrezzo_vendita(double prezzo_vendita) {
		this.prezzo_vendita = prezzo_vendita;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public int getQuantita_prodotto() {
		return quantita_prodotto;
	}



	public void setQuantita_prodotto(int quantita_prodotto) {
		this.quantita_prodotto = quantita_prodotto;
	}
    
    
}

