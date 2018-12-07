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
		System.out.println("Este Exemplar não pode ser Reservado pois está Emprestado");
	}

}
