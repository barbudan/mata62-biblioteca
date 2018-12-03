package Exemplares;

public class Reservado implements EstadoExemplar {

	@Override
	public void alteraDisponibilidade(Exemplar e) {
		e.setEstado(new Reservado());
	}

	public String toString() {
		return "Reservado";
	}

}
