package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Spedizione {
	private BigDecimal costiExtra;
	private BigDecimal costiSpedizione;
	private Date dataSpedizione;
	private int idOrdine;
	private int idSpedizione;

	public Spedizione() {
	}

	public Spedizione(int idSpedizione, Date dataSpedizione, BigDecimal costiSpedizione, BigDecimal costiExtra,
			int idOrdine) {
		this.idSpedizione = idSpedizione;
		this.dataSpedizione = dataSpedizione;
		this.costiSpedizione = costiSpedizione;
		this.costiExtra = costiExtra;
		this.idOrdine = idOrdine;
	}

	// Metodi getter e setter

	public BigDecimal getCostiExtra() {
		return costiExtra;
	}

	public BigDecimal getCostiSpedizione() {
		return costiSpedizione;
	}

	public Date getDataSpedizione() {
		return dataSpedizione;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public int getIdSpedizione() {
		return idSpedizione;
	}

	public void setCostiExtra(BigDecimal costiExtra) {
		this.costiExtra = costiExtra;
	}

	public void setCostiSpedizione(BigDecimal costiSpedizione) {
		this.costiSpedizione = costiSpedizione;
	}

	public void setDataSpedizione(Date dataSpedizione) {
		this.dataSpedizione = dataSpedizione;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public void setIdSpedizione(int idSpedizione) {
		this.idSpedizione = idSpedizione;
	}
}
