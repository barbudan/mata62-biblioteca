package Exemplares;

public class Reservado implements EstadoExemplar {
	String status;

	@Override
	public void alteraDisponibilidade(Exemplar e) {
		e.setEstado(new Reservado());
		status = "Reservado";
	}

	public String toString() {
		return this.status;
	}

}
