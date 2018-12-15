package exemplar;


public class Exemplar {
	private String codigoExemplar;
	private EstadoExemplar estado;

	public Exemplar(String codigoExemplar) {
		this.codigoExemplar = codigoExemplar;
		this.estado = new Disponivel();
	}

	// GETTERS && SETTERS //
	public String getCodigoExemplar() {
		return codigoExemplar;
	}

	public String getNomeEstadoExemplar() {
		String classeNome = String.valueOf(estado.getClass());
		return classeNome.substring(classeNome.indexOf('.')+1);
	}

	public EstadoExemplar getEstado() {
		return this.estado;
	}
	
	public void setEstado(EstadoExemplar novoEstado) {
		estado = novoEstado;
	}
	
	// METODOS PADRAO STATE //
	
	public void disponibilizarExemplar() {
		estado.disponibilizarExemplar(this);
	}
	
	public void emprestarExemplar() {
		estado.emprestarExemplar(this);
	}
	
	public void reservarExemplar() {
		estado.reservarExemplar(this);
	}
	
	// METODOS VERIFICACAO //

	public boolean estaDisponivel() {
		if(estado.estaDisponivel())
			return true;
		return false;
	}
	
	public boolean estaReservado() {
		if(estado.estaReservado())
			return true;
		return false;
	}
	
	public boolean estaEmprestado() {
		if(estado.estaEmprestado())
			return true;
		return false;
	}
}
