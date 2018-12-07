package exemplar;

public class Emprestado implements EstadoExemplar {
	
	public void disponibilizarExemplar(Exemplar e) {
		e.setEstado(new Disponivel());
		System.out.println("Exemplar disponibilizado com sucesso");
	}
	
	public void emprestarExemplar(Exemplar e) {
		System.out.println("Este Exemplar j� est� Emprestado");
	}
	
	public void reservarExemplar(Exemplar e) {
		System.out.println("Este Exemplar n�o pode ser Reservado pois est� Emprestado");
	}

}
