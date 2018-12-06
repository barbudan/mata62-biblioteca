package Exemplares;

public class Disponivel implements EstadoExemplar {
	String status;

	@Override
	public void alteraDisponibilidade(Exemplar e) {
		e.setEstado(new Disponivel());
		status = "Disponivel";
	}

	public String toString() {
		return this.status;
	}

}
