package Exemplares;

import Livros.Livro;

public class Exemplar {
	private String codigoExemplar;
	Livro livro;
	EstadoExemplar Estado;

	public Exemplar(String codigoExemplar, EstadoExemplar Emprestado) {
		this.codigoExemplar = codigoExemplar;
		Estado = Emprestado;
	}

	public String getCodigoExemplar() {
		return codigoExemplar;
	}

	public String getStatusExemplar() {
		return Estado.toString();
	}

	public void setEstado(EstadoExemplar novoEstado) {
		Estado = novoEstado;
	}

	public EstadoExemplar getEstado() {
		return this.Estado;
	}

}
