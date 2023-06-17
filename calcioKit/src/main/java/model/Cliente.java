package model;

public class Cliente {
	private String username;
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String citta;
	private String provincia;
	private String cap;
	private String ruolo_cliente;

	public Cliente() {
	}

	public Cliente(String username, String email, String password, String nome, String cognome, String indirizzo,
			String citta, String provincia, String cap, String ruolo_cliente) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
		this.ruolo_cliente = ruolo_cliente;
	}

	// Metodi getter e setter

	public String getCap() {
		return cap;
	}

	public String getCitta() {
		return citta;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public String getPassword() {
		return password;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getRuolo_cliente() {
		return ruolo_cliente;
	}

	public String getUsername() {
		return username;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setRuolo_cliente(String ruolo_cliente) {
		this.ruolo_cliente = ruolo_cliente;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
