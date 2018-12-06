package Exemplares;

public class Emprestado implements EstadoExemplar {
	String status;

	@Override
	public void alteraDisponibilidade(Exemplar e) {
		e.setEstado(new Emprestado());
		status = "Emprestado";
	}

	public String toString() {
		return this.status;
	}

}
