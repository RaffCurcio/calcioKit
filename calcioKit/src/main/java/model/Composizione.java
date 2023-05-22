package model;

public class Composizione {
    private int idProdotto;
    private int idOrdine;
    private double prezzo_vendita;
    private String username;
    private String email;

    public Composizione() {
    }

    public Composizione(int idProdotto, int idOrdine, double prezzo_vendita) {
        this.idProdotto = idProdotto;
        this.idOrdine = idOrdine;
        this.prezzo_vendita = prezzo_vendita;
        
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
    
    
}

