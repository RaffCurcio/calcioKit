package model;

public class Telefono {
	private String numeroTelefono;
	private String prefisso;
	private String usernameCliente;
	private String emailCliente;

	public Telefono() {
	}

	public Telefono(String numeroTelefono, String prefisso, String usernameCliente, String emailCliente) {
		this.numeroTelefono = numeroTelefono;
		this.prefisso = prefisso;
		this.usernameCliente = usernameCliente;
		this.emailCliente = emailCliente;
	}

	// Metodi getter e setter

	public String getEmailCliente() {
		return emailCliente;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public String getPrefisso() {
		return prefisso;
	}

	public String getUsernameCliente() {
		return usernameCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public void setPrefisso(String prefisso) {
		this.prefisso = prefisso;
	}

	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}
}
