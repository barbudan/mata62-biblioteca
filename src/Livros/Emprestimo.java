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
	private String status = "";
	
	
	public Emprestimo(Usuario usuario, Livro livro, int numDias, String codigoExemplar) {
		this.usuario = usuario;
		this.livro = livro;
		this.dataEmprestimo = LocalDate.now();
		this.dataPrevistaDevolucao = LocalDate.now().plusDays(numDias);
		this.codigoExemplar = codigoExemplar;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}


	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}


	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}


	public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}


	public LocalDate getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}


	public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}


	public String getCodigoExemplar() {
		return codigoExemplar;
	}


	public void setCodigoExemplar(String codigoExemplar) {
		this.codigoExemplar = codigoExemplar;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	

}
