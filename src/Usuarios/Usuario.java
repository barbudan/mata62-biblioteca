package Usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

import Livros.Emprestimo;
import Livros.Reserva;

public abstract class Usuario {

	private String nomeUsuario;
	private int codigoUsuario;
	private int numReservas = 0;
	private int notificacoes = 0;
	private int numEmprestimos = 0;

	public ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	public ArrayList<Reserva> reservas = new ArrayList<Reserva>();

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

	public int getNumEmprestimos() {
		return numEmprestimos;
	}

	public void addNumReservas() {
		this.numReservas++;
	}

	public void addNumEmprestimos() {
		this.numEmprestimos++;
	}

	public void subNumEmprestimos() {
		this.numEmprestimos--;
	}

	public void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
	}

	public Emprestimo getEmprestimo(int codigo) {
		for (Emprestimo e : emprestimos) {
			if (e.getCodigoLivro() == codigo) {
				return e;
			}
		}
		return null;
	}

	public void removeEmprestimo(Emprestimo e) {
		int index = emprestimos.indexOf(e);
		if (index >= 0) {
			emprestimos.remove(index);
		}
	}

	// verifica, através do código do livro, se o usuário já tem reserva do livro
	public boolean verificaReserva(int codigo) {
		for (Reserva r : reservas) {
			if (r.getCodigoLivro() == codigo) {
				return true;
			}
		}
		return false;
	}

	public boolean verificaDebito() {
		LocalDate dataAtual = LocalDate.now();
		for (Emprestimo e : emprestimos) {
			LocalDate dataPrevista = e.getDataPrevistaDevolucao();
			if (dataAtual.isAfter(dataPrevista)) {
				return true;
			}
		}
		return false;

	}
}
