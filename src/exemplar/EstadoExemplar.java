package exemplar;

// PADRAO STATE //

public interface EstadoExemplar {
	public void disponibilizarExemplar(Exemplar e);
	public void emprestarExemplar(Exemplar e);
	public void reservarExemplar(Exemplar e);
	public boolean estaDisponivel();
	public boolean estaReservado();
	public boolean estaEmprestado();
}
