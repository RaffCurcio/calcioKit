package model;

public class Telefono {
	private String email_cli;
	private String numeroTelefono;
	private String prefisso;
	private String username_cli;

	public Telefono() {
	}

	public Telefono(String numeroTelefono, String prefisso, String username_cli, String email_cli) {
		this.numeroTelefono = numeroTelefono;
		this.prefisso = prefisso;
		this.username_cli = username_cli;
		this.email_cli = email_cli;
	}

	// Metodi getter e setter

	public String getEmailCliente() {
		return email_cli;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public String getPrefisso() {
		return prefisso;
	}

	public String getUsernameCliente() {
		return username_cli;
	}

	public void setEmailCliente(String email_cli) {
		this.email_cli = email_cli;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public void setPrefisso(String prefisso) {
		this.prefisso = prefisso;
	}

	public void setUsernameCliente(String username_cli) {
		this.username_cli = username_cli;
	}
}
