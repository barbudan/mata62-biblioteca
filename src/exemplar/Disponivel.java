package exemplar;

public class Disponivel implements EstadoExemplar {
	
	public void disponibilizarExemplar(Exemplar e) {
		System.out.println("Este Exemplar já está disponibilizado");
	}
	
	public void emprestarExemplar(Exemplar e) {
		e.setEstado(new Emprestado());
		System.out.println("Exemplar emprestado com sucesso");
	}
	
	public void reservarExemplar(Exemplar e) {
		e.setEstado(new Reservado());
		System.out.println("Exemplar reservado com sucesso");
	}
	
	public boolean estaDisponivel() {
		return true;
	}
	
	public boolean estaReservado() {
		return false;
	}
	
	public boolean estaEmprestado() {
		return false;
	}

}
