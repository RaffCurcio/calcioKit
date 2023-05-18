package model;

public class Composizione {
    private int idProdotto;
    private int idOrdine;

    public Composizione() {
    }

    public Composizione(int idProdotto, int idOrdine) {
        this.idProdotto = idProdotto;
        this.idOrdine = idOrdine;
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
}

