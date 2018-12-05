package Exemplares;

import Livros.Livro;

public class Exemplar extends Livro {
	EstadoExemplar Estado;

	public Exemplar(String titulo, int codigo, int ano, String edicao, String editora, EstadoExemplar Emprestado)	{
		super(titulo, codigo, ano, edicao, editora);
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
