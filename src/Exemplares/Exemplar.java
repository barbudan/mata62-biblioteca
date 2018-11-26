package Exemplares;

import Livros.Livro;

public class Exemplar extends Livro {
	private String codigoEx;
	EstadoExemplar Estado;

	public Exemplar(int codigo, String codigoEx, EstadoExemplar Emprestado)	{
		super(codigo);
		this.codigoEx = codigoEx;
		Estado = Emprestado;
	}
	
	public void setEstado(EstadoExemplar novoEstado) {
		Estado = novoEstado;	
	}
		
	public String getCodigoEx(){
		return codigoEx;
	}
	
	public String getStatusExemplar(){
		return Estado.toString();
	}
	
	public EstadoExemplar getEstado(){
		return this.Estado;
	}


}
