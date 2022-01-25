package datos;

public class Contacto {
	
	private long idContacto;
	private String email;
	private String movil;
	private String fijo;
	private Cliente cliente; //Al ser bidireccional tiene que estar el Cliente en la clase Contacto de otra forma hay un error de Mapeo
	
	public Contacto() {}

	public Contacto(String email, String movil, String fijo, Cliente cliente) {
		super();
		this.email = email;
		this.movil = movil;
		this.fijo = fijo;
		this.cliente = cliente;
	}

	public long getIdContacto() {
		return idContacto;
	}

	protected void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getFijo() {
		return fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", email=" + email + ", movil=" + movil + ", fijo=" + fijo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fijo == null) ? 0 : fijo.hashCode());
		result = prime * result + ((movil == null) ? 0 : movil.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		Contacto objeto = (Contacto) obj; //Casteo para evitar triplicarlo en el return
		
		return  objeto.getEmail().equalsIgnoreCase(this.getEmail()) &&
				objeto.getFijo().equals(this.getFijo()) &&
				objeto.getMovil().equals(this.getMovil());
	}
}
