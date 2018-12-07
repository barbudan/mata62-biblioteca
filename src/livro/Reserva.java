package livro;

import java.time.LocalDate;

public class Reserva {
	LocalDate dataReserva;
	String titulo;
	int codigoLivro;
	String nomeUsuario;
	int codigoUsuario;

	public Reserva(String titulo, int codigoLivro, String nomeUsuario, int codigoUsuario) {
		this.dataReserva = LocalDate.now();
		this.titulo = titulo;
		this.codigoLivro = codigoLivro;
		this.nomeUsuario = nomeUsuario;
		this.codigoUsuario = codigoUsuario;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
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

}
