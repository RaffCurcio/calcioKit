package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Ordine {
	private int idOrdine;
	private Date dataInserimento;
	private BigDecimal prezzoVendita;
	private double ivaCout;
	private String statoOrdine;
	private String usernameCliente;
	private String emailCliente;

	public Ordine() {
	}

	public Ordine(int idOrdine, Date dataInserimento, BigDecimal prezzoVendita, double ivaCout, String statoOrdine,
			String usernameCliente, String emailCliente) {
		this.idOrdine = idOrdine;
		this.dataInserimento = dataInserimento;
		this.prezzoVendita = prezzoVendita;
		this.ivaCout = ivaCout;
		this.statoOrdine = statoOrdine;
		this.usernameCliente = usernameCliente;
		this.emailCliente = emailCliente;
	}

	// Metodi getter e setter

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public String getEmailCliente() {
		return emailCliente;
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
		return usernameCliente;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
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

	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}
}
