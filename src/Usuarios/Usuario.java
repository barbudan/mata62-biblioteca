package Usuarios;

import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Usuario{

	private String nome;
	private int codigo;
	private int numReservas = 1;
	private int notificacoes = 0;
	private int numEmprestimos = 0;
	
	
	public Usuario(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return this.nome;
	}	
	
	public int getNotificacoes() {
		return notificacoes;
	}
	
	
}
