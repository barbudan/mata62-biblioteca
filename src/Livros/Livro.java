package Livros;

import java.util.ArrayList;

import Exemplares.Exemplar;
import Usuarios.Observer;
import Usuarios.Subject;

public class Livro implements Subject {
	private String titulo;
	private int codigo;
	private int ano;
	private String edicao;
	private String editora;

	public Livro(String titulo, int codigo, int ano, String edicao, String editora) {
		this.titulo = titulo;
		this.codigo = codigo;
		this.ano = ano;
		this.edicao = edicao;
		this.editora = editora;
	}

	public ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	public ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	public ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
	public ArrayList<Autor> autores = new ArrayList<Autor>();
	public ArrayList<Observer> observers = new ArrayList<Observer>();

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAno() {
		return ano;
	}

	public String getEdicao() {
		return edicao;
	}

	public String getEditora() {
		return editora;
	}

	public boolean verificarEstado() {
		for (Exemplar e : exemplares) {
			if (e.getEstado().toString() == "Disponivel") {
				return true;
			}
		}
		return false;
	}

	public void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
		if (emprestimos.size() >= 2) {
			notificarObservers();
		}
	}

	public void addReserva(Reserva r) {
		reservas.add(r);
		if (reservas.size() >= 2) {
			notificarObservers();
		}
	}

	public void addExemplar(Exemplar e) {
		exemplares.add(e);
	}

	public void addAutor(Autor a) {
		autores.add(a);
	}

	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removerObserver(Observer o) {
		int n = observers.indexOf(o);
		if (n >= 0) {
			observers.remove(n);
		}

	}

	@Override
	public void notificarObservers() {
		// TODO Auto-generated method stub

	}

	public int getNumExemplaresDisponiveis() {
		int exemplaresDisponiveis = 0;
		for (Exemplar e : exemplares) {
			if (e.getEstado().toString() == "Disponivel") {
				exemplaresDisponiveis++;
			}
		}
		return exemplaresDisponiveis;
	}

	// Verifica se tem menos reservas que exemplares disponiveis
	// Se sim, retorna true
	public boolean comparaReservasExemplares() {
		if (this.getNumExemplaresDisponiveis() > reservas.size()) {
			return true;
		}
		return false;
	}

	public int getNumReservas() {
		int numReservas = reservas.size();
		return numReservas;
	}

}
