package Usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario {

	private String nomeUsuario;
	private int codigoUsuario;
	private int numReservas = 0;
	private int notificacoes = 0;
	private int numEmprestimos = 0;

	public Usuario(int codigo, String nome) {
		this.codigoUsuario = codigo;
		this.nomeUsuario = nome;
	}

	public int getCodigo() {
		return codigoUsuario;
	}

	public String getNome() {
		return this.nomeUsuario;
	}

	public int getNotificacoes() {
		return notificacoes;
	}

}
