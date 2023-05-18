package model;

public class Magazzino {
    private String nomeMagazzino;
    private String indirizzo;
    private String città;

    public Magazzino() {
    }

    public Magazzino(String nomeMagazzino, String indirizzo, String città) {
        this.nomeMagazzino = nomeMagazzino;
        this.indirizzo = indirizzo;
        this.città = città;
    }

    // Metodi getter e setter

    public String getNomeMagazzino() {
        return nomeMagazzino;
    }

    public void setNomeMagazzino(String nomeMagazzino) {
        this.nomeMagazzino = nomeMagazzino;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }
}

