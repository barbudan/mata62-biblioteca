package livro;

import java.time.LocalDate;

public class Reserva {
	private LocalDate dataReserva;
	private String titulo;
	private int codigoLivro;
	private String nomeUsuario;
	private int codigoUsuario;

	public Reserva(String titulo, int codigoLivro, String nomeUsuario, int codigoUsuario) {
		this.dataReserva = LocalDate.now();
		this.titulo = titulo;
		this.codigoLivro = codigoLivro;
		this.nomeUsuario = nomeUsuario;
		this.codigoUsuario = codigoUsuario;
	}

	
	// GETTERS && SETTERS //
	
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
