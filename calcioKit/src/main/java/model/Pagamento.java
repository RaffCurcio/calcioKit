package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Pagamento {
    private int idPagamento;
    private Date dataPagamento;
    private BigDecimal importoPagamento;
    private String tipoPagamento;
    private String numeroCarta;
    private Date dataScadenza;
    private String cvc;
    private String titolareConto;
    private String iban;
    private String bic;
    private String emailPayPal;
    private String passwordPayPal;
    private int idOrdine;

    public Pagamento() {
    }

    public Pagamento(int idPagamento, Date dataPagamento, BigDecimal importoPagamento, String tipoPagamento,
                     String numeroCarta, Date dataScadenza, String cvc, String titolareConto, String iban, String bic,
                     String emailPayPal, String passwordPayPal, int idOrdine) {
        this.idPagamento = idPagamento;
        this.dataPagamento = dataPagamento;
        this.importoPagamento = importoPagamento;
        this.tipoPagamento = tipoPagamento;
        this.numeroCarta = numeroCarta;
        this.dataScadenza = dataScadenza;
        this.cvc = cvc;
        this.titolareConto = titolareConto;
        this.iban = iban;
        this.bic = bic;
        this.emailPayPal = emailPayPal;
        this.passwordPayPal = passwordPayPal;
        this.idOrdine = idOrdine;
    }

    // Metodi getter e setter

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getImportoPagamento() {
        return importoPagamento;
    }

    public void setImportoPagamento(BigDecimal importoPagamento) {
        this.importoPagamento = importoPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getTitolareConto() {
        return titolareConto;
    }

    public void setTitolareConto(String titolareConto) {
        this.titolareConto = titolareConto;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getEmailPayPal() {
        return emailPayPal;
    }

    public void setEmailPayPal(String emailPayPal) {
        this.emailPayPal = emailPayPal;
    }

    public String getPasswordPayPal() {
        return passwordPayPal;
    }

    public void setPasswordPayPal(String passwordPayPal) {
        this.passwordPayPal = passwordPayPal;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }
}

