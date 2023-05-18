package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Spedizione {
    private int idSpedizione;
    private Date dataSpedizione;
    private BigDecimal costiSpedizione;
    private BigDecimal costiExtra;
    private int idOrdine;

    public Spedizione() {
    }

    public Spedizione(int idSpedizione, Date dataSpedizione, BigDecimal costiSpedizione, BigDecimal costiExtra, int idOrdine) {
        this.idSpedizione = idSpedizione;
        this.dataSpedizione = dataSpedizione;
        this.costiSpedizione = costiSpedizione;
        this.costiExtra = costiExtra;
        this.idOrdine = idOrdine;
    }

    // Metodi getter e setter

    public int getIdSpedizione() {
        return idSpedizione;
    }

    public void setIdSpedizione(int idSpedizione) {
        this.idSpedizione = idSpedizione;
    }

    public Date getDataSpedizione() {
        return dataSpedizione;
    }

    public void setDataSpedizione(Date dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    public BigDecimal getCostiSpedizione() {
        return costiSpedizione;
    }

    public void setCostiSpedizione(BigDecimal costiSpedizione) {
        this.costiSpedizione = costiSpedizione;
    }

    public BigDecimal getCostiExtra() {
        return costiExtra;
    }

    public void setCostiExtra(BigDecimal costiExtra) {
        this.costiExtra = costiExtra;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }
}

