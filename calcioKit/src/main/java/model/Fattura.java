package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Fattura {
	private int idFattura;
	private Date dataFattura;
	private int anno;
	private BigDecimal ivaFattura;
	private int idPagamento;

	public Fattura() {
	}

	public Fattura(int idFattura, Date dataFattura, int anno, BigDecimal ivaFattura, int idPagamento) {
		this.idFattura = idFattura;
		this.dataFattura = dataFattura;
		this.anno = anno;
		this.ivaFattura = ivaFattura;
		this.idPagamento = idPagamento;
	}

	// Metodi getter e setter

	public int getAnno() {
		return anno;
	}

	public Date getDataFattura() {
		return dataFattura;
	}

	public int getIdFattura() {
		return idFattura;
	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public BigDecimal getIvaFattura() {
		return ivaFattura;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setDataFattura(Date dataFattura) {
		this.dataFattura = dataFattura;
	}

	public void setIdFattura(int idFattura) {
		this.idFattura = idFattura;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public void setIvaFattura(BigDecimal ivaFattura) {
		this.ivaFattura = ivaFattura;
	}
}
