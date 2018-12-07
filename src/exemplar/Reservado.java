package exemplar;

public class Reservado implements EstadoExemplar {
	
	public void disponibilizarExemplar(Exemplar e) {
		e.setEstado(new Disponivel());
		System.out.println("Exemplar disponibilizado com sucesso");
	}
	
	public void emprestarExemplar(Exemplar e) {
		e.setEstado(new Emprestado());
		System.out.println("Exemplar emprestado com sucesso");
	}
	
	public void reservarExemplar(Exemplar e) {
		System.out.println("Este Exemplar já está Reservado");
	}

}
