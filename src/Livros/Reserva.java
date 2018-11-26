package Livros;

import java.time.LocalDate;

public class Reserva {

	String titulo;
	int codigoLivro;
	String nomeUsuario;
	int codigoUsuario;
	LocalDate dataReserva;
	
	public Reserva(int codigoUsuario, int codigoLivro, String titulo, String nomeUsuario) {
		this.codigoUsuario = codigoUsuario;
		this.codigoLivro = codigoLivro;
		this.titulo = titulo;
		this.nomeUsuario = nomeUsuario;
		this.dataReserva = LocalDate.now();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public int getCodigoLivro() {
		return codigoLivro;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

}
