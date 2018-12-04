package Livros;

import java.time.LocalDate;

import Usuarios.Usuario;

public class Emprestimo {
	Livro livro;
	private String codigoExemplar;
	LocalDate dataEmprestimo;
	Usuario usuario;
	LocalDate dataPrevistaDevolucao;
	LocalDate dataDevolucaoReal;

	public Emprestimo(Usuario u, Livro l, int n, String codigoExemplar) {
		this.usuario = u;
		this.livro = l;
		this.dataEmprestimo = LocalDate.now();
		this.codigoExemplar = codigoExemplar;
		this.dataPrevistaDevolucao = LocalDate.now().plusDays(n);
	}

	public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}

	public Livro getLivro() {
		return livro;
	}

	public String getCodigoExemplar() {
		return codigoExemplar;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

}
