package exemplar;

public class Emprestado implements EstadoExemplar {
	
	
	public void disponibilizarExemplar(Exemplar e) {
		e.setEstado(new Disponivel());
		System.out.println("Exemplar disponibilizado com sucesso");
	}
	
	public void emprestarExemplar(Exemplar e) {
		System.out.println("Este Exemplar já está Emprestado");
	}
	
	public void reservarExemplar(Exemplar e) {
		e.setEstado(new Reservado());
		System.out.println("Exemplar Reservado com Sucesso");
	}

	public boolean estaDisponivel() {
		return false;
	}
	
	public boolean estaReservado() {
		return false;
	}
	
	public boolean estaEmprestado() {
		return true;
	}
	
}
