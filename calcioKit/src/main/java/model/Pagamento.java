package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Pagamento {
	private Date dataPagamento;
	private Date dataScadenza;
	private int idOrdine;
	private int idPagamento;
	private BigDecimal importoPagamento;
	private String numeroCarta;
	private String titolareConto;

	public Pagamento() {
	}

	// Metodi getter e setter

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public BigDecimal getImportoPagamento() {
		return importoPagamento;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public String getTitolareConto() {
		return titolareConto;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public void setImportoPagamento(BigDecimal importoPagamento) {
		this.importoPagamento = importoPagamento;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public void setTitolareConto(String titolareConto) {
		this.titolareConto = titolareConto;
	}
}
