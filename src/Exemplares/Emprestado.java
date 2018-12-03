package Exemplares;

public class Emprestado implements EstadoExemplar {

	@Override
	public void alteraDisponibilidade(Exemplar e) {
		e.setEstado(new Emprestado());
	}

	public String toString() {
		return "Emprestado";
	}
}
