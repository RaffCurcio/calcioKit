package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Ordine {
	private int idOrdine;
	private Date dataInserimento;
	private BigDecimal prezzoVendita;
	private double ivaCout;
	private String statoOrdine;
	private String username_cli;
	private String email_cli;

	public Ordine() {
	}

	public Ordine(int idOrdine, Date dataInserimento, BigDecimal prezzoVendita, double ivaCout, String statoOrdine,
			String username_cli, String email_cli) {
		this.idOrdine = idOrdine;
		this.dataInserimento = dataInserimento;
		this.prezzoVendita = prezzoVendita;
		this.ivaCout = ivaCout;
		this.statoOrdine = statoOrdine;
		this.username_cli = username_cli;
		this.email_cli = email_cli;
	}

	// Metodi getter e setter

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public String getEmailCliente() {
		return email_cli;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public double getIvaCout() {
		return ivaCout;
	}

	public BigDecimal getPrezzoVendita() {
		return prezzoVendita;
	}

	public String getStatoOrdine() {
		return statoOrdine;
	}

	public String getUsernameCliente() {
		return username_cli;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public void setEmailCliente(String email_cli) {
		this.email_cli = email_cli;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public void setIvaCout(double ivaCout) {
		this.ivaCout = ivaCout;
	}

	public void setPrezzoVendita(BigDecimal prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
	}

	public void setStatoOrdine(String statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	public void setUsernameCliente(String username_cli) {
		this.username_cli = username_cli;
	}
}
