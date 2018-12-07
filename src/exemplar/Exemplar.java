package exemplar;


public class Exemplar {
	private String codigoExemplar;
	private EstadoExemplar estado;

	public Exemplar(String codigoExemplar, EstadoExemplar estadoInicial) {
		this.codigoExemplar = codigoExemplar;
		this.estado = estadoInicial;
	}

	public String getCodigoExemplar() {
		return codigoExemplar;
	}

	public String getStatusExemplar() {
		return estado.toString();
	}

	public void setEstado(EstadoExemplar novoEstado) {
		estado = novoEstado;
	}

	public EstadoExemplar getEstado() {
		return this.estado;
	}

}
