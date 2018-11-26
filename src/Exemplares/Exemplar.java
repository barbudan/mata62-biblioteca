package Exemplares;

import Livros.Livro;

public class Exemplar extends Livro {
	EstadoExemplar Estado;

	public Exemplar(int codigo, EstadoExemplar Emprestado)	{
		super(codigo);
		Estado = Emprestado;
	}
	
	public void setEstado(EstadoExemplar novoEstado) {
		Estado = novoEstado;	
	}

	
	public String getStatusExemplar(){
		return Estado.toString();
	}
	
	public EstadoExemplar getEstado(){
		return this.Estado;
	}


}
