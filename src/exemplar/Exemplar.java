package exemplar;


public class Exemplar {
	private String codigoExemplar;
	private EstadoExemplar estado;

	public Exemplar(String codigoExemplar) {
		this.codigoExemplar = codigoExemplar;
		this.estado = new Disponivel();
	}

	public String getCodigoExemplar() {
		return codigoExemplar;
	}

	public String getNomeEstadoExemplar() {
		return estado.getClass().getName();
	}

	public void setEstado(EstadoExemplar novoEstado) {
		estado = novoEstado;
	}

	public EstadoExemplar getEstado() {
		return this.estado;
	}
	
	public void disponibilizarExemplar() {
		estado.disponibilizarExemplar(this);
	}
	
	public void emprestarExemplar() {
		estado.emprestarExemplar(this);
	}
	
	public void reservarExemplar() {
		estado.reservarExemplar(this);
	}

}
