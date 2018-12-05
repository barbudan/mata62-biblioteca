package Livros;

import java.util.ArrayList;

import Exemplares.Exemplar;
import Usuarios.Observer;

public class Livro {
	// falta implementar a interface Subject
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

	public boolean verificaEstado() {
		for (Exemplar e : exemplares) {
			if (e.getEstado().toString() == "Disponivel") {
				return true;
			}
		}
		return false;
	}

	public void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
		// falta verificar se tem >= 2 emprestimos e notificar os observers
	}

	public void addReserva(Reserva r) {
		reservas.add(r);
		// falta verificar se reservas >= 2 e notificar os observers
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

	public int getNumExemplaresDisponiveis() {
		int exemplaresDisponiveis = 0;
		for (Exemplar e : exemplares) {
			if (e.getEstado().toString() == "Disponivel") {
				exemplaresDisponiveis++;
			}
		}
		return exemplaresDisponiveis;
	}

	public int getNumReservas() {
		int numReservas = reservas.size();
		return numReservas;
	}

}
