package Exemplares;

public class Disponivel implements EstadoExemplar {

	@Override
	public void alteraDisponibilidade(Exemplar e) {
		e.setEstado(new Disponivel());
	}
	
	public String toString(){
		return "Disponivel";
	}

}
