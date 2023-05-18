package model;

import java.util.Date;

public class Ordine {
    private int idOrdine;
    private Date dataInserimento;
    private double prezzoVendita;
    private double ivaCout;
    private String statoOrdine;
    private String usernameCliente;
    private String emailCliente;

    public Ordine() {
    }

    public Ordine(int idOrdine, Date dataInserimento, double prezzoVendita, double ivaCout, String statoOrdine, String usernameCliente, String emailCliente) {
        this.idOrdine = idOrdine;
        this.dataInserimento = dataInserimento;
        this.prezzoVendita = prezzoVendita;
        this.ivaCout = ivaCout;
        this.statoOrdine = statoOrdine;
        this.usernameCliente = usernameCliente;
        this.emailCliente = emailCliente;
    }

    // Metodi getter e setter

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Date getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(Date dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public double getIvaCout() {
        return ivaCout;
    }

    public void setIvaCout(double ivaCout) {
        this.ivaCout = ivaCout;
    }

    public String getStatoOrdine() {
        return statoOrdine;
    }

    public void setStatoOrdine(String statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    public String getUsernameCliente() {
        return usernameCliente;
    }

    public void setUsernameCliente(String usernameCliente) {
        this.usernameCliente = usernameCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}

